package practice6;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class BubbleFrame extends JFrame {
	public BubbleFrame() {
		super("Bubble Game");
		this.setLayout(null);
		
		registerListener();
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void registerListener() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				
				Thread thread = new BubbleThread(BubbleFrame.this, e.getX() - 40, e.getY() - 50);
				thread.start();
				
				revalidate();
				repaint();
			}
			
		});
	}
}
