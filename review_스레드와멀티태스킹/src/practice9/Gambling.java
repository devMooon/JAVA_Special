package practice9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gambling extends JFrame {
	private JLabel comment;
	private GamblingThread thread;
	private Vector<JLabel> nums = new Vector<JLabel>(3);
	public Gambling() {
		super("스레드를 가진 겜블링");
		
		this.setLayout(new GridLayout(4, 1));
		buildGUI();
		registerListener();
		
		thread = new GamblingThread(nums, comment);
		thread.start();
		
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI() {
		JPanel panel = new JPanel(new FlowLayout());
		JPanel commentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		for(int i = 0; i < 3; i++) {
			JLabel label = new JLabel("   " + 0 + "   ");
			label.setFont(new Font("Gordic", Font.ITALIC, 30));
			label.setOpaque(true);
			label.setBackground(Color.MAGENTA);
			label.setForeground(Color.YELLOW);
			panel.add(label);
			nums.add(label);
		}
		
		comment = new JLabel("마우스를 클릭할 때 마다 게임합니다.");
		comment.setFont(new Font("Gordic", Font.BOLD, 20));
		
		commentPanel.add(comment);
		
		this.add(new JPanel());
		this.add(panel);
		this.add(commentPanel);
	}
	private void registerListener() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				
				thread.startGambling();
			}
			
		});
	}
}
