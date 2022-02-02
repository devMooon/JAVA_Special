package practice10;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class DrawOval extends JFrame {
	private MyThread thread = null;
	private MyComponent oval = null;
	
	public DrawOval() {
		super("Make Drawing to Start");
		
		makeThread();
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void makeThread(){
		
		this.addMouseListener(new MouseAdapter() {

			@Override // ���콺�� ������ ���� �ö���� ��
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				
				if(thread == null) {
					oval = new MyComponent();
					DrawOval.this.add(oval);
					
					thread = new MyThread(oval);
					thread.start();
					
					revalidate();
				}
				
				System.out.println("������!!");
				thread.startDrawing();
			}

			@Override // ���콺�� �����ӿ��� �������� ��
			synchronized public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				
				System.out.println("����!!");
				
				thread.stopDrawing();
			}
			
		});
	}
}
