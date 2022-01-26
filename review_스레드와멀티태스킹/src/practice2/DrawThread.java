package practice2;

import javax.swing.JPanel;

public class DrawThread extends Thread {
	private int x;
	private int y;
	private MyPanel panel;
	
	public DrawThread(int x, int y, MyPanel panel) {
		this.x = x;
		this.y = y;
		this.panel = panel;
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			panel.setXY((int)Math.random()*500, (int)Math.random()*500);
			panel.repaint();
		}
	}
	
}
