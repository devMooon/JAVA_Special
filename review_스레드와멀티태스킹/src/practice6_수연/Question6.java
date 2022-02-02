package practice6_수연;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

class bubbleThread extends Thread{
	JFrame frame;
   MyPanel panel;
   int x, y;
   
   public bubbleThread(JFrame frame, int x, int y){
      this.frame = frame;
      this.x = x;
      this.y = y;
      
     panel = new MyPanel(x, y);
     //panel.setOpaque(true);
      panel.setBackground(Color.YELLOW);
      frame.add(panel);
      frame.revalidate();
   }

   @Override
   public void run() {
	  
      while(true) {
         try {
            sleep(200);
            if(y >= -50) {
            	 y -= 5;
            }
            else panel.removeAll();
            panel.setXY(x, y);
         } catch(InterruptedException e) {
            System.out.println("에러가 났어요~!");
            return;
         }
         
      }
   }
}

class MyPanel extends JComponent {
   private int x,y;
   
   public MyPanel(int x, int y) {
      this.x = x;
      this.y = y;
   }
   public void setXY(int x, int y) {
	   this.x = x;
	   this.y = y;
	   repaint();
   }
   
   
   @Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintChildren(g);
		g.setColor(Color.BLUE);
	    g.fillOval(x, y, 50, 50);
	}



}

public class Question6 {

   JFrame frame;
   
   public Question6() {
      frame = new JFrame("버블 게임");
      
      buildGUI();
      
      frame.setSize(400,400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
   
   public void buildGUI() {
      frame.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            bubbleThread th = new bubbleThread(frame, e.getX() - 50, e.getY() - 50);
            th.start();
         }
         
      });
   }
   
   public static void main(String[] args) {
      new Question6();
   }
}