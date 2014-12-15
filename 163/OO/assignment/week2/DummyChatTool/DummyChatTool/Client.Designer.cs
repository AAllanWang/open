namespace DummyChatTool
{
    partial class Client
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.textBox_msg = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.textBox_msgHist = new System.Windows.Forms.TextBox();
            this.comboBox_currentUser = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(28, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(43, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "正在与";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(220, 32);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(31, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "聊天";
            // 
            // textBox_msg
            // 
            this.textBox_msg.Location = new System.Drawing.Point(31, 69);
            this.textBox_msg.Name = "textBox_msg";
            this.textBox_msg.Size = new System.Drawing.Size(286, 20);
            this.textBox_msg.TabIndex = 1;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(353, 67);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "发送";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox_msgHist
            // 
            this.textBox_msgHist.Location = new System.Drawing.Point(31, 113);
            this.textBox_msgHist.Multiline = true;
            this.textBox_msgHist.Name = "textBox_msgHist";
            this.textBox_msgHist.ScrollBars = System.Windows.Forms.ScrollBars.Both;
            this.textBox_msgHist.Size = new System.Drawing.Size(397, 188);
            this.textBox_msgHist.TabIndex = 3;
            // 
            // comboBox_currentUser
            // 
            this.comboBox_currentUser.FormattingEnabled = true;
            this.comboBox_currentUser.Location = new System.Drawing.Point(77, 29);
            this.comboBox_currentUser.Name = "comboBox_currentUser";
            this.comboBox_currentUser.Size = new System.Drawing.Size(137, 21);
            this.comboBox_currentUser.TabIndex = 6;
            // 
            // Client
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(477, 332);
            this.Controls.Add(this.comboBox_currentUser);
            this.Controls.Add(this.textBox_msgHist);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox_msg);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.Name = "Client";
            this.Text = "Client";
            this.Load += new System.EventHandler(this.Client_Load);
            
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox textBox_msg;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox_msgHist;
        private System.Windows.Forms.ComboBox comboBox_currentUser;
    }
}