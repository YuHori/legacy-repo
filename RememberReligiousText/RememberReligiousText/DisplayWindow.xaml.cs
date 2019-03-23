using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace RememberReligiousText
{
    /// <summary>
    /// DisplayWindow.xaml の相互作用ロジック
    /// </summary>
    public partial class DisplayWindow : Window
    {
        // 現在の番号
        private int nowNumber;

        // 聖句数
        private int numberOfQuestion;

        /// <summary>
        /// デフォルトコンストラクタ
        /// </summary>
        public DisplayWindow()
        {
            InitializeComponent();

            // 0からスタート
            nowNumber = 0;

            // 問題数
            numberOfQuestion = MainWindow.orderArr.Length;

            // テキストボックスを整備
            SetTextBlock();
        }

        /// <summary>
        /// 本文を見る
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnClickOpenButton(object sender, RoutedEventArgs e)
        {
            Statement.Visibility = System.Windows.Visibility.Visible;
        }

        /// <summary>
        /// 次へボタン
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnClickNextButton(object sender, RoutedEventArgs e)
        {
            if (nowNumber == numberOfQuestion - 1)
            {
                MessageBoxResult result = MessageBox.Show("終了します。よろしいですか？", "確認",
                MessageBoxButton.YesNo,
                MessageBoxImage.Warning);
                if (result == MessageBoxResult.No)
                {

                    return;
                }

                // 最後
                this.Close();
            }
            else
            {
                nowNumber++;
                SetTextBlock();
            }


        }

        /// <summary>
        /// 戻るボタン
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void OnClickBackButton(object sender, RoutedEventArgs e)
        {
            if (nowNumber == 0)
            {
                MessageBoxResult result = MessageBox.Show("終了します。よろしいですか？", "確認",
                MessageBoxButton.YesNo,
                MessageBoxImage.Warning);
                if (result == MessageBoxResult.No) {

                    return;
                }

                this.Close();
            }
            else
            {
                nowNumber--;
                SetTextBlock();
            }
        }

        /// <summary>
        /// テキストを整備
        /// </summary>
        private void SetTextBlock()
        {
            // テキストブロックの内容を変更
            Place.Text = MainWindow.orderArr[nowNumber];
            Statement.Text = MainWindow.dic[MainWindow.orderArr[nowNumber]];

            if (CloseStatementCheck.IsChecked == true)
            {
                // 本文を隠す
                Statement.Visibility = System.Windows.Visibility.Hidden;
            }
        }
    }
}
