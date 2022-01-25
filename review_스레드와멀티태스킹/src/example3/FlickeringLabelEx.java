package example3;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelEx extends JFrame {
	private JLabel[] labels;
	
	public FlickeringLabelEx() {
		super("FlickeringLabelEx 예제");
		
		labels = new JLabel[3];
		buildGUI();
		
		this.setSize(300, 200);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void buildGUI() {
		labels[0] = new FlickeringLabel("깜박", 1); //깜박이는 레이블
		labels[1] = new JLabel(" 안깜박 ");
		labels[2] = new FlickeringLabel("여기도 깜박", 2); //깜박이는 레이블
		
		for(JLabel label : labels) {
			label.setFont(new Font("Gordic", Font.ITALIC, 20));
			this.add(label);
		}
	}
}
