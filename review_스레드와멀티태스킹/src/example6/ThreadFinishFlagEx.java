package example6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFinishFlagEx extends JFrame {
	private JLabel label;
	
	public ThreadFinishFlagEx() {
		super("화면을 마우스로 클릭해 보세요.");
		
		buildListener();
		buildGUI();
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildListener() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				label.setVisible(true);
				ThreadFinishFlagRunnable.finish();
			}
			
		});
	}
	private void buildGUI() {
		label = new JLabel();
		label.setText("Finish");
		label.setLocation(100, 100);
		label.setFont(new Font("Gordic", Font.ITALIC, 20));
		label.setForeground(Color.RED);
		label.setVisible(false);
		this.add(label);
		
		ThreadFinishFlagRunnable runnable = new ThreadFinishFlagRunnable(this);
		Thread thread = new Thread(runnable);
		
	}
}
