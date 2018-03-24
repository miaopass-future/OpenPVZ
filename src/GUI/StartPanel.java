
/*
 * 开始画布,当程序开始时就先绘制此画布的所有内容
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PVZ.Context;

public class StartPanel extends JPanel{

	public static Image background;
	public static Image SelectorScreenStartAdventur;
	public static Image startImg;
	public static Image SelectorScreen_WoodSign1;
	public static Image SelectorScreen_WoodSign2;
	public static Image SelectorScreen_StartAdventure_Highlight;
	public static Image SelectorScreen_Vasebreaker_button;
	public static Image SelectorScreen_Challenges_button;

	//按钮
	//开始游戏按钮
	public JButton start = new JButton();
	//存档按钮
	public JButton chives= new JButton();
	//退出按钮
	public JButton exit = new JButton();

	
	static {
		
		try {
			//加载背景图
			background = ImageIO.read(new FileInputStream(Context.PATH_ROOT + "Surface.png"));
			
			//加载挂图
			SelectorScreen_WoodSign1 = ImageIO.read(new FileInputStream(Context.PATH_IN + "SelectorScreen_WoodSign1.png"));
			SelectorScreen_WoodSign2 = ImageIO.read(new FileInputStream(Context.PATH_IN + "SelectorScreen_WoodSign2.png"));
			
			//加载游戏模式图
			SelectorScreen_StartAdventure_Highlight = ImageIO.read(new FileInputStream(Context.PATH_IN + "SelectorScreen_StartAdventure_Highlight.png"));
			//---生存模式
			SelectorScreen_Vasebreaker_button = ImageIO.read(new FileInputStream(Context.PATH_IN + "SelectorScreen_Vasebreaker_button.png"));
			//---冒险模式
			SelectorScreen_Challenges_button = ImageIO.read(new FileInputStream(Context.PATH_IN + "SelectorScreen_Challenges_button.png"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件没有发现,或移除与更名");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读写错误");
		}
		
	}
	
	public StartPanel () {
	
		
		//把默认布局去除
		setLayout(null);
		
		/*
		//是否显示外围矩形区域
		start.setContentAreaFilled(false);
		//去除边框
		start.setBorderPainted(false);
		//去除聚焦框
		start.setFocusable(true);
		
		//设置自身透明
		start.setOpaque(false);
		
		start.setMargin(new Insets(0, 0, 0, 0));  
		start.setFocusPainted(false);  
		start.setBorderPainted(false);  
		 
		*/ 
		
		//开始按钮
		start.setBounds(460, 70, 331, 146);
		//设置自身透明
		start.setOpaque(false);
		
		
		//退出按钮
		exit.setBounds(813,510, 50, 30);
		//设置透明
		exit.setContentAreaFilled(false);
		
		add(start);
		add(chives);
		add(exit);


	}
	
	//游戏开始时的画布内容
	public void paint(Graphics g) {
		super.paint(g);
		
		//背景图
		setLayout(null);
		g.drawImage(background, 0, 0,null);
		
		//挂画
		g.drawImage(SelectorScreen_WoodSign1, 0, 0, null);
		g.drawImage(SelectorScreen_WoodSign2, 0, 140, null);
		
		//游戏模式
		g.drawImage(SelectorScreen_StartAdventure_Highlight,460, 70, null);
		g.drawImage(SelectorScreen_Vasebreaker_button, 460, 200,null);
		g.drawImage(SelectorScreen_Challenges_button, 460,300, null);
		
		this.repaint();

		
	}
	


}
