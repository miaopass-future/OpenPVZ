
/*
 * 所有植物父类
 */

package Plants;

import java.awt.Image;
import java.util.Map;

public abstract class Plants {
	
	//储存图片的集合
	public Map<String,Image> images;
	//植物生命值
	protected int HP;
	
	//生成位置
	protected int x;
	protected int y;
	
	//拿到图片
	public abstract Image getImages();
	
	public abstract int getX();
	public abstract int getY();
	

}
