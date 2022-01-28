package practice5;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JLabel;

public class GhostThread extends Thread {
	private JLabel ghostLabel;
	private int realX;
	private int x;
	private int y;
	private int term = 5;
	private boolean flag = false;
	
	public GhostThread(JLabel ghostLabel) {
		this.ghostLabel = ghostLabel;
		
	}
	
	public void reset() {
		flag = true;
	}
	@Override
	public void run() {
		super.run();
		
		x = (int) (ghostLabel.getLocation().getX());
		y = (int) (ghostLabel.getLocation().getY());
		realX = x;
		
		while(true) {
			x -= term;
			
			if(x == 0 - (int)(ghostLabel.getWidth())) {
				x = 500 + (int)(ghostLabel.getWidth());
			}
			ghostLabel.setLocation(x, y);
			
			try {
				Thread.sleep(20);
				if(flag) {
					ghostLabel.setLocation(realX, y);
					x = realX;
					flag = false;
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}
