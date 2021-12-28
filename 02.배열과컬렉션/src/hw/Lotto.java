package hw;

import java.util.Random;

public class Lotto {
	public static final int SIZE = 6;
	
	private Random random;
	private int[] lottoNumber;
	private int nValid;
	
	public Lotto() {
		random = new Random();
		lottoNumber = new int[SIZE];
		nValid = 0;
	}
	public boolean verify() {
	
		for(int i = 0; i < nValid; i++) {
			for(int k = i + 1; k < nValid; k++) {
				if(lottoNumber[i] == lottoNumber[k]) return false;
			}
		}
		return true;
	}
	public void generate() {
		if(nValid >= SIZE) nValid = 0;
		
		int num;
		
		for(int i = nValid; i < SIZE; i++) {
			num = random.nextInt(45) + 1;
			lottoNumber[i] = num;
			nValid++;
			
			if(!verify()) {
				nValid--;
				i--;
			}
		}
	}
	public int[] getNumbers() {
		int[] lottoNum = new int[nValid];
		
		for(int i = 0; i < nValid; i++) {
			lottoNum[i] = lottoNumber[i];
		}
		
		return lottoNum; 
	}
	public boolean setNumber(int n) {
		if(nValid <= SIZE) {
			if(n < 1 || n > 45) return false;
			else {
				lottoNumber[nValid] = n;
				
				if(!verify()) return false;
				nValid++;
				return true;
			}
		}
		else return false;
	}
	public void reset() {
		nValid = 0;
	}
}
