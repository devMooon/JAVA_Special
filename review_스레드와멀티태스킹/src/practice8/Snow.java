package practice8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Snow extends JComponent {
	private Vector<Point> snowPoints;
	public int x, y;
	
	public Snow(JFrame frame) {
		snowPoints = new Vector<Point>();
		
		for(int i = 0; i < 30; i++) {
			x = (int)(Math.random() * frame.getWidth());
			y = (int)(Math.random() * frame.getHeight());
			
			snowPoints.add(new Point(x, y));
		}
		
		LetItSnowThread thread = new LetItSnowThread(snowPoints, frame);
		thread.start();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Iterator<Point> itr = snowPoints.iterator();
		
		while(itr.hasNext()){
			Point point = itr.next();
			g.setColor(Color.white);
			System.out.println(point.x + ", " + point.y);
			g.fillOval(point.x, point.y, 15, 15);
		}
	}
}