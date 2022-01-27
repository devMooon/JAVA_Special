package practice5;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BulletThread extends Thread {
	private JLabel bulletLabel;
	private int realY;
	private int x;
	private int y;
	private int term = 5;
	
	public BulletThread(JLabel bulletLabel) {
		//ÃÑ¾Ë º¸³»±â
		this.bulletLabel = bulletLabel;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		x = (int) (bulletLabel.getLocation().getX());
		y = (int) (bulletLabel.getLocation().getY());
		realY = y;
		
		while(true) {
			y -= term;
			
			if(y <= 0) {
				y = realY;
			}
			bulletLabel.setLocation(x, y);
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}