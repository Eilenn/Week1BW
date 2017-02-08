package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciNegativeDoubleArgumentTest {

	@Test
	public void testFibNegativeArgument() throws IllegalArgumentException {
		try {
			double n=-7.0;
			Fibonacci.fib(n);
			fail("ujemny argument powinien wyrzucic wyjatek IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Numer elementu ciagu musi byc liczba nieujemna!"));
		}

	}

}
