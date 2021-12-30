import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCounter extends JFrame {
	private JLabel mLblDisplay = new JLabel("0");
	private Thread thread;

	private JButton mBtnStart = new JButton("START");
	private JButton mBtnPause = new JButton("PAUSE");
	private JButton mBtnReset = new JButton("RESET");

	public JCounter() {
		super("Counter");

		buildGUI();
		this.pack();
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void buildGUI() {
		// 프레임 구성
		add(createDisplayPanel(), BorderLayout.CENTER);
		add(createBtnPanel(), BorderLayout.SOUTH);
	}

	// 표시부 패널
	private JPanel createDisplayPanel() {
		mLblDisplay.setFont(new Font("Courier New", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);

		panel.add(mLblDisplay);

		return panel;
	}

	// 버튼 패널
	private JPanel createBtnPanel() {
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
				//라벨 객체의 숫자를 얻어와 1증가 후 다시 설정하는 일을 1초마다 반복
				int num = Integer.parseInt(mLblDisplay.getText());
				thread = new Thread(new newRunnable(num));
				
				thread.start();
			}
			else if (src == mBtnPause) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(true);
				//화면 갱신을 중지
				thread = null;
			}
			else if (src == mBtnReset) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(false);
				
				mLblDisplay.setText("0");
			}

		}

	};

	class newRunnable implements Runnable {
		private int num;
		
		public newRunnable(int num) {
			this.num = num;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(thread != Thread.currentThread())
					break;
				
				mLblDisplay.setText(String.valueOf(num++));
			}
		}
		
	}


	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new JCounter();
	}

}
