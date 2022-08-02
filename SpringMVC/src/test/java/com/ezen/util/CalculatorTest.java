package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	// 다른 폴더에 있지만 같은 패키지에 있어 import가 필요없다.
	Calculator calc = new Calculator();
	
	static int i;
	int a,b;
	
	@Before
	public void before() {
		System.out.println("Execute @Before (" + ++i + ")");
		a=10;
		b=20;
	}
	
	@After
	public void after() {
		System.out.println("Execute @After (" + i + ")");
	}

	@Test
	public void addtest() {
		int result = calc.add(a, b);
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
		System.out.println(even);
	}
	
	@Test
	public void primeTest() {
		boolean prime = calc.prime(13);
		
		assertTrue(prime);
	}

}
