//TabAndThread: 0.2�� �������� ���� ������� 1/100�� ��������
//TabAndThreadEx: ���콺�� Ŭ���Ҽ��� �������  1/100�� ����������
//MyLabel: JLabel�� ��ӹ޾� paintComponent()�޼���� ����� �� ����

//���� ����: MyLabel, ����� �ʺ�
package example7;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class TabAndThreadEx extends JFrame {
	
	public TabAndThreadEx() {
		super("���콺�� ���� ���� �� ä���");
		
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
				//����� ������ ����
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
