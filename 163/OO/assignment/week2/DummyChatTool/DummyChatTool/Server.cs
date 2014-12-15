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
namespace DummyChatTool
{
    [Serializable]
    public partial class Server : Form, ISerializable
    {
        private Server()
        {
            InitializeComponent();
            listClient = new List<Client>();
            Init();
        }

        private Server(SerializationInfo info, StreamingContext ctxt)
        {
 
        }


        private void Init()
        {
            if (System.IO.File.Exists("config.bin"))
            {
                Deserialize("config.bin");
            }
        }

        private void Serialize(string configFile)
        {
            System.IO.FileStream fs = new FileStream(configFile, FileMode.Create);
            BinaryWriter bw = new BinaryWriter(fs);
            bw.Write(listClient.Count);
            foreach(Client c in listClient)
            {
                
            }
           // bw.Write(this.textBox1.Text);
            //
            bw.Flush();
            //
            bw.Close();
            fs.Close();
        }

        private void Deserialize(string configFile)
        {

        }

        protected override void OnClosing(CancelEventArgs e)
        {
            Serialize("config");
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
                    Client client = new Client(name, this.GetContacts());
                    listClient.Add(client);
                    this.listBox_onlineUsers.Items.Add(name);
                    client.Show();
                    this.NotifyToAll(name);
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
            if (msg.getFlag() == 1)// welcome msg from new comer to all
            {

            }
            else if (msg.getFlag() == 2) // chat msg
            {
                Client c = GetClientByName(msg.getTo());
                if (c != null)
                {
                    c.RecvMessage(msg);
                }
            }
            else if (msg.getFlag() == 3) // goodbye msg
            {
                RemoveClient(msg.getFrom());
                foreach (Client c in listClient)
                {
                   c.RecvMessage(msg);
                }
            }
        }

        public void GetObjectData(SerializationInfo info, StreamingContext ctxt)
        {
            info.AddValue("client_num", listClient.Count);
            foreach (Client c in listClient)
            {
                info.AddValue("",c.getContacts().ToArray());
            }
        }
        /*
                public byte[] SerializeBinary(object request)
                {
                    System.Runtime.Serialization.Formatters.Binary.BinaryFormatter serializer = new System.Runtime.Serialization.Formatters.Binary.BinaryFormatter();
                    System.IO.MemoryStream memStream = new System.IO.MemoryStream();
                    serializer.Serialize(memStream, request);
                    return memStream.GetBuffer();
                }

                public object DeserializeBinary(byte[] buf)
                {
                    System.IO.MemoryStream memStream = new MemoryStream(buf);
                    memStream.Position = 0;
                    System.Runtime.Serialization.Formatters.Binary.BinaryFormatter deserializer =
                        new System.Runtime.Serialization.Formatters.Binary.BinaryFormatter();
                    object newobj = deserializer.Deserialize(memStream);
                    memStream.Close();
                    return newobj;
                }  
        */
        private static Server instance = null;
        private List<Client> listClient;
    }
}
