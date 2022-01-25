package example3;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class FlickeringLabel extends JLabel implements Runnable {
	private int time;
	
	public FlickeringLabel(String str, int time) {
		super(str);
		
		this.time = time;
		this.setBackground(Color.yellow);
		this.setFont(new Font("Gordic", Font.ITALIC, 80));
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
