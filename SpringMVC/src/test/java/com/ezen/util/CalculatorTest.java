package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	// 다른 폴더에 있지만 같은 패키지에 있어 import가 필요없다.
	Calculator calc = new Calculator();
	
	static int i;
	int a,b;
	
//	@Before
//	public void before() {
//		System.out.println("Execute @Before (" + ++i + ")");
//		a=10;
//		b=20;
//	}
//	
//	@After
//	public void after() {
//		System.out.println("Execute @After (" + i + ")");
//	}

	@Test
	public void addtest() {
		int result = calc.add(10, 20);
		assertEquals(30, result);
	}
	
	@Test
	public void randomtest1() {
		for (int i = a; i < b; i++) {
			assertTrue(calc.randomInt(i) < i - 1);
		}
	}
	
	@Test
	public void randomtest2() {
		for (int i = a; i < b; i++) {
			assertTrue(calc.randomInt(i) < i - 1);
		}
	}
	
	@Test
	public void randomtest3() {
		for (int i = a; i < b; i++) {
			assertTrue(calc.randomInt(i) < i - 1);
		}
	}
	
	/*
	  	(1) 실행하면 짝수인 양의 정수를 생성하여 반환하는 메서드를 정의한 후 알맞은 테스트 케이스를 작성 
	  
	  	(2) 어떤 숫자를 하나 전달하면 소수인지 아닌지 판별해주는 메서드를 정의한 후 알맞은 테스트 케이스를 작성
	 */
	
	@Test
	public void evenTest() {
		int even = calc.even();
		boolean check = false;
		
		if (even % 2 == 0) {
			check = true;
		}
		assertTrue(check);
	}
	
	@Test
	public void primeTest() {
		boolean prime = calc.prime(13);
		
		assertTrue(prime);
	}
	
	// 강사님 풀이
	
	@Test
	public void getEvenTest1() {
		int num = calc.getEven();
		assertTrue(num % 2 == 0);
	}
	
	@Test
	public void getEvenTest2() {
		int num = calc.getEven();
		assertTrue(num % 2 == 1);
	}
	
	@Test
	public void getEvenTest3() {
		ArrayList<Integer> evens = new ArrayList<>();
		
		for (int i = 0; i < 20000; i++) {
			evens.add(calc.getEven());
		}
		assertFalse("evens에 0이 발견되었습니다." , evens.contains(0));
	}
	
	@Test
	public void isPrimeTest1() {
		assertTrue(calc.isPrime(13));
	}
	
	@Test
	public void isPrimeTest2() {
		assertTrue(calc.isPrime(14));
	}
	
	@Test
	public void isPrimeTest3() {
		assertTrue("1을 소수로 판별함" , calc.isPrime(1));
	}
	
	@Test
	public void isPrimeTest4() {
		assertTrue("-7을 소수로 판별함" , calc.isPrime(-7));
	}
	

}




















