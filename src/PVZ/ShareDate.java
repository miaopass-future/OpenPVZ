
/*
 * 线程共享数据
 */
package PVZ;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class ShareDate {
	
	private Map<String,JPanel> shareP = new HashMap<String,JPanel>();
	
	public Map<String, JPanel> getShareP() {
		return shareP;
	}

	public void setShareP(Map<String, JPanel> shareP) {
		this.shareP = shareP;
	}


	
}
