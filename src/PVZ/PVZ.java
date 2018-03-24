
/*
 * 主程序
 */
package PVZ;

import Control.StartControl;
import GUI.MainFrame;
import GUI.MainPanel;


public class PVZ {
	
	public static int sunSum = 50;
	
	//----已知bug 可能java swing问题. 需要多启动几次才能看到植物卡槽
	
	//线程状态码----暂时定义未使用-----
	public static boolean state = false;
	
	//程序运行将从这里开始
	public static void start() {
		
		//主框架
		MainFrame mf = new MainFrame();
		
		//主画布---所有画布都加载在这个上面---
		MainPanel mp = new MainPanel();
		mf.setContentPane(mp);
		
		//---------进入这个线程以后将利用监听器启动运行时线程-----------
		StartControl sc = new StartControl(mf);
		Thread sThread = new Thread(sc);
		sThread.start();
		
	}
	
	//程序主方法
	public static void main(String[] args) {
		
		//开始执行程序
		start();

	}
}
