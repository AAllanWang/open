using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Runtime.Serialization;

namespace DummyChatTool
{
    [Serializable]
    public class Message 
    {
        public Message()
        {
            From = "";
            To = "";
            Time = "";
            Content = "";
            Flag = 0;
        }
        public Message(string from, string to, string time, string content, int flag)
        {
            From = from;
            To=to;
            Time=time;
            Content=content;
            Flag=flag;
        }
        public string From
        {
            get { return strFrom; }
            set { strFrom = value; }
        }
        public string To
        {
            get { return strTo; }
            set { strTo = value; }
        }
        public string Time
        {
            get { return strTime; }
            set { strTime = value; }
        }
        public string Content
        {
            get { return strContent; }
            set { strContent = value; }
        }
        public int Flag
        {
            get { return iFlag; }
            set { iFlag = value; }
        }

        private string strFrom;
        private string strTo;
        private string strTime;
        private string strContent;
        private int iFlag; 
    }
}
