using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Wizard
{
    class WizardManager
    {
        private WizardManager()
        {
            m_formList = new List<FormTemplate>();
            m_index = -1;
        }

        public static WizardManager getInstance()
        {
            if (m_instance == null)
            {
                m_instance = new WizardManager();
            }
            return m_instance;
        }

        public int insertForm(FormTemplate f)
        {
            m_formList.Add(f);
            return ++m_index;
        }

        public void removeForm(int index)
        {
            if (index > 0 && index <= m_index)
            {
                m_formList.RemoveAt(index);
                m_index--;
            }
        }

        public FormTemplate getFirstForm()
        {
            FormTemplate f = null;
            if (m_index < 0 )
            {
                // return null;
            }
            else
            {
                f = m_formList[0];
            }
            return f;
        }

        public FormTemplate getForm(int index)
        {
            FormTemplate f = null;
            if (index > m_index || index < 0)
            {
                // return null;
            }
            else
            {
                f = m_formList[index];
            }
            return f;

        }

        public FormTemplate getFormByName(string strName)
        {
            FormTemplate f = null;
            if (m_index > 0)
            {

            }

            return f;
        }

        public FormTemplate getPrevForm(string strName)
        {
            FormTemplate f = null;
            int i =0;
            if (!this.isFormFirst(strName))
            {
                foreach (FormTemplate tmp in m_formList)
                {
                    i++;
                    if (tmp.Name == strName)
                    {
                        break;
                    }
                }
                f = m_formList[i - 2];
            }
            return f;
        }

        public FormTemplate getNextForm(string strName)
        {
            FormTemplate f = null;
            int i = 0;
            if (!this.isFormLast(strName))
            {
                foreach (FormTemplate tmp in m_formList)
                {
                    i++;
                    if (tmp.Name == strName)
                    {
                        break;
                    }
                }
                f = m_formList[i];
            }
            return f;
        }

        public bool isFormFirst(string strName)
        {
            bool isFirst = false;
            if(null != this.getFirstForm())
            {
                isFirst = this.getFirstForm().Name == strName;
            }
            return isFirst;
        }

        public bool isFormLast(string strName)
        {
            bool isLast = false;
            if (null != this.getForm(this.getFormCnt() - 1))
            {
                isLast = this.getForm(this.getFormCnt() - 1).Name == strName;
            }
            return isLast;
        }

        public int getFormCnt()
        {
            return m_formList.Count();
        }

        public string getTotalReslut()
        {
            string strRet = "";
            foreach(FormTemplate f in m_formList)
            {
                strRet += f.getResult();
            }
            return strRet;
        }

        private int m_index;
        private List<FormTemplate> m_formList;
        private static WizardManager m_instance=null;
    }
}
