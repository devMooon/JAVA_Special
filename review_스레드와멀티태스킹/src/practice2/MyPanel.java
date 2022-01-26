package practice2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	int x;
	int y;
	
	public MyPanel() {
		this.setSize(500, 500);
		Thread th = new DrawThread(x, y, this);
		th.start();
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.drawOval(x, y, 50, 50);		
	}
}
