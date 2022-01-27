package practice4;

import java.awt.Point;

import javax.swing.JFrame;

public class WavingFrame extends JFrame {
	public WavingFrame() {
		super("진동하는 프레임 만들기");
		
		buildThread();
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildThread() {
		Thread thread = new WavingFrameThread(this);
		thread.start();
	}
	
	class WavingFrameThread extends Thread {
		private JFrame frame;
		private int x;
		private int y;
		
		public WavingFrameThread(JFrame frame) {
			this.frame = frame;
			x = frame.getLocation().x + 5;
			y = frame.getLocation().y - 5;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
			while(true) {
				frame.setLocation(x, y);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				x *= -1;
				y *= -1;
			}
			
			
		}
		
		
	}
}
