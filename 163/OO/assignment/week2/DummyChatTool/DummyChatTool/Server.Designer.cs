namespace DummyChatTool
{
    partial class Server
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
            this.label_name = new System.Windows.Forms.Label();
            this.button_addNew = new System.Windows.Forms.Button();
            this.textBox_name = new System.Windows.Forms.TextBox();
            this.listBox_onlineUsers = new System.Windows.Forms.ListBox();
            this.label_onlineUserList = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label_name
            // 
            this.label_name.AutoSize = true;
            this.label_name.Location = new System.Drawing.Point(49, 32);
            this.label_name.Name = "label_name";
            this.label_name.Size = new System.Drawing.Size(34, 13);
            this.label_name.TabIndex = 3;
            this.label_name.Text = "姓名:";
            // 
            // button_addNew
            // 
            this.button_addNew.Location = new System.Drawing.Point(315, 27);
            this.button_addNew.Name = "button_addNew";
            this.button_addNew.Size = new System.Drawing.Size(102, 23);
            this.button_addNew.TabIndex = 1;
            this.button_addNew.Text = "创建仿真用户";
            this.button_addNew.UseVisualStyleBackColor = true;
            this.button_addNew.Click += new System.EventHandler(this.button_addNew_Click);
            // 
            // textBox_name
            // 
            this.textBox_name.Location = new System.Drawing.Point(89, 27);
            this.textBox_name.Name = "textBox_name";
            this.textBox_name.Size = new System.Drawing.Size(153, 20);
            this.textBox_name.TabIndex = 0;
            // 
            // listBox_onlineUsers
            // 
            this.listBox_onlineUsers.FormattingEnabled = true;
            this.listBox_onlineUsers.Location = new System.Drawing.Point(52, 110);
            this.listBox_onlineUsers.Name = "listBox_onlineUsers";
            this.listBox_onlineUsers.Size = new System.Drawing.Size(337, 173);
            this.listBox_onlineUsers.TabIndex = 2;
            // 
            // label_onlineUserList
            // 
            this.label_onlineUserList.AutoSize = true;
            this.label_onlineUserList.Location = new System.Drawing.Point(49, 80);
            this.label_onlineUserList.Name = "label_onlineUserList";
            this.label_onlineUserList.Size = new System.Drawing.Size(82, 13);
            this.label_onlineUserList.TabIndex = 4;
            this.label_onlineUserList.Text = "在线用户列表:";
            // 
            // Server
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(498, 325);
            this.Controls.Add(this.label_onlineUserList);
            this.Controls.Add(this.listBox_onlineUsers);
            this.Controls.Add(this.textBox_name);
            this.Controls.Add(this.button_addNew);
            this.Controls.Add(this.label_name);
            this.MaximizeBox = false;
            this.Name = "Server";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Server_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label_name;
        private System.Windows.Forms.Button button_addNew;
        private System.Windows.Forms.TextBox textBox_name;
        private System.Windows.Forms.ListBox listBox_onlineUsers;
        private System.Windows.Forms.Label label_onlineUserList;
    }
}

