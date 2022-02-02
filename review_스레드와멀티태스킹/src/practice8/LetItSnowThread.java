package practice8;

import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;

public class LetItSnowThread extends Thread {
	private Vector<Point> snowPoints;
	private JFrame frame;
	private int y;
	
	public LetItSnowThread(Vector<Point> snowPoints, JFrame frame) {
		this.snowPoints = snowPoints;
		this.frame = frame;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			Iterator<Point> itr = snowPoints.iterator();
			while(itr.hasNext()) {
				Point point = itr.next();
				y=point.y;
				y+=5;
				
				if(y >= frame.getHeight()) y=0;
				
				point.y = y;
				frame.repaint();
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
}
