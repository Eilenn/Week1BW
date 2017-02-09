package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFibDuzyInt() throws ResultOutOfRangeException {
		long wynik92 = 7540113804746346429L;
		int n = 92;
		long wynik = Fibonacci.fib(n);
		assertEquals(wynik92, wynik, 0);

	}
	@Test
	public void testFibFloat() {
		float n = 5.0f;
		long wynik = Fibonacci.fib(n);
		assertEquals(5, wynik, 0);
	}
	@Test
	public void testFibDouble() {
		double n = 5.0;
		long wynik = Fibonacci.fib(n);
		assertEquals(5, wynik, 0);
	}
	@Test
	public void testFibInt() throws ResultOutOfRangeException {
		int n=5;
		long wynik = Fibonacci.fib(n);
		assertEquals(5, wynik, 0);

	}
	@Test
	public void testFibNegativeDoubleArgument() throws IllegalArgumentException {
		try {
			double n=-7.0;
			Fibonacci.fib(n);
			fail("negative argument should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Element's number must be a non-negative number!"));
		}

	}
	@Test // (expected = IllegalArgumentException.class)
	public void testFibNegativeIntArgument() throws IllegalArgumentException, ResultOutOfRangeException {
		try {
			int n=-8;
			Fibonacci.fib(n);
			fail("negative argument should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Element's number must be a non-negative number!"));
			System.out.println("Element's number must be a non-negative number!");
		}

	}
	@Test // (expected = IllegalArgumentException.class)
	public void testFibResultOutOfRange() throws IllegalArgumentException, ResultOutOfRangeException {
		try {
			int n=93;
			Fibonacci.fib(n);
			fail("argument too big should throw an exception");
		} catch (ResultOutOfRangeException e) {
			assertTrue(e.getMessage().contains("Result of this operation is out of range"));
			System.out.println("Result cannot be computed");
		}

	}
}
