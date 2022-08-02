package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	// �ٸ� ������ ������ ���� ��Ű���� �־� import�� �ʿ����.
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
	  	(1) �����ϸ� ¦���� ���� ������ �����Ͽ� ��ȯ�ϴ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ� 
	  
	  	(2) � ���ڸ� �ϳ� �����ϸ� �Ҽ����� �ƴ��� �Ǻ����ִ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ�
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
