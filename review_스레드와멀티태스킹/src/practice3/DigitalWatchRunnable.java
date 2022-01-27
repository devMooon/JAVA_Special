package practice3;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalWatchRunnable implements Runnable {
	private Calendar calendar;
	private int hour;
	private int minute;
	private int second;
	private String clockText;
	
	private JPanel panel;
	
	public DigitalWatchRunnable(JPanel panel) {
		this.panel = panel;
	}
	@Override
	public void run() {
		JLabel label = new JLabel();
		
		label.setFont(new Font("Gordic", Font.BOLD, 50));
		panel.add(label);
		
		while(true) {
			calendar = Calendar.getInstance(); //현재 날짜, 시간, 분, 초 값을 가진 객체 얻기
			 
			hour = calendar.get(Calendar.HOUR_OF_DAY);
			minute = calendar.get(Calendar.MINUTE);
			second = calendar.get(Calendar.SECOND);
			
			clockText = Integer.toString(hour);
			clockText = clockText.concat(" : ");
			clockText = clockText.concat(Integer.toString(minute));
			clockText = clockText.concat(" : ");
			clockText = clockText.concat(Integer.toString(second));
			
			label.setText(clockText);
		}
	}
}
