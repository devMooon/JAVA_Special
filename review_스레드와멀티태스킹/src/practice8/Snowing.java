package practice8;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;

public class Snowing extends JFrame {
	private Vector<Snow> snows;
	private LetItSnowThread thread = null;
	public Snowing() {
		super("눈 내리는 사갈의 마을");
		
		makeSnow();
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void makeSnow(){
		snows = new Vector<Snow>();
		
		for(int i = 0; i < 30; i++) {
			Snow snow = new Snow();
			this.add(snow);
			snows.add(snow);
			
		}
		
		Iterator itr = snows.iterator();
		
		while(itr.hasNext()) {
			Snow snow = (Snow)itr.next();
			thread =  new LetItSnowThread(snow);
			System.out.println(snow.getY());
			thread.start();
		}
	}
}
