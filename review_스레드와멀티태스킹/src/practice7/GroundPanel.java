package practice7;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GroundPanel extends JPanel implements Runnable{
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	private int direction;
	private Image img;
	//private SnakeBody snakeBody;
	private final int delay = 200;
	
	public GroundPanel() {
		setLayout(null);
		/*snakeBody = new SnakeBody();
		snakeBody.addIn(this);
		direction = LEFT;
		this.addKeyListener(new MyKeyListener());*/
		JLabel label = new JLabel("dsfgdfsd");
		label.setBounds(0, 0, 100, 100);
		
		ImageIcon icon = new ImageIcon("desert.jpg");
		img = icon.getImage();
		this.add(label);
		
		JLabel label2 = new JLabel("hgjdfgh");
        label2.setSize(100, 100);
        label2.setLocation(100, 100);
        add(label2);
        
        ImageIcon icon2 = new ImageIcon("eyes.png");
        JLabel ladfsdfsdJLabel = new JLabel(icon2);
        ladfsdfsdJLabel.setSize(100, 100);
        ladfsdfsdJLabel.setLocation(100, 100);
        
		JLabel label2w = new JLabel("dfsdf");
		label2w.setSize(100, 100);
		label2w.setLocation(100, 100);
	        
		add(ladfsdfsdJLabel);
		add(label2w);
		
        setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		revalidate();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0,0,getWidth(), getHeight(), null);
		
	}
}