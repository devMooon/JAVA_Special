package example3;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {
		super("FlickeringLabelEx ����");
		
		buildGUI();
		
		this.setSize(300, 200);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		FlickeringLabel label = new FlickeringLabel("���� ����", 1);
		Thread thread = new Thread(label);
		this.add(label);
		
		thread.start();
		
	}
}
