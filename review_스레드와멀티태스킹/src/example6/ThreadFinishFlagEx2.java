package example6;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class ThreadFinishFlagEx2 extends JFrame {
	private RandomThread th; //스레드 레퍼런스
	
	public ThreadFinishFlagEx2() {
		super("Thread Finish Flag Ex 예제");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}			
		});
		
		setSize(300, 200);
		setVisible(true);
		
		th = new RandomThread(c);
		th.start();
	}
	
}
