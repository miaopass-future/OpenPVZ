package Zombies;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import PVZ.Context;

public class Zombie extends Zombies{

	//生成的随机y坐标
	private int x;
	private int y;
	protected int width;
	protected int height;
	private int speed = 5;
	
	public Zombie(){
		Random rd = new Random();
		this.x = Context.WIDTH;
		this.y = ((rd.nextInt(5))*100) + 20;
		//给一个装图片的集合___后期可能需要多张,提高扩展冗余
		images = new HashMap<String,Image>();
		//设置图片
		try {
			images.put("1",ImageIO.read(new FileInputStream(Context.PATH_Z + "Zombie/" + "Zombie.gif")) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//设置生命值
		HP=5;
		
	}
	
	//拿到图片
	public Image getImages() {
		return images.get("1");
	}

	public void move() {
		x -= speed;
		
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getHP() {
		
		return this.HP;
	}


	public void setHP(int hP) {
		
		this.HP = hP;
		
	}
	
	

}
