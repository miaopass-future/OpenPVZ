package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import PVZ.CardsButton;
import PVZ.Context;
import Plants.Plants;
import Plants.Repeater;
import Plants.SnowPea;
import Plants.SunFlower;
import Plants.TallNut;
import Plants.Torchwood;

public class CardPanel extends JPanel{

	//图片跟随状态
	public static Image followImage;
	public static boolean follow=false;
	
	//跟随的图片位置----这个参数可以传送给阳光，判断是否被点击
	public  int x;
	public  int y;
	
	//要new的对象类型
	public static String type;
	
	/*
	 * type为植物的名字
	 */
	
	//装植物对象
	private List<Plants> list = new ArrayList<Plants>();
	
	//这个图片要在卡槽被点击时用来判断是什么图片
	
	//豌豆射手
	public ImageIcon JBImage_GS = new ImageIcon(Context.PATH_C + "PeashooterG.png");
	public ImageIcon JBImage_RPG = new ImageIcon(Context.PATH_C + "Peashooter.png");
	public Image JBImage= Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "Repeater/" + "Repeater.gif");
	
	//向日葵
	public ImageIcon SFJBImage_GS = new ImageIcon(Context.PATH_C + "SunFlowerG.png");
	public ImageIcon SFJBImage_RPG = new ImageIcon(Context.PATH_C + "SunFlower.png");
	public Image SFJBImage= Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "SunFlower/" + "SunFlower.gif");
	
	//土豆
	public ImageIcon TNJBImage_GS = new ImageIcon(Context.PATH_C + "TallNutG.png");
	public ImageIcon TNJBImage_RPG = new ImageIcon(Context.PATH_C + "TallNut.png");
	public Image TNJBImage= Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "TallNut/" + "TallNut.gif");
	
	//火焰
	public ImageIcon THJBImage_GS = new ImageIcon(Context.PATH_C + "TorchwoodG.png");
	public ImageIcon THJBImage_RPG = new ImageIcon(Context.PATH_C + "Torchwood.png");
	public Image THJBImage= Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "Torchwood/" + "Torchwood.gif");
	
	//寒冰射手
	public ImageIcon SPJBImage_GS = new ImageIcon(Context.PATH_C + "SnowPeaG.png");
	public ImageIcon SPJBImage_RPG = new ImageIcon(Context.PATH_C + "SnowPea.png");
	public Image SPJBImage= Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "SnowPea/" + "SnowPea.gif");
	
	//卡槽
	public CardsButton jb1 = new CardsButton(SFJBImage_RPG, SFJBImage_GS, SFJBImage,1,50,"SunFlower");
	public CardsButton jb2 = new CardsButton(JBImage_RPG, JBImage_GS, JBImage,2,120,"Repeater");
	public CardsButton jb3 = new CardsButton(TNJBImage_RPG, TNJBImage_GS, TNJBImage,3,80,"TallNut");
	public CardsButton jb4 = new CardsButton(THJBImage_RPG, THJBImage_GS, THJBImage,4,250,"Torchwood");
	public CardsButton jb5 = new CardsButton(SPJBImage_RPG, SPJBImage_GS, SPJBImage,5,300,"SnowPea");


	//铲子  此图暂时失效
	JButton jb6 = new JButton(new ImageIcon(Context.PATH_C + "Shovel.png"));
	
	public CardPanel() {
		//游戏运行时画布
		setLayout(null);
	
		//这个是铲子按钮已经设置透明
		jb6.setBounds(900,20, 76, 34);
		jb6.setContentAreaFilled(false);
		
		//jb1.setBounds(900,20, 76, 34);
		
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);
		add(jb5);
		add(jb6);

		//添加监听器
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.repaint();

	}
	
	public void paint(Graphics g) {

		super.paint(g);
		if(follow) {
			//满足条件将鼠标跟随
			g.drawImage(followImage, x - (followImage.getHeight(this)/2),
					y - (followImage.getHeight(this)/2), null);
		}
		
	}

	public int getXM() {
		return x;
	}

	public int getYM() {
		return y;
	}
	

	public List<Plants> getList() {
		return list;
	}

	public void setList(List<Plants> list) {
		this.list = list;
	}



	//鼠标监听器
	MouseAdapter mouse = new MouseAdapter() {
		
		//鼠标点击事件
		public void mouseClicked(MouseEvent e) {
			
			//如果点击右键将取消图片跟随
			if(e.getButton() == MouseEvent.BUTTON3 && follow == true ) {
				follow=false;
			}
			//判断是否需要new植物
			if(follow==true) {
				if(type.equals("Repeater")) {
					Repeater repeater = new Repeater(x,y);
					list.add(repeater);
				}else if(type.equals("SunFlower")) {
					SunFlower sf = new SunFlower(x,y);
					list.add(sf);
				}else if(type.equals("TallNut")) {
					TallNut tl = new TallNut(x,y);
					list.add(tl);
				}else if(type.equals("Torchwood")) {
					Torchwood tc = new Torchwood(x,y);
					list.add(tc);
				}else if(type.equals("SnowPea")) {
					SnowPea sn = new SnowPea(x,y);
					list.add(sn);
				}
				follow = false;
			}
		}
		
		//鼠标移动事件
		public void mouseMoved(MouseEvent e) {
			  x=e.getX();
			  y=e.getY();
			  repaint();
		}
	};

}
