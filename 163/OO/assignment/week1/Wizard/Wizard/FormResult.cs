using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Wizard
{
    public partial class FormResult : Form
    {
        private FormResult()
        {
            InitializeComponent();
            this.Hide();
            WizardManager.getInstance().getFirstForm().Show();
        }

        public static FormResult getInstance()
        {
            if (m_instance == null)
            {
                m_instance = new FormResult();
            }
            return m_instance;
        }
        private void FormResult_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        public void setResult(string strRet)
        {
            this.label1.Text = strRet;
        }

        public string getResult()
        {
            return this.label1.Text;
        }


        private static FormResult m_instance = null;
    }
}
