package ex;

import java.util.Scanner;

class CountRunnable implements Runnable {
	public void run() {
		System.out.println("������ ���� ����");
		for(int i = 1; i < 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n������ ����");
	}
}


public class Ex1 {
	static private Thread thread;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("�ƹ� Ű�� �Է�>>");
		s.next();
		
		CountRunnable runnable = new CountRunnable();
		thread = new Thread(runnable);
		thread.start();

	}
}

