package practice8;

import javax.swing.JComponent;

public class LetItSnowThread extends Thread {
	private Snow snow;
	private int x;
	private int y;
	
	public LetItSnowThread(Snow snow) {
		this.snow = snow;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			y = snow.getY();
			System.out.println(y);
			
			if(y >= snow.getParent().getHeight()) y = 0;
			y++;
			snow.setLocation(snow.getParent().getX(), y);
		}
		
	}
	
}
