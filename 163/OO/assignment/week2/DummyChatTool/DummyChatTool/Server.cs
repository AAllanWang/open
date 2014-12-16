using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;
using System.Runtime.Serialization;
using System.Xml;
using System.Xml.Serialization;
using System.Reflection;
namespace DummyChatTool
{
    public partial class Server : Form
    {
        private Server()
        {
            InitializeComponent();
            listClient = new List<Client>();
            Init();
        }

        private void Init()
        {
            if (System.IO.File.Exists("config.xml"))
            {
                Deserialize("config.xml");
            }
        }

        private void Serialize(string configFile)
        {
            XmlDocument xmlDoc = new XmlDocument();
            xmlDoc.LoadXml("<Config></Config>");
            
            foreach (Client c in listClient)
            {
                XmlElement itemClient = xmlDoc.CreateElement("Client");
                itemClient.SetAttribute("Name", c.GetName());
                List<Message> listMsg = c.getMessageList();
                
                foreach (Message msg in listMsg)
                {
                    XmlElement elementMsg = xmlDoc.CreateElement("Message");
                    PropertyInfo[] properties = msg.GetType().GetProperties();
                    foreach (PropertyInfo property in properties)
                    {
                        if (property.GetValue(msg, null) != null)
                        {
                            XmlElement element = xmlDoc.CreateElement(property.Name);
                            element.SetAttribute("Type", property.PropertyType.Name);
                            element.InnerText = property.GetValue(msg, null).ToString();
                            elementMsg.AppendChild(element);
                        }
                    }
                    itemClient.AppendChild(elementMsg);
                }
                xmlDoc.DocumentElement.AppendChild(itemClient);
            }
            xmlDoc.Save(configFile);
        }

        private void Deserialize(string configFile)
        {
            List<string> listClientName = new List<string>();
            List<Message> listAllMsg = new List<Message>();

            XmlDocument XmlDoc = new XmlDocument();
            XmlDoc.Load(configFile);
            foreach (XmlNode itemClient in XmlDoc.GetElementsByTagName("Config").Item(0).ChildNodes)
            {
                string strClientName = itemClient.Attributes["Name"].Value;
                listClientName.Add(strClientName);
                foreach (XmlNode itemMsg in itemClient.ChildNodes)
                {
                    Message msg = Activator.CreateInstance<Message>();
                    PropertyInfo[] properties = typeof(Message).GetProperties();
                    foreach (XmlNode propertyNode in itemMsg.ChildNodes)
                    {
                        string name = propertyNode.Name;
                        string type = propertyNode.Attributes["Type"].Value;
                        string value = propertyNode.InnerXml;
                        foreach (PropertyInfo property in properties)
                        {
                            if (name == property.Name)
                            {
                                property.SetValue(msg, Convert.ChangeType(value, property.PropertyType), null);
                            }
                        }
                    }
                    listAllMsg.Add(msg);
                }
            }

            foreach (string strCli in listClientName)
            {

                AddNewUser(strCli, new List<string>(listClientName));
            }
            foreach (Message msg in listAllMsg)
            {
                ForwardMessage(msg);
            }
        }

        protected override void OnClosing(CancelEventArgs e)
        {
            Serialize("config.xml");
        }

        public static Server GetInstance()
        {
            if (instance == null)
            {
                instance = new Server();
            }

            return instance;
        }

        private void Server_Load(object sender, EventArgs e)
        {
            this.Text = "\"在线聊天\"仿真程序----单进程版";
        }

        private void AddNewUser(string strName,List<string> listCont)
        {
            Client client = new Client(strName, listCont);
            listClient.Add(client);
            this.listBox_onlineUsers.Items.Add(strName);
            client.Show();
            this.NotifyToAll(strName);
        }

        private void button_addNew_Click(object sender, EventArgs e)
        {
            string name = this.textBox_name.Text.Trim();
            if (name == "")
            {
                MessageBox.Show("姓名不可以为空!");
            }
            else
            {
                if (IsUserNameOK(name))
                {
                    AddNewUser(name, this.GetContacts());
                }
                else
                {
                    MessageBox.Show("姓名 "+name + "已经存在,请输入新的姓名!");
                }
            }
        }

        private bool IsUserNameOK(string name)
        {
            bool ret = true;
            if (name == "")
            {
                ret = false;
            }
            else
            {
                foreach (Client c in listClient)
                {
                    if (name == c.GetName())
                    {
                        ret = false;
                        break;
                    }
                }
            }
            return ret;
        }

        private List<string> GetContacts()
        {
            List<string> listContacts = new List<string>();
            foreach (Client c in listClient)
            {
                listContacts.Add(c.GetName());
            }

            return listContacts;
        }

        private Client GetClientByName(string name)
        {
            Client c = null;
            foreach (Client cTemp in listClient)
            {
                if (name == cTemp.GetName())
                {
                    c = cTemp;
                    break;
                }
            }
            return c;
        }

        public void RemoveClient(string name)
        {
            this.listBox_onlineUsers.Items.Remove(name);
            Client c = GetClientByName(name);
            if (c != null)
            {
                this.listClient.Remove(c);
            }
        }

        private void NotifyToAll(string name)
        {
            DummyChatTool.Message msg = new DummyChatTool.Message(name, "", DateTime.Now.ToString(), "", 1);
            foreach (Client c in listClient)
            {
                if (c.GetName() != name)
                {
                    c.RecvMessage(msg);
                }
            }
        }

        public void ForwardMessage(DummyChatTool.Message msg)
        {
            if (msg.Flag == 1)// welcome msg from new comer to all
            {

            }
            else if (msg.Flag == 2) // chat msg
            {
                Client c = GetClientByName(msg.To);
                if (c != null)
                {
                    c.RecvMessage(msg);
                }
            }
            else if (msg.Flag == 3) // goodbye msg
            {
                RemoveClient(msg.From);
                foreach (Client c in listClient)
                {
                   c.RecvMessage(msg);
                }
            }
            else if(msg.Flag==4) // to self
            {
                Client c = GetClientByName(msg.From);
                if (c != null)
                {
                    c.RecvMessage(msg);
                }
            }
        }

        private static Server instance = null;
        private List<Client> listClient;
    }
}
