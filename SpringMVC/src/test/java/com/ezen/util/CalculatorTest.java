package com.ezen.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	// �ٸ� ������ ������ ���� ��Ű���� �־� import�� �ʿ����.
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
	  	(1) �����ϸ� ¦���� ���� ������ �����Ͽ� ��ȯ�ϴ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ� 
	  
	  	(2) � ���ڸ� �ϳ� �����ϸ� �Ҽ����� �ƴ��� �Ǻ����ִ� �޼��带 ������ �� �˸��� �׽�Ʈ ���̽��� �ۼ�
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
	
	// ����� Ǯ��
	
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
		assertFalse("evens�� 0�� �߰ߵǾ����ϴ�." , evens.contains(0));
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
		assertTrue("1�� �Ҽ��� �Ǻ���" , calc.isPrime(1));
	}
	
	@Test
	public void isPrimeTest4() {
		assertTrue("-7�� �Ҽ��� �Ǻ���" , calc.isPrime(-7));
	}
	

}




















