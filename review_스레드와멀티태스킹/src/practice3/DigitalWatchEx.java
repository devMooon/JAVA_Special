package practice3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalWatchEx extends JFrame {
	private JPanel panel;
	
	public DigitalWatchEx() {
		super("디지털 시계 만들기");
		
		buildGUI();
		buildThread();
		
		this.setSize(500,  250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void buildGUI() {
		this.setLayout(new GridLayout(3, 1));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.add(new JPanel());
		this.add(panel);
	}
	private void buildThread() {
		Runnable runnable = new DigitalWatchRunnable(panel);
		Thread thread = new Thread(runnable);
		
		thread.start();
	}
	
}
