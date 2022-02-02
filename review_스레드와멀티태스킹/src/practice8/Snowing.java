package practice8;

import javax.swing.JFrame;

public class Snowing extends JFrame {
	public Snowing() {
		super("눈 내리는 사갈의 마을");
		
		buildGUI();
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI() {
		Snow snow = new Snow();
		
		this.add(snow);
	}
}
