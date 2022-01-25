package example5;

import javax.swing.JLabel;

public class KillTimerRunnable implements Runnable {
	private JLabel label;
	private int num;
	
	public KillTimerRunnable(JLabel label, int num) {
		this.label = label;
		this.num = num;
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			
			label.setText(Integer.toString(num));
			num++;
		}
	}

}
