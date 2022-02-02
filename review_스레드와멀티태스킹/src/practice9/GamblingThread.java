package practice9;

import java.util.Vector;

import javax.swing.JLabel;

public class GamblingThread extends Thread {
	private Vector<JLabel> nums;
	private JLabel comment;
	private boolean start = false;
	private int num = 0;

	public GamblingThread(Vector<JLabel> nums, JLabel comment) {
		this.nums = nums;
		this.comment = comment;
	}
	
	synchronized public void startGambling() {
		start = true;
		this.notify();
	}
	synchronized public void waitForGambling() {
		if(!start) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			waitForGambling();
			comment.setText("뽑기중...");
			for(int k = 0; k < nums.size(); k++) {
				for(int i = 0; i <10; i++) {
					nums.get(k).setText("   " + ++num + "   ");
					if(num == 4) num = -1;
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				nums.get(k).setText("   " + (int)(Math.random() * 5) + "   ");
			}
			int num1 = Integer.parseInt(nums.get(0).getText().trim());
			int num2 = Integer.parseInt(nums.get(1).getText().trim());
			int num3 = Integer.parseInt(nums.get(2).getText().trim());
			System.out.println(num1 + ", " + num2 + ", " + num3);
			if(num1 == num2 && 
					num2 == num3) comment.setText("축하합니다!!");
			else comment.setText("아쉽군요");
			start = false;
		}
	}
}
