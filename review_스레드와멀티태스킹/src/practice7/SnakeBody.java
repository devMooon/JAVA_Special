package practice7;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakeBody {
	private Vector<JLabel> snake;
	private Image img;
	
	public SnakeBody() {
		ImageIcon icon = new ImageIcon("desert.jpg");
		img = icon.getImage();
		
		snake = new Vector<JLabel>();
		
		snake.add(new JLabel(icon));
	}

	public void addIn(JPanel panel) {
		panel.add(snake.get(0));
	}
	
}