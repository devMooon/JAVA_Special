package example5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KillTimerEx extends JFrame {
	private int num = 0;
	
	public KillTimerEx() {
		super("Thread Interrupt ¿¹Á¦");
		
		buildGUI();
		
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new FlowLayout());
		
		JLabel label = new JLabel(Integer.toString(num));
		label.setFont(new Font("Gordic", Font.ITALIC, 80));
		
		JButton button = new JButton("Kill Timer");
		
		panel.add(label);
		this.add(panel);
		this.add(button, BorderLayout.SOUTH);
		
		Thread thread = new Thread(new KillTimerRunnable(label, num));
		thread.start();
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(false);
				thread.interrupt();
			}

			
			
		});
	}
}
