package practice10;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JComponent;

public class MyComponent extends JComponent {
	private Component component;
	private int width;
	private int height;
	private int x, y, w, h;
	
	public MyComponent() {
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		component = this.getParent();
		width = component.getWidth();
		height = component.getHeight();
		
		g.setColor(Color.magenta);
		
		x = (int)(Math.random() * width);
		y =	(int)(Math.random() * height);
		w = (int)(Math.random() * (width - x));
		h = (int)(Math.random() * (height - y));
		
		g.fillOval(x, y, w, h);
	}
	
}
