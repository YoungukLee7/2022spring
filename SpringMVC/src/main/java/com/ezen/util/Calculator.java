package com.ezen.util;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	
	public int randomInt(int size) {
		return (int)(Math.random() * size);
	}
	
	/*
  		(1) �����ϸ� ¦���� ���� ������ �����Ͽ� ��ȯ�ϴ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ� 
  
  		(2) � ���ڸ� �ϳ� �����ϸ� �Ҽ����� �ƴ��� �Ǻ����ִ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ�
	 */
	
	public int even() {
		int num = (int)(Math.random() * 100);
		if (num % 2 == 1) {
			return num + 1;			
		}else {
			return num;
		}
	}
	
	
	
	public boolean prime(int num) {
		
		boolean bool = false;

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				bool = false;
				break;
			}else {
				bool = true;
				break;
			}
		}
		return bool;
	}
	
	// ����� Ǯ��
	
	public int getEven() {
		int num = (int)(Math.random() * 10000);
		return num % 2 == 0 ? num : num + 1;
	}

	public boolean isPrime(int num) {
		
		double sqrt = Math.sqrt(num);
		
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}

















