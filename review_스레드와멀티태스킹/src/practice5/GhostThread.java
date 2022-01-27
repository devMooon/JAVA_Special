package practice5;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JLabel;

public class GhostThread extends Thread {
	private JLabel ghostLabel;
	private int x;
	private int y;
	private int term = 5;
	
	public GhostThread(JLabel ghostLabel) {
		this.ghostLabel = ghostLabel;
		
	}

	@Override
	public void run() {
		super.run();
		
		x = (int) (ghostLabel.getLocation().getX());
		y = (int) (ghostLabel.getLocation().getY());
		
		while(true) {
			x -= term;
			
			if(x == 0 - (int)(ghostLabel.getWidth())) {
				x = 500 + (int)(ghostLabel.getWidth());
			}
			ghostLabel.setLocation(x, y);
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
