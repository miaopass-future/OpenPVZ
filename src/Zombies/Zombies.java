
/*
 * 所有僵尸父类
 */
package Zombies;

import java.awt.Image;
import java.util.Map;

public abstract class Zombies {
	
	//储存图片的集合
	public Map<String,Image> images;
	
	//僵尸生命值
	protected int HP;
	
	//僵尸位置
	protected int x;
	protected int y;
	
	//僵尸移动
	public abstract void move ();
	
	//拿到图片
	public abstract Image getImages();

	public abstract int getHP();

	public abstract void setHP(int hP);

	public abstract int getX();
	
	public abstract void setX(int x);

	public abstract int getY();
	
	public abstract void setY(int y);
	
}
