package practice8;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Snow extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.fillOval(20, 20, 5, 5);
	}
	
}
