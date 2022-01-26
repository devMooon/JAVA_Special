//TabAndThread: 0.2초 간격으로 바의 보라색을 1/100씩 왼쪽으로
//TabAndThreadEx: 마우스를 클릭할수록 보라색을  1/100씩 오른쪽으로
//MyLabel: JLabel을 상속받아 paintComponent()메서드로 노란색 바 생성

//공유 변수: MyLabel, 보라색 너비
package example7;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class TabAndThreadEx extends JFrame {
	
	public TabAndThreadEx() {
		super("마우스를 빨리 눌러 바 채우기");
		
		setRegister();
		buildGUI();
		
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private void setRegister() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				//보라색 게이지 증가
			}
			
		});
	}
	private void buildGUI() {
		MyLabel bar = new MyLabel();
		
		bar.setBackground(Color.yellow);
		bar.setOpaque(true);
		bar.setSize(300, 20);
		
		bar.repaint();
		
		this.add(bar);
	}
}
