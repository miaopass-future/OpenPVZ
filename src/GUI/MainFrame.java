
/*
 * 游戏窗口
 * 此类继承了JFrame后会更好的进行初始设置
 */
package GUI;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame () {

		setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setTitle("植物大战僵尸");
		setVisible(true);

	}
}
