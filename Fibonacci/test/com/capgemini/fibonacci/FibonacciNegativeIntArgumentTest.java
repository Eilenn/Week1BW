package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciNegativeIntArgumentTest {

	@Test // (expected = IllegalArgumentException.class)
	public void testFibNegativeArgument() throws IllegalArgumentException, ResultOutOfRangeException {
		try {
			int n=-8;
			Fibonacci.fib(n);
			fail("ujemny argument powinien wyrzucic wyjatek IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Numer elementu ciagu musi byc liczba nieujemna!"));
			System.out.println("Numer elementu nie moze byc ujemny");
		}

	}

}
