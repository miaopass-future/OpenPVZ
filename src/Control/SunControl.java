/*package Control;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import GUI.MainFrame;
import GUI.RuntimePanel;
import GUI.SunPanel;
import PVZ.Context;
import PVZ.Sun;

public class SunControl implements Runnable{

	//主窗口
	MainFrame mf;
	
	//集合
	public List<Sun> list = new ArrayList<Sun>();
	
	//需要传入窗口
	public SunControl(MainFrame mf) {
		this.mf = mf;
		
	}
	public ImageIcon images = new ImageIcon(Context.PATH_C + "PeashooterG.png");
	
	public void run() {
		
		SunPanel sp = new SunPanel();
		//去除默认布局
		sp.setLayout(null);
		//设置透明
		sp.setOpaque(false);
		//设置尺寸大小
		sp.setBounds(0, 0, Context.WIDTH, Context.HEIGHT);
		//添加画布
		mf.getContentPane().add(sp);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		    public  void run() {
		    	Sun sun = new Sun(images);
		    	list.add(sun);

		    }
		},1000,2000);
		
	}
	
	public void paintSun(Graphics g){;
		for(Sun s : list) {
			g.drawImage(s.getImages(), 0, 0, null);
		}
	}
}*/
