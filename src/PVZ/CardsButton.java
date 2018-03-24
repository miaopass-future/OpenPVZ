
/*
 * 按钮类，为了适合本项目需要添加额外属性
 */

package PVZ;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import GUI.CardPanel;

public class CardsButton extends JButton{
	

	//显示在按钮上的两张图片
	private ImageIcon image_RPG;
	private ImageIcon image_GS;
	
	//真实的图片地址
	public Image image;
	
	//状态---是否被点击过
	//约定：0为未点击过状态 1为点击过状态
	private int state = 0;
	
	//基本属性
	private int x;
	private int y;
	private int height = 60;
	private int width = 101;
	
	/*
	 * 位置代号
	 * 1 的位置 40,50
	 * 2 的位置	40,150
	 * 3 的位置	40,220
	 * 4 的位置	40,290
	 * 5 的位置	40,360
	 * 
	 */
	//此值也作为判断点击那个按钮
	private int position;

	/*
	 * 所需要阳光值
	 */
	
	private int sun;
	
	/*
	 * 冷却时间
	 */
	private int HZ=0;
	
	//植物类型
	private String type;

	public CardsButton(ImageIcon image_RPG, ImageIcon image_GS, Image image, int position,
			int sun, String type) {
		
		//植物类型
		this.type = type;
		
		//三张必要的图片
		this.image_RPG = image_RPG;
		this.image_GS = image_GS;
		this.image = image;
		
		//需要的阳光值
		this.sun = sun;
		//给一个状态值确定按钮出现位置
		if(position == 1) {
			this.x = 40;
			this.y = 80;
		}else if(position == 2) {
			this.x = 40;
			this.y = 150;
		}else if(position == 3) {
			this.x = 40;
			this.y = 220;
		}else if(position == 4) {
			this.x = 40;
			this.y = 290;
		}else if(position == 5) {
			this.x = 40;
			this.y = 360;
		}

		//按钮大小  需要时再打开
		//this.height = image_RPG.getIconHeight();
		//this.width = image_RPG.getIconHeight();
		
		//设置默认
		this.setIcon(image_GS);
		this.setBounds(x, y, this.width, this.height);
		//设置透明
		this.setOpaque(false);
		//设置无布局
		this.setLayout(null);
		//设置无边框
		//this.setBorderPainted(false);
		/*
		 * -------------------------------------------
		 * 监听器和定时器特殊情况下会报异常
		 * 这个异常不知原因
		 * 
		 * 可能是引用了相同不同版本的class
		 * -------------------------------------------
		 * 
		 */

		//封装自己的定时器
		Timer timer = new Timer();
		//封装自己的监听器
		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
					
				//在这里需要判断阳光值以及是否为激活状态
				if(PVZ.sunSum >= sun && HZ>=15) {
					 HZ=0;
					 setImage_RPG(image_GS);
					//设置卡槽画布要画跟随的图片为卡槽自己的图片
					CardPanel.followImage = image;
					//设置状态为跟随
					CardPanel.follow = true;
					//通告类型
					CardPanel.type = type;
					PVZ.sunSum -= sun;
					
				}
		
			}
		});

		//只要阳光充足和冷却时间过才设置图片图标
		timer.schedule(new TimerTask() {
		    public  void run() {
		    	if(HZ<=15) {
		    		HZ+=1;
		    	}
		    	if(PVZ.sunSum >= sun && HZ>=15) {
		    		setImage_RPG(image_RPG);
		    	}
		    }
		},1000,700);//调节冷却时间
	}

	

	public ImageIcon getImage_RPG() {
		return image_RPG;
	}


	public void setImage_RPG(ImageIcon image_RPG) {
		this.setIcon(image_RPG);

	}


	public ImageIcon getImage_GS() {
		return image_GS;
	}


	public void setImage_GS(ImageIcon image_GS) {
		this.setIcon(image_GS);
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}

}
