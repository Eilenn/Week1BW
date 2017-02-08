package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciResultOutOfRangeTest {

	@Test // (expected = IllegalArgumentException.class)
	public void testFibResultOutOfRange() throws IllegalArgumentException, ResultOutOfRangeException {
		try {
			int n=93;
			Fibonacci.fib(n);
			fail("za duzy argument powinien wyrzucic wyjatek");
		} catch (ResultOutOfRangeException e) {
			assertTrue(e.getMessage().contains("Wynik operacji nie miesci sie w zakresie long"));
			System.out.println("Nie da sie obliczyc wyniku");
		}

	}

}
