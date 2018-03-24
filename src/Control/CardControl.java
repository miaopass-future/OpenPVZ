
/*
 * 植物卡槽线程
 */
package Control;

import java.awt.Image;
import GUI.CardPanel;
import GUI.MainFrame;
import PVZ.Context;
import PVZ.ShareDate;

public class CardControl implements Runnable {

	public static Image followImage;
	//主窗口
	MainFrame mf;
	
	//共享对象
	ShareDate shareDate;
	
	//需要传入窗口
	public CardControl(MainFrame mf, ShareDate shareDate) {
		this.mf = mf;
		this.shareDate = shareDate;
	}
	
	public void run() {
		
		/*
		 * 新创建一个卡槽画布
		 * 设置卡槽画布大小后
		 * 然后添加到主画布之中
		 * 为了不造成遮挡作用
		 * 需要把背景设置为透明
		 * 
		 */
		CardPanel cp = new CardPanel();

		//把画布引用放到集合
		shareDate.getShareP().put("cp", cp);
		
		//去除默认布局
		cp.setLayout(null);
		//设置透明
		cp.setOpaque(false);
		//设置尺寸大小
		cp.setBounds(0, 0, Context.WIDTH, Context.HEIGHT);
		//把此画布添加到主画布中
		mf.getContentPane().add(cp);
		
		mf.getContentPane().repaint();
		mf.repaint();
		
	}
	
}
