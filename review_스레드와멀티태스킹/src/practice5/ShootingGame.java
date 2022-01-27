package practice5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShootingGame extends JFrame {
	public boolean active = false;
	
	public ShootingGame() {
		super("Shooting Game");
		
		registerListener();
		buildChickenThread();
		buildGUI();
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void registerListener() {
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(!active) {
						active = true;
						Thread thread = new BulletThread(ShootingGame.this);
						thread.start();
					}
				}
			}
		});
	}
	
	private void buildChickenThread() {
		
	}
	private void buildGUI() {
		JLabel label = new JLabel("ddd");
		
		GunComponent gun = new GunComponent();
		
		this.add(label);
		//this.add(gun);
	}
}
