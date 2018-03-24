
/*
 * 游戏开始线程
 * 
 */

package Control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import GUI.MainFrame;
import GUI.StartPanel;
import PVZ.Context;
import PVZ.ShareDate;

/*
 * 启动游戏线程此线程为游戏运行开始的线程
 */
public class StartControl implements Runnable{

	//主窗口
	MainFrame mf;
	
	//需要传入窗口
	public StartControl(MainFrame mf) {
		this.mf = mf;
		
	}
	
	public void run() {

		//绘制开始游戏画布
		StartPanel sp = new StartPanel();
		//去除默认布局
		sp.setLayout(null);
		//设置透明
		sp.setOpaque(false);
		//设置尺寸大小
		sp.setBounds(0, 0, Context.WIDTH, Context.HEIGHT);
		
		//创建共享对象
		ShareDate shareDate = new ShareDate();
		
		//游戏开始尺寸是不同的,在这我们把他从新设置
		mf.setSize(Context.WIDTH_S,Context.HEIGHT_S);
		
		//设置居中
		mf.setLocationRelativeTo(null);
		
		mf.getContentPane().add(sp);
		
		//鼠标监听
		sp.start.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				
				 //移除开始画布
				 mf.getContentPane().remove(sp);
				 //重写绘制一下主画布
				 mf.getContentPane().repaint();
				 
				 //启动卡槽线程和游戏运行时线程
				 startThread(shareDate);

			}

		});

	}
	
	private void startThread(ShareDate shareDate) {
		//游戏开始时进程
		RuntimeControl rc = new  RuntimeControl(mf, shareDate);
		Thread rTread = new Thread(rc);
		rTread.start();
		
		//植物卡槽线程
		CardControl cc = new CardControl(mf,shareDate);
		Thread cThread = new Thread(cc);
		cThread.start();
	}
}
