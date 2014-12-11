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
    public partial class FormTemplate : Form
    {
        public FormTemplate()
        {
            InitializeComponent();
        }

        private void init()
        {
            wizardMana = WizardManager.getInstance();
            if (wizardMana.isFormFirst(this.Name))
            {
                this.setPrevBtnEnabled(false);
            }
            if (wizardMana.isFormLast(this.Name))
            {
                this.setNextBtnEnabled(false);
            }
            width = 560;
            height = 350;
            int iActulaWidth = Screen.PrimaryScreen.Bounds.Width;
            int iActulaHeight = Screen.PrimaryScreen.Bounds.Height;

            this.SetBounds((iActulaWidth - width) / 2, (iActulaHeight-height)/2, width, height);

            this.checkBox_exam.Text += " ---  " + this.Text;
        }

        private void FormTemplate_Load(object sender, EventArgs e)
        {
            init();
        }

        public void setPrevBtnEnabled(bool isEnabled)
        {
            this.btn_prev.Enabled = isEnabled;
        }

        public void setNextBtnEnabled(bool isEnabled)
        {
            this.btn_next.Enabled = isEnabled;
        }

        public void setFinishBtnEnabled(bool isEnabled)
        {
            this.btn_finish.Enabled = isEnabled;
        }

        public void setCancelBtnEnabled(bool isEnabled)
        {
            this.btn_cancel.Enabled = isEnabled;
        }

        private void btn_prev_Click(object sender, EventArgs e)
        {
            if (this.btn_prev.Enabled)
            {
                this.Visible = false;
                FormTemplate f =  wizardMana.getPrevForm(this.Name);
                f.Visible = true;
                f.Show();
            }
        }

        private void btn_next_Click(object sender, EventArgs e)
        {
            if (this.btn_next.Enabled)
            {
                this.Visible = false;
                FormTemplate f = wizardMana.getNextForm(this.Name);
                f.Visible = true;
                f.Show();
            }
        }

        private void btn_finish_Click(object sender, EventArgs e)
        {
            string strRet = wizardMana.getTotalReslut();
            this.Visible = false;
            FormResult.getInstance().Visible = true;
            FormResult.getInstance().setResult("Finish \n" + strRet);
            FormResult.getInstance().Show();
        }

        private void btn_cancel_Click(object sender, EventArgs e)
        {
            string strRet = wizardMana.getTotalReslut();
            this.Visible = false;
            FormResult.getInstance().Visible = true;
            FormResult.getInstance().setResult("Cancel \n" + strRet);
            FormResult.getInstance().Show();
        }

        public string getResult()
        {
            string strRet = "";
            if(this.checkBox_exam.Checked)
            {
                strRet = this.Text + " is checked \n";
            }
            return strRet;
        }

        private WizardManager wizardMana = null;
        private int width;
        private int height;
    }
}
