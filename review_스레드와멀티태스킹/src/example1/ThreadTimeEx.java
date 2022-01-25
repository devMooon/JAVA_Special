package example1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ThreadTimeEx extends JFrame {
	public JLabel number;
	
	public ThreadTimeEx() {
		super("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
		this.setSize(400, 200);
		this.setLayout(new BorderLayout());
		buildGUI();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		number = new JLabel("0");
		number.setFont(new Font("Gorthic", Font.ITALIC, 80));
		
		panel.add(number);
		this.add(panel);
		
		Thread thread = new TimeThread();
		thread.start();
	}
	
	public class TimeThread extends Thread {
		//����Ŭ������ ������ �ʰ� �������� �μ��� label�� �Ѱܹޱ�
		public int num = 0;
		
		@Override
		public void run() {
			
			while(true) {
				num += 1;
				number.setText(num + " "); //Integer.toString(num);
				
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadTimeEx();
	}
	
}

