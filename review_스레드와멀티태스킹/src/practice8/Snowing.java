package practice8;

import java.awt.Color;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;

public class Snowing extends JFrame {
	
	public Snowing() {
		super("�� ������ �簥�� ����");
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		this.setVisible(true);
		
		this.add(new Snow(this));
	}
}
