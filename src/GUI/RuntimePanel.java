
/*
 * 运行时画布
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Carts.Carts;
import GUI.RuntimePanel;
import PVZ.Context;
import PVZ.PVZ;
import PVZ.ShareDate;
import PVZ.Sun;
import Plants.Bullet;
import Plants.Plants;
import Plants.Repeater;
import Plants.Shooters;
import Plants.SunFlower;
import Zombies.Zombie;
import Zombies.Zombies;

public class RuntimePanel extends JPanel implements Runnable {

	public static Image sunImage = Toolkit.getDefaultToolkit().getImage(Context.PATH_ROOT + "Sun.gif");;
	
	//阳光控制
	Random rd = new Random();
	
	//太阳数组
	public List<Sun> listSun = new CopyOnWriteArrayList<Sun>();
	//子弹集合
	List<Bullet> listBullet = new CopyOnWriteArrayList<Bullet>();
	//僵尸数组
	List<Zombies> listZombies = new CopyOnWriteArrayList<Zombies>();
	
	
	public static Image background;
	public static Image Shovel;
	public static Image SunBack;
	public static Image ShovelBack;
	public static Image FlagMeterEmpty;
	public static Image FlagMeterParts1;
	public static Image FlagMeterParts2;
	public static Image FlagMeterLevelProgress;
	
	//小推车
	Carts c1 = new Carts(220,100);
	Carts c2 = new Carts(220,200);
	Carts c3 = new Carts(220,300);
	Carts c4 = new Carts(220,400);
	Carts c5 = new Carts(215,500);

	
	static {
		
		try {
			background = ImageIO.read(new FileInputStream(Context.PATH_I + "background1.jpg"));
			Shovel = Toolkit.getDefaultToolkit().getImage(Context.PATH_I + "Shovel.png");
			SunBack = Toolkit.getDefaultToolkit().getImage(Context.PATH_I + "SunBack.png");
			ShovelBack= Toolkit.getDefaultToolkit().getImage(Context.PATH_I + "ShovelBack.png");
			FlagMeterEmpty= Toolkit.getDefaultToolkit().getImage(Context.PATH_I + "FlagMeterEmpty.png");
			FlagMeterParts1= Toolkit.getDefaultToolkit().getImage(Context.PATH_I +"FlagMeterParts1.png");
			FlagMeterLevelProgress= Toolkit.getDefaultToolkit().getImage(Context.PATH_I +"FlagMeterLevelProgress.png");
			FlagMeterParts2 = Toolkit.getDefaultToolkit().getImage(Context.PATH_I +"FlagMeterParts2.png");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件没有发现,或移除与更名");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读写错误");
		}
		
	}

	//共享对象
	ShareDate shareDate;
	
	//需要传入窗口
	public RuntimePanel(ShareDate shareDate) {
		this.shareDate = shareDate;
	}

	public void paint(Graphics g) {
		super.paint(g);
		//背景图
		g.drawImage(background, 0, 0,null);
		//阳光
		g.drawImage(SunBack,40, 20, null);
		g.drawImage(ShovelBack, 900, 20, null);
		g.drawImage(Shovel, 900, 20, null);
		
		//进度条头
		g.drawImage(FlagMeterEmpty, 700, 31, null);
		g.drawImage(FlagMeterParts1, 840, 21, null);
		g.drawImage(FlagMeterParts2, 700, 21, null);
		g.drawImage(FlagMeterLevelProgress, 740, 45, null);
		
		//小推车从上到下
		g.drawImage(c1.getImages(), c1.getX(), c1.getY(), null);
		g.drawImage(c2.getImages(), c2.getX(), c2.getY(), null);
		g.drawImage(c3.getImages(), c3.getX(), c3.getY(), null);
		g.drawImage(c4.getImages(), c4.getX(), c4.getY(), null);
		g.drawImage(c5.getImages(), c5.getX(), c5.getY(), null);
		
		
		newPlants(g);
		//画随机阳光
		paintSun(g);	
		//画阳光值
		paintSunNum(g);
		//画僵尸
		paintZombies(g);
/*		Repeater p = new Repeater();
		g.drawImage(p.getImages(), 30, 30,null);
		Zombie z = new Zombie();
		g.drawImage(z.getImages(), 100, 50,null);
*/
	}
	
	
	public void run() {
		
		action();

	}
	
	//检查子弹与僵尸碰撞
	public void collide() {
		for(Bullet lb : listBullet) {
			for(Zombies lz :listZombies) {
				if(lb.getX()>=lz.getX() 
					&& lb.getY()>lz.getY()
					&& lb.getY()<=lz.getY()+lz.getImages().getHeight(this)){
					lz.setHP(lz.getHP()-1);
					//当僵尸血量降低到0以下将消失
					if(lz.getHP()<=0) {
						listZombies.remove(lz);
					}
					listBullet.remove(lb);
				}
				
				
			}
			
		}
		
	}
	
	//new僵尸
	int ZombiesNewIndex;
	public void newZombies() {
		ZombiesNewIndex++;
		if(ZombiesNewIndex%1000 == 0) {
			Zombie zb = new Zombie();
			listZombies.add(zb);
	}
		
	}
	
	//画僵尸--被paint方法调用
	public void paintZombies(Graphics g) {
		if(!listZombies.isEmpty()) {
	        Iterator<Zombies> iterator = listZombies.iterator();
	        while(iterator.hasNext()){
	        	Zombies zb = iterator.next();
	            g.drawImage(zb.getImages(), zb.getX(), zb.getY(), null);

	        }

		
		}
		
	}
	
	//僵尸移动
	int moveZombiesIndex;
	public void moveZombies() {
		moveZombiesIndex++;
		if(moveZombiesIndex%40 == 0) {
			moveZombiesIndex=0;
			for(Zombies zb : listZombies) {
				zb.move();
			}
		}
	}
	
	//画植物----有空指针异常
	public void newPlants(Graphics g) {
		List<Plants> nP;
		//线程安全---必须先检测是否画布被加载,不然会空指针异常
		if(!(shareDate.getShareP().isEmpty())) {
			nP = ((CardPanel)(shareDate.getShareP().get("cp"))).getList();
	        Iterator<Plants> iterator = nP.iterator();
	        while(iterator.hasNext()){
	        	Plants P = iterator.next();
	            g.drawImage(P.getImages(), P.getX(), P.getY(), null);
	            
    			//开始遍历子弹
    			if(!(listBullet.isEmpty())) {
    				Iterator<Bullet> iteratorB = listBullet.iterator();
    		        while(iteratorB.hasNext()){
    		        	Bullet b = iteratorB.next();
    		            g.drawImage(b.getImages(), b.getX(), b.getY(), null);
    		        }
    		   }
	     }
	     
	}

}


	//碰撞检测
	public void collideCheck() {
/*        Iterator<Sun> iterator = listSun.iterator();
        while(iterator.hasNext()){
            Sun sun = iterator.next();
            g.drawImage(sun.getImages(), sun.getX(), sun.getY(), null);

        }*/
	}
	
	//new子弹兼new指定的太阳
	int shootNewIndex;
	int sunNewIndex;
	public void newBullet() {
		shootNewIndex++;
		sunNewIndex++;
		if(shootNewIndex%90 == 0) {
			List<Plants> nP;
			//线程安全---必须先检测是否画布被加载,不然会空指针异常
			if(!(shareDate.getShareP().isEmpty())) {
				nP = ((CardPanel)(shareDate.getShareP().get("cp"))).getList();
		        Iterator<Plants> iterator = nP.iterator();
		        while(iterator.hasNext()){
		        	Plants P = iterator.next();
		            //检查是否需绘制子弹
		            if(P instanceof Shooters) {
		    			Shooters sp = (Shooters) P;
		    			listBullet.add(sp.shootBullet());
		    		}
		            
		            //生成阳光
		            if(P instanceof SunFlower) {
		            	SunFlower sf = (SunFlower)P;
		            	Sun sun = new Sun(sunImage, sf.getX(), sf.getY());
		            	sun.setHZ(sun.getHZ()+1);
		            	if(sunNewIndex%30 == 0 && sun.getHZ() >= 10) {
		            		sun.setHZ(0);
		            		//sun.setHZ(rd.nextInt(10));
			            	listSun.add(sun);
		            	}
		            }
				}
			
		     }
		}
	
	}
		
	
	//射击所有子弹并且自检是否越界
	int shootIndex = 0;
	public void shootMove() {
		shootIndex++;
			if(shootIndex%2 == 0) {
		        Iterator<Bullet> iterator = listBullet.iterator();
		        while(iterator.hasNext()){
		            Bullet b = iterator.next();
		            b.move();
		            if(b.outOfBounds()) {
		            	listBullet.remove(b);
		            }
		       }
		  }
	}
	
	//创建一个阳光
	int newSunIndex = 0;
	public void newSun() {
		newSunIndex++;
			if(newSunIndex%3000 == 0) {
			Sun sun = new Sun(sunImage);
			listSun.add(sun);
		}
	}
	
	//阳光移动
	int moveSunIndex;
	public void moveSun() {
		moveSunIndex++;
		if(moveSunIndex%5 == 0) {
			for(Sun s : listSun) {
				if(s.getMoveType()==0) {
					s.move();
				}
				if(s.getMoveType()==1) {
					s.move2();
				}
			}
		}
	}
	
	//越界检测
	public void  borderSunCheck() {
		if(!listSun.isEmpty()) {
	        Iterator<Sun> iterator = listSun.iterator();
	        while(iterator.hasNext()){
	            Sun sun = iterator.next();
	            if(sun.getMoveType() == 0) {
		            if(sun.getY()>Context.HEIGHT) {
		            	listSun.remove(sun);
		            }   	
	            }
	            if(sun.getMoveType() == 1) {  
		            if(sun.getY() <= -100 || 15 >= sun.getX()) {
		            	listSun.remove(sun);
		            	
		            }   
	            }
	            
	        }
		}
	}
	
	//画阳光--被paint方法调用
	public void paintSun(Graphics g) {
		if(!listSun.isEmpty()) {
	        Iterator<Sun> iterator = listSun.iterator();
	        while(iterator.hasNext()){
	            Sun sun = iterator.next();
	            g.drawImage(sun.getImages(), sun.getX(), sun.getY(), null);

	        }

		
		}
		
	}
	

	//阳光被点击检测
	public void clickCeck() {
	        Iterator<Sun> iterator = listSun.iterator();
	        while(iterator.hasNext()){
	            Sun sun = iterator.next();
	            int msx = ((CardPanel)(shareDate.getShareP().get("cp"))).getXM();
	            int msy = ((CardPanel)(shareDate.getShareP().get("cp"))).getYM();
	            if(sun.clickCeck(msx,msy) && sun.getVariable()==0){
	            	sun.setMoveType(1);
	            	sun.getSun();
	            	sun.setxSpeeds(15);
	            	sun.setVariable(msy * sun.getxSpeeds()/ msx);
	            	//sun.setVariable(((msy-30) * sun.getxSpeeds() )/ (msx-30));
	            	//listSun.remove(sun);
	            }
	        }
	}

	//画阳值
	public void paintSunNum(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
		g.drawString(String.valueOf(PVZ.sunSum),95,43);

	}
	
	public void action() {
		//定时刷新模块
		Timer timer = new Timer();
		int intervel = 10;	//定时间隔(以毫秒为单位)
		timer.schedule(new TimerTask() {
		    public  void run() {
		    	
		    	//新建阳光
		    	newSun();
		    	//移动阳光
		    	moveSun();
		    	//检测是否被点击
		    	clickCeck();
		    	//检测是否越界
		    	borderSunCheck();
		    	//子弹发射
		    	shootMove();
		    	//新建子弹
		    	newBullet();
		    	//new僵尸
		    	newZombies();
		    	//移动僵尸
		    	moveZombies();
		    	//碰撞检测
		    	collide();
		    	repaint();
		    	
		    }
		},intervel,intervel);
	}
}

