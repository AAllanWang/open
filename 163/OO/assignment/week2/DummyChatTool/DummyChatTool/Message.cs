using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System.Runtime.Serialization;

namespace DummyChatTool
{
    [Serializable]
    public class Message : ISerializable
    {
        private Message(SerializationInfo info, StreamingContext ctxt)
        {
 
        }
        public Message(string from, string to, string time, string content, int flag)
        {
            setFrom(from);
            setTo(to);
            setTime(time);
            setContent(content);
            setFlag(flag);
        }
        public string getFrom()
        {
            return strFrom;
        }
        public void setFrom(string str)
        {
            strFrom = str;
        }
        public string getTo()
        {
            return strTo;
        }
        public void setTo(string str)
        {
            strTo = str;
        }
        public string getTime()
        {
            return strTime;
        }
        public void setTime(string str)
        {
            strTime = str;
        }
        public int getFlag()
        {
            return iFlag;
        }
        public void setFlag(int i)
        {
            iFlag = i;
        }
        public string getContent()
        {
            return strContent;
        }
        public void setContent(string str)
        {
            strContent = str;
        }
        public void GetObjectData(SerializationInfo info, StreamingContext ctxt)
        {

        }

        private string strFrom;
        private string strTo;
        private string strTime;
        private string strContent;
        private int iFlag;
    }
}
