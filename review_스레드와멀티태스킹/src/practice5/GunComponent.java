package practice5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

public class GunComponent extends JComponent {
	private int w = 500;
	private int h = 500;
	
	private int gunSize = 60;
	private int bulletSize = 10;
	
	private int gun_wTerm = w - gunSize*5 + 30; //500 - 300 + 30
	private int gun_hTerm = h - gunSize*2 + 22; //500 - 120 + 22
	
	private int bullet_wTerm = gun_wTerm + bulletSize*2 + 5; //500 - 300 + 30	+ (25)
	private int bullet_hTerm = gun_hTerm - bulletSize; //500 - 120 + 22			- (10)

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.fillRect(gun_wTerm, gun_hTerm, gunSize, gunSize);
		
		g.setColor(Color.red);
		g.fillRect(bullet_wTerm, bullet_hTerm, bulletSize, bulletSize);
	}
}
