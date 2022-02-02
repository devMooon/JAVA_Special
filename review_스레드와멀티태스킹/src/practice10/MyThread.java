package practice10;

public class MyThread extends Thread {
	private boolean start = false;
	private MyComponent oval = null;
	
	public MyThread(MyComponent oval) {
		this.oval = oval;
	}
	
	public void stopDrawing() {
		start = false;
	}
	//wait-notify 메소드를 호출하는 코드는 synchronized로 지정되어 있어야 함
	synchronized public void startDrawing() {
		start = true;
		this.notify();
	}
	synchronized public void waitForDrawing() {
		if(!start) {
			try {this.wait();} 
			catch (InterruptedException e) {return;}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			waitForDrawing();
			System.out.println("스레드 동작중..");
			
			oval.repaint();
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
