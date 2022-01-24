package ex;

import java.util.Scanner;

class CountRunnable implements Runnable {
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n스레드 종료");
	}
}


public class Ex1 {
	static private Thread thread;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("아무 키나 입력>>");
		s.next();
		
		CountRunnable runnable = new CountRunnable();
		thread = new Thread(runnable);
		thread.start();

	}
}

