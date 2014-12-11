using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Wizard
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            wizardMana.insertForm(new Form1());
            wizardMana.insertForm(new Form2());
            wizardMana.insertForm(new Form4());
            wizardMana.insertForm(new Form3());
            
            FormResult.getInstance().Hide();
            
            Application.Run();
        }

        private static WizardManager wizardMana = WizardManager.getInstance();
    }
}
