package example6;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class ThreadFinishFlagEx2 extends JFrame {
	private RandomThread th; //������ ���۷���
	
	public ThreadFinishFlagEx2() {
		super("Thread Finish Flag Ex ����");
		
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
