package practice2;

public class DrawThread extends Thread {
	private int x;
	private int y;
	private MyPanel panel;
	
	public DrawThread(MyPanel panel) {
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
			
			x = ((int)(Math.random()*panel.getWidth()));
			y = ((int)(Math.random()*panel.getHeight()));
			
			panel.setXY(x, y);
			
		}
	}
	
}
