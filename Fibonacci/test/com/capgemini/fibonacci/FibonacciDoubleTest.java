package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciDoubleTest {

	@Test
	public void testFibDouble() {
		double n = 5.0;
		long wynik = Fibonacci.fib(n);
		assertEquals(5, wynik, 0);
	}

}