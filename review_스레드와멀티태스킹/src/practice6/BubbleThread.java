package practice6;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BubbleThread extends Thread {
	//프레임에 이미지 레이블 추가
	//마우스를 클릭한 위치와 프레임 넘겨받기
	private JFrame frame;
	private int x;
	private int y;
	private int term = 5;
	private Image image;
	private ImageIcon imageIcon;
	
	
	public BubbleThread(JFrame frame, int x, int y) {
		this.frame = frame;
		this.x = x;
		this.y = y;
		
		imageIcon = new ImageIcon("heart.png");
		Image heartImage = imageIcon.getImage();
		imageIcon.setImage(heartImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH)); //이미지 크기 조정
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		JLabel heartLabel = new JLabel(imageIcon);
		heartLabel.setBounds(x, y, 60, 60);
		
		frame.add(heartLabel);
		
		while (y + heartLabel.getHeight() > 0) { 
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			y -= term;
			heartLabel.setLocation(x, y);
		}
		frame.remove(heartLabel);
		return;
	}
	
	
	
	
}
