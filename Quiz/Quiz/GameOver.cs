using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Quiz
{
    public partial class GameOver : Form
    {
        /// <summary>
        /// デフォルトコンストラクタ
        /// </summary>
        public GameOver()
        {
            InitializeComponent();
        }

        /// <summary>
        /// 終了
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnClickFinishButton(object sender, EventArgs e)
        {
            Application.Exit();
        }

        /// <summary>
        /// 再開ボタン
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnClickRestartButton(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
