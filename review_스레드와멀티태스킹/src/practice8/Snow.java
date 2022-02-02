package practice8;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Snow extends JComponent {
	public int x, y = 0;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if(x == 0 && y == 0) {
			x = (int) (Math.random() * this.getParent().getWidth());
			y = (int) (Math.random() * this.getParent().getHeight());
		}
		
		g.setColor(Color.white);
		g.fillOval(x, y, 15, 15);
	}
	
}
