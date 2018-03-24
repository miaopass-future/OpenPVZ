
/*
 * 子弹
 */

package Plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import PVZ.Context;


public class Bullet {

	public Map<String,BufferedImage> images;
	//public Map<String,Image> images;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	private int speed = 3;

	public Bullet(int x, int y) {
		images = new HashMap<String,BufferedImage>();
		//设置图片
		//images.put("1",Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "PB01.gif"));
		try {
			images.put("1",ImageIO.read(new FileInputStream(Context.PATHP_P + "PB01.gif")));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("图片读写错误");
		}
		
		width = 56;
		height = 34;
		this.x = x;
		this.y = y;
	}
	
	//拿到图片
	public Image getImages() {
		return images.get("1");
	}

	public  void move() {
		x += speed;
	}
	
	public boolean outOfBounds() {
		
		return this.x >= Context.WIDTH;
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
}
