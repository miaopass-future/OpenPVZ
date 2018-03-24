
/*
 * 运行时线程
 */
package Control;

import javax.swing.JPanel;
import GUI.MainFrame;
import GUI.RuntimePanel;
import PVZ.Context;
import PVZ.ShareDate;


public class RuntimeControl extends JPanel implements Runnable {

	
	//主窗口
	MainFrame mf;
	
	//共享对象
	ShareDate shareDate;

	//需要传入窗口
	public RuntimeControl(MainFrame mf, ShareDate shareDate) {
		this.mf = mf;
		this.shareDate = shareDate;
	}
	
	
	public void run() {
		
		//新建运行时画布兼线程
		RuntimePanel rp = new RuntimePanel(shareDate);
		Thread rpT = new Thread(rp);
		rpT.start();
		
/*		//把画布引用放到集合
		shareDate.getShareP().put("rp", rp);
		*/
		
		//去除默认布局
		rp.setLayout(null);
		//设置透明
		rp.setOpaque(false);
		//设置尺寸大小
		rp.setBounds(0, 0, Context.WIDTH, Context.HEIGHT);
		
		mf.getContentPane().add(rp);
		
		//游戏尺寸设置成运行时
		mf.setSize(Context.WIDTH,Context.HEIGHT);
		
		//mf.setContentPane(rp);	

	}

}
