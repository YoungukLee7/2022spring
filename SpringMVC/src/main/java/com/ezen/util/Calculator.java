package com.ezen.util;

public class Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	
	public int randomInt(int size) {
		return (int)(Math.random() * size);
	}
	
	/*
  		(1) 실행하면 짝수인 양의 정수를 생성하여 반환하는 메서드를 정의한 후 알맞은 테스트 케이스를 작성 
  
  		(2) 어떤 숫자를 하나 전달하면 소수인지 아닌지 판별해주는 메서드를 정의한 후 알맞은 테스트 케이스를 작성
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
	
	// 강사님 풀이
	
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

















