package practice5;

import javax.swing.JLabel;

public class BulletThread extends Thread {
	private JLabel bulletLabel;
	private JLabel ghostLabel;
	private GhostThread ghostThread;
	
	private int realY;
	private int x;
	private int y;
	private int term = 5;
	
	public BulletThread(JLabel bulletLabel, JLabel ghostLabel, GhostThread ghostThread) {
		this.bulletLabel = bulletLabel;
		this.ghostLabel = ghostLabel;
		this.ghostThread = ghostThread;
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
			
			System.out.println("(" + x + ", " + y);
			bulletLabel.setLocation(x, y);
		
			try {
				if(y <= 0) {
					y = realY;
					System.out.println("스레드 초기화");
					bulletLabel.setLocation(x, y);
					return;
				}
				
				if(x >= ghostLabel.getX() && x <= ghostLabel.getX() + ghostLabel.getWidth() &&
						y <= ghostLabel.getHeight()) {
					y = realY;
					System.out.println("스레드 초기화");
					bulletLabel.setLocation(x, y);
					ghostThread.reset();
					return;
					
				}
				System.out.println("x : " + ghostLabel.getX() + "y : " + ghostLabel.getY());
				if(x >= ghostLabel.getX() && x <= ghostLabel.getX() + ghostLabel.getWidth() &&
						y <= ghostLabel.getHeight()) {
					y = realY;
					System.out.println("부딫힘! 스레드 초기화");
					bulletLabel.setLocation(x, y);
					return;
				}
				Thread.sleep(20);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				System.out.println("스레드 초기화");
				bulletLabel.setLocation(x, realY);
				
				return;
			}
		}
	}	
}