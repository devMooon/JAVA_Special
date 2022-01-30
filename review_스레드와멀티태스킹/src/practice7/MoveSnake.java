package practice7;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoveSnake extends JFrame {
	private GroundPanel p;
	
	public MoveSnake() {
		super("Snake Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new GroundPanel();
		setContentPane(p);
		setSize(400,400);
		setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
	}
}

