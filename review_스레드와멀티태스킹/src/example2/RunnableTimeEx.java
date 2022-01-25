package example2;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RunnableTime implements Runnable {
	private int num;
	private JLabel label;
	
	public RunnableTime(int num, JLabel label) {
		this.num = num;
		this.label = label;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			num++;
			label.setText(Integer.toString(num));
		}
	}
	
	
}
public class RunnableTimeEx extends JFrame {
	public RunnableTimeEx() {
		super("Runnable을 구현한 타이머 예제");
		
		buildGUI();
		
		this.setSize(250, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		int num = 0;
		JLabel label = new JLabel(Integer.toString(num));
		label.setFont(new Font("Gordic", Font.ITALIC, 80));
		this.add(label);
		
		Thread thread = new Thread(new RunnableTime(num, label));
		thread.start();		
	}
	public static void main(String[] args) {
		new RunnableTimeEx();
	}
}
