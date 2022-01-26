package example6;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFinishFlagRunnable implements Runnable {
	private Random random = new Random();
	private Vector<JLabel> vector = new Vector<JLabel>();
	private JFrame frame;
	static private boolean flag = true;
	
	public ThreadFinishFlagRunnable(JFrame frame) {
		this.frame = frame;
	}
	public void finish() { 
		flag = false; 
	}
	
	@Override
	public void run() {
		while(flag) {
			vector.add(new JLabel("java"));
			vector.lastElement().setLocation(random.nextInt(300), random.nextInt(300));
			Iterator<JLabel> itr = vector.iterator();
			while(itr.hasNext()) {
				frame.add(itr.next());
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
