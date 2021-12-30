package hw;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JStopWatch extends JFrame {
	private JLabel l_mm = new JLabel("00");
	private JLabel l_ss = new JLabel("00");
	private JLabel l_ms = new JLabel("0");
	private int mm, ss, ms;

	private JButton mBtnStart = new JButton("START");
	private JButton mBtnPause = new JButton("PAUSE");
	private JButton mBtnReset = new JButton("RESET");
	
	private Thread mThread;
	
	public JStopWatch() {
		super("Stop Watch");
		
		buildGUI();
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {		
		this.add(p_display(), BorderLayout.CENTER);
		this.add(p_button(), BorderLayout.SOUTH);
	}
	
	private JPanel p_display() {
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel("  :  ");
		JLabel label2 = new JLabel("  :  ");
		
		l_mm.setFont(new Font("Courier New", Font.BOLD, 15));
		l_ss.setFont(new Font("Courier New", Font.BOLD, 15));
		l_ms.setFont(new Font("Courier New", Font.BOLD, 15));
		label1.setFont(new Font("Courier New", Font.BOLD, 15));
		label2.setFont(new Font("Courier New", Font.BOLD, 15));
		
		
		panel.add(l_mm);
		panel.add(label1);
		panel.add(l_ss);
		panel.add(label2);
		panel.add(l_ms);
		
		return panel;
	}
	
	private JPanel p_button() {
		mBtnStart.setFont(new Font("Courier New", Font.BOLD, 15));
		mBtnPause.setFont(new Font("Courier New", Font.BOLD, 15));
		mBtnReset.setFont(new Font("Courier New", Font.BOLD, 15));

		mBtnPause.setEnabled(false);
		mBtnReset.setEnabled(false);

		mBtnStart.addActionListener(handler);
		mBtnPause.addActionListener(handler);
		mBtnReset.addActionListener(handler);

		JPanel panel = new JPanel();

		panel.add(mBtnStart);
		panel.add(mBtnPause);
		panel.add(mBtnReset);

		return panel;
	}
	
	ActionListener handler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();

			if (src == mBtnStart) {
				mBtnStart.setEnabled(false);
				mBtnPause.setEnabled(true);
				mBtnReset.setEnabled(false);
				
				mm = Integer.parseInt(l_mm.getText());
				ss = Integer.parseInt(l_ss.getText());
				ms = Integer.parseInt(l_ms.getText());				
				
				mThread = new Thread(new newRunnable(mm, ss, ms));
				
				mThread.start();
			}
			else if (src == mBtnPause) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(true);
				
				//화면 갱신을 중지
				mThread = null;
			}
			else if (src == mBtnReset) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(false);
				
				l_mm.setText("00");
				l_ss.setText("00");
				l_ms.setText("0");
			}

		}

	};

	class newRunnable implements Runnable {
		private final int MAX_SS = 60;
		private final int MAX_MS = 10;
		
		private int mm, ss, ms;
		
		public newRunnable(int mm, int ss, int ms) {
			this.mm = mm;
			this.ss = ss;
			this.ms = ms;
		}

		@Override
		public void run() {
			while(true) {
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(mThread != Thread.currentThread())
					break;
				
				ms++;
				if(ms >= MAX_MS) {
					ms = 0;
					ss++;
				}
				if(ss >= MAX_SS) {
					ss = 0;
					mm++;
				}
				
				l_mm.setText(String.format("%02d", mm));
				l_ss.setText(String.format("%02d", ss));
				l_ms.setText(String.valueOf(ms));
			}
		}
		
	}
	
	public static void main(String[] args) {
		new JStopWatch();
	}

}
