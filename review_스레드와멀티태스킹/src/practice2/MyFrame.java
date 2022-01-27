package practice2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private JPanel panel;
	
	public MyFrame() {
		super("원을 0.5초 간격으로 이동");
		
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				panel = new MyPanel();
				MyFrame.this.setContentPane(panel);
				
				revalidate();
			}
			
		});
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

}
