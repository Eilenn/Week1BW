package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciDuzyIntTest {

	@Test
	public void testFibDuzyInt() throws ResultOutOfRangeException {
		long wynik92 = 7540113804746346429L;
		int n = 92;
		long wynik = Fibonacci.fib(n);
		assertEquals(wynik92, wynik, 0);

	}

}
