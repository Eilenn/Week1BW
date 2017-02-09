package com.capgemini.fibonacci;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class FibonacciTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	// testing an integer
	@Test
	public void testFibInt() {
		int n = 5;
		long result = Fibonacci.fib(n);
		assertEquals(5, result, 0);

	}

	// testing first series' element
	@Test
	public void testFibOne() {
		int n = 1;
		long result = Fibonacci.fib(n);
		assertEquals(1, result, 0);

	}

	// testing second series' element
	@Test
	public void testFibTwo() {
		int n = 2;
		long result = Fibonacci.fib(n);
		assertEquals(1, result, 0);

	}

	// testing big integer, one before crossing long's range
	@Test
	public void testFibBigInt() {
		final long result92 = 7540113804746346429L;
		int n = 92;
		long wynik = Fibonacci.fib(n);
		assertEquals(result92, wynik, 0);

	}

	// Exception throwing tests

	// testing if zero causes exception throwing

	@Test(expected = IllegalArgumentException.class)
	public void testFibZero() {
		int n = 0;
		long result = Fibonacci.fib(n);
	}

	// testing if zero causes exception throwing with correct message
	@Test
	public void shouldTestIllegalArgumentExceptionMessageForZero() throws IllegalArgumentException {
		int n = 0;
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Element's number must be a non-negative number!");
		long result = Fibonacci.fib(n);
	}

	// testing if argument too big for computation to fit into long throws an
	// exception
	@Test(expected = ResultOutOfRangeException.class)
	public void testfibResultOutOfRange() {

		int n = 93;
		long result = Fibonacci.fib(n);

	}

	// testing if argument too big for computation to fit into long throws an
	// exception with correct message
	@Test
	public void shouldTestFibResultOutOfRangeExceptionMessage() throws ResultOutOfRangeException {

		int n = 93;
		thrown.expect(ResultOutOfRangeException.class);
		thrown.expectMessage("Result of this operation is out of range");
		long result = Fibonacci.fib(n);

	}

	// testing if negative argument throws an IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void testFibNegativeIntArgument() {

		int n = -8;
		long result = Fibonacci.fib(n);

	}

	// testing if negative argument throws an IllegalArgumentException with a
	// correct message
	@Test
	public void shouldTestIllegalArgumentExceptionMessageForNegativeArgument() throws ResultOutOfRangeException {

		int n = -8;
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Element's number must be a non-negative number!");
		long result = Fibonacci.fib(n);

	}

}
