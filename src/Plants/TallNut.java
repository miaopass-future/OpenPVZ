package Plants;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

import PVZ.Context;

public class TallNut extends Plants{

	public TallNut(int x, int y){
		
		this.x =x-40;
		this.y =y-40;
		//给一个装图片的集合___后期可能需要多张,提高扩展冗余
		images = new HashMap<String,Image>();
		//设置图片
		images.put("1", Toolkit.getDefaultToolkit().getImage(Context.PATHP_P + "TallNut/" + "TallNut.gif"));
		
		//设置生命值
		HP=100;
		
	}
	
	//拿到图片
	public Image getImages() {
		return images.get("1");
	}


	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
}
