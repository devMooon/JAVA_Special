package example3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class FlickeringLabel extends JLabel implements Runnable {
	private int time;
	
	public FlickeringLabel(String str, int time) {
		super(str);
		
		this.time = time;
		this.setOpaque(true); //배경색을 변경 가능하게 설정.. //Opaque: 불투명체
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			this.setBackground(Color.green);
			
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.setBackground(Color.yellow);
			
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
