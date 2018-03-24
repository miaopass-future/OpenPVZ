
/*
 * 太阳类
 */
package PVZ;

import java.awt.Image;
import java.util.Random;

public class Sun {

	//控制方向
	private int bearing;
	//图片
	protected Image images;
	//长宽
	protected int width=78;
	protected int height=78;
	//位置
	protected int x;
	protected int y;
	//速度
	private int xSpeeds=2;
	private int ySpeeds=2;
	//可变的速度
	private int variable; 
	//鼠标位置
	private int Mx;
	private int My;
	
	//移动类型控制
	private int moveType = 0;
	
	private int HZ;
	
	//太阳随机点
	public Sun (Image images) {
		this.images = images;
		Random rad = new Random();
		bearing = rad.nextInt(2);
		this.x = rad.nextInt(Context.WIDTH + width);
		this.y = 0;
		this.HZ = rad.nextInt(11);
	}
	
	//太阳指定生成点
	public Sun (Image images, int x , int y) {
		Random rad = new Random();
		bearing = rad.nextInt(2);
		this.images = images;
		this.x = x;
		this.y = y;
		this.HZ = rad.nextInt(11);

	}
	
	//移动
	public void move() {
		
		if(bearing == 0) {
			this.x -= xSpeeds;
			this.y += ySpeeds;
			if(this.x >= Context.WIDTH - width*2) {
				this.xSpeeds = -xSpeeds;
			}
			if(this.x <= 0 ) {
				this.xSpeeds = -(xSpeeds);
			}
		}else {
			this.x += xSpeeds;
			this.y += ySpeeds;
			if(this.x >= Context.WIDTH - width) {
				this.xSpeeds = -xSpeeds;
			}
			if(this.x <= 0 ) {
				this.xSpeeds = -(xSpeeds);
			}
			
		}
		
	}
	
	public void move2() {
		this.x -= xSpeeds;
		this.y -= variable;
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

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
	}

	//被点击检测
	public boolean clickCeck(int Mx, int My) {
		this.Mx = Mx;
		this.My = My;
		if(this.Mx>this.x &&
					this.Mx <= this.x +this.getX() && 
						this.My>this.y && this.My <= this.y + this.getY()) {
			return true;
		}else {
			return false;
		}
	}
	
	//给阳光
	public void getSun() {
		PVZ.sunSum += 50;
	}

	public int getVariable() {
		return variable;
	}

	public void setVariable(int variable) {
		this.variable = variable;
	}

	public int getxSpeeds() {
		return xSpeeds;
	}

	public void setxSpeeds(int xSpeeds) {
		this.xSpeeds = xSpeeds;
	}

	public int getySpeeds() {
		return ySpeeds;
	}

	public void setySpeeds(int ySpeeds) {
		this.ySpeeds = ySpeeds;
	}

	public int getMoveType() {
		return moveType;
	}

	public void setMoveType(int moveType) {
		this.moveType = moveType;
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

	public int getBearing() {
		return bearing;
	}

	public void setBearing(int bearing) {
		this.bearing = bearing;
	}

	public int getHZ() {
		return HZ;
	}

	public void setHZ(int hZ) {
		HZ = hZ;
	}
	
	
}
