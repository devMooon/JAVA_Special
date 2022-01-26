package example6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFinishFlagEx extends JFrame {
	private ThreadFinishFlagRunnable runnable;
	private JLabel label;
	
	public ThreadFinishFlagEx() {
		super("화면을 마우스로 클릭해 보세요.");
		
		buildGUI();
		buildListener();
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildListener() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				runnable.finish();
				ThreadFinishFlagEx.this.removeAll();
				
				label = new JLabel();
				label.setText("Finish");
				label.setLocation(100, 100);
				label.setFont(new Font("Gordic", Font.ITALIC, 20));
				label.setForeground(Color.RED);
				ThreadFinishFlagEx.this.add(label);				
			}
			
		});
	}
	private void buildGUI() {
		
		runnable = new ThreadFinishFlagRunnable(this);
		Thread thread = new Thread(runnable);
		
		thread.start();
		
	}
	
}
