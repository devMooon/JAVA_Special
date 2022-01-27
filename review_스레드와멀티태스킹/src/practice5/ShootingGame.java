package practice5;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShootingGame extends JFrame {
	public boolean active = false;
	private JLabel ghostLabel;
	private JLabel bulletLabel;
	
	public ShootingGame() {
		super("Shooting Game");
		
		this.setLayout(null);
		registerListener();
		
		buildGUI();
		buildGhostThread();
		
		this.setSize(500, 400);
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
						Thread thread = new BulletThread(bulletLabel);
						thread.start();
						
						//한번에 하나씩만 발사 가능
						//만약 고스트에 닿았거나 위쪽 끝에 닿았을 경우 처음 위치로 돌아가서 스레드 정지
						thread.interrupt();
					}
				}
			}
		});
	}
	private void buildGUI() {
		
		createGhost();
		createBullet();
		createGun();
		
	}
	private void createGhost() {
		
		ImageIcon ghostIcon = new ImageIcon("ghost.png");
		Image ghostImage = ghostIcon.getImage();
		ghostIcon.setImage(ghostImage.getScaledInstance(100,100, Image.SCALE_SMOOTH)); //이미지 크기 조정
		
		ghostLabel = new JLabel(ghostIcon);
		ghostLabel.setBounds(400, 0, 100, 100);
		this.add(ghostLabel);
		
	}
	private void createGun() {
		
		JLabel gunLabel = new JLabel();
		gunLabel.setOpaque(true);
		gunLabel.setBounds(230, 303, 60, 60);
		gunLabel.setBackground(Color.DARK_GRAY);		
		this.add(gunLabel);
		
	}
	private void createBullet() {
		
		bulletLabel = new JLabel();
		bulletLabel.setOpaque(true);
		bulletLabel.setBounds(253, 288, 15, 15);
		bulletLabel.setBackground(Color.red);		
		this.add(bulletLabel);
		
	}
	

	
	private void buildGhostThread() {
		//계속 왼쪽으로 20ms당 5픽셀식 이동, 왼쪽 끝에 닿으면 다시 오른쪽 끝에서 등장
		Thread thread = new GhostThread(ghostLabel);
		thread.start();
	}
}
