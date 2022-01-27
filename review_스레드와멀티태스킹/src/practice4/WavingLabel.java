package practice4;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WavingLabel extends JFrame {
	private JLabel label;
	
	public WavingLabel() {
		super("진동하는 레이블 만들기");
		
		buildGUI();
		buildThread();
		
		this.setLayout(null);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI(){
		label = new JLabel("진동 레이블");
		label.setFont(new Font("gordic", Font.BOLD, 20));
		label.setLocation(85, 90);
		label.setSize(300, 50);
		
		this.add(label);
	}
	private void buildThread(){
		Thread thread = new Thread(new WavingLabelRunnable(label));
		thread.start();		
	}
	
	class WavingLabelRunnable implements Runnable{
		private JLabel label;
		private int x;
		private int y;
		private int term = 5;
		
		public WavingLabelRunnable(JLabel label) {
			this.label = label;
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				x = label.getX() + term;
				y = label.getY() - term;
				
				term *= -1;
				
				label.setLocation(x, y);
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
