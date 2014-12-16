using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;


namespace DummyChatTool
{
    public partial class Client : Form
    {
        public Client(string name,List<string> contacts)
        {
            InitializeComponent();
            listMsg = new List<Message>();
            this.name = name;
            listContacts = contacts;
            this.Text = "当前用户: " + this.name;
            this.comboBox_currentUser.Items.Clear();
            foreach (string str in listContacts)
            {
                if (str != this.name)
                {
                    this.comboBox_currentUser.Items.Add(str);
                }
            }
        }

        private void Client_Load(object sender, EventArgs e)
        {

        }
        public string GetName()
        {
            return name;
        }


        private void SendMessage(DummyChatTool.Message msg)
        {
            Message m = new Message(msg.From,msg.To,msg.Time,msg.Content,4);
            //this.textBox_msgHist.Text += "to:  " + msg.To + "    " + msg.Time + Environment.NewLine + msg.Content + Environment.NewLine;
            Server.GetInstance().ForwardMessage(m);
            Server.GetInstance().ForwardMessage(msg);
        }

        public void RecvMessage(DummyChatTool.Message msg)
        {
            listMsg.Add(msg);
            if (msg.Flag == 1)
            {
                if (!this.listContacts.Contains(msg.From))
                {
                    this.comboBox_currentUser.Items.Add(msg.From);
                    this.listContacts.Add(msg.From);
                }
            }
            else if (msg.Flag == 2)
            {
                this.textBox_msgHist.Text += "from:  " + msg.From + "    " + msg.Time + Environment.NewLine + msg.Content + Environment.NewLine;
            }
            else if (msg.Flag == 3)
            {
                this.comboBox_currentUser.Items.Remove(msg.From);
                this.listContacts.Remove(msg.From);
                //this.textBox_msgHist.Text += "from:  " + msg.From + "    " + msg.Time + Environment.NewLine + msg.Content + Environment.NewLine;
            }
            else if (msg.Flag == 4)
            {
                this.textBox_msgHist.Text += "to:  " + msg.To + "    " + msg.Time + Environment.NewLine + msg.Content + Environment.NewLine;
            }
        }


        private void button1_Click(object sender, EventArgs e)
        {
            string strMsg = this.textBox_msg.Text.Trim();
            if (this.comboBox_currentUser.Items.Count == 0)
            {
                MessageBox.Show("没有在线用户,不能聊天!");
                return;
            }
            string strTo = this.comboBox_currentUser.SelectedItem.ToString();
            
            if (strMsg == "")
            {
                MessageBox.Show("发送的信息不能为空!");
            }
            else if (strTo == "")
            {
                MessageBox.Show("请选择接收人!");
            }
            else
            {
                Message msg = new Message(this.GetName(), strTo, DateTime.Now.ToString(), strMsg, 2);
                SendMessage(msg);
            }
        }
        protected override void OnClosing(CancelEventArgs e)
        {
            Message msg = new Message(this.GetName(), "", DateTime.Now.ToString(), "已经退出聊天.", 3);
            Server.GetInstance().ForwardMessage(msg);
        }

        public List<Message> getMessageList()
        {
            return listMsg;
        }

        public List<string> getContacts()
        {
            return listContacts;
        }

        private string name;    
        private List<string> listContacts;
        private List<Message> listMsg;

    }
}
