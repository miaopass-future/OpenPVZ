package Carts;

/*
 * 小车
 */
import java.awt.Image;
import java.awt.Toolkit;

import PVZ.Context;

public class Carts {
	
	//图片
	private Image images;
	//坐标
	private int x,y;
	//尺寸
	private int width = 71, height = 57;
	//速度
	private int xSpeeds = 2;
	
	public Carts(int x, int y){
		
		this.x =x-28;
		this.y =y-26;

		images = Toolkit.getDefaultToolkit().getImage(Context.PATH_ROOT+ "LawnMower.gif");
		//设置图片
		
	}

	public void move() {
		this.x += xSpeeds;
	}
	
	public boolean clickCeck() {
		if(this.x > Context.WIDTH) {
			return true;
		}else {
			return false;
		}
	}

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
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

	public int getxSpeeds() {
		return xSpeeds;
	}

	public void setxSpeeds(int xSpeeds) {
		this.xSpeeds = xSpeeds;
	}

}
