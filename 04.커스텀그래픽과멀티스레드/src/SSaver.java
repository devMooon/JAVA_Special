import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;


public class SSaver extends JComponent {
	
	private static Random rand = new Random();
	
	private Point mPos = new Point();
	public String mText;
	private int mSpeed;
	private int mWidth, mheight;
	
	public SSaver(int width, int height, int speed) {
		mWidth = width;
		mheight = height;
		
		mPos.x = 0;
		mPos.y = 50 + rand.nextInt(mheight - 100);
		
		mText = "Hello World!";
		mSpeed = speed;
	}
	
	public void move() {
		mPos.x += mSpeed;
		if(mPos.x >= mWidth) {
			//문자열의 길이를 파악해서 음수로 설정 해보자..
			mPos.x = 0;
			mPos.y = 50 + rand.nextInt(mheight - 100);
		}
		
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, mWidth, mheight);
		
		g.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
		
		g.setColor(Color.WHITE);
		g.drawString(mText, mPos.x, mPos.y);
	}
	
	

}
