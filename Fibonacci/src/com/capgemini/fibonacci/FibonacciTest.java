package com.capgemini.fibonacci;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {
	private Fibonacci fibonacci;
	@Before
	 public void setUp() throws Exception {
	  fibonacci = new Fibonacci();
	 }
	 
	 @After
	 public void tearDown() throws Exception {
	  fibonacci = null;
	 }
	@Test
	public void testFib() {
		long wynik=fibonacci.fib(5);
		assertEquals(5, wynik,0);
		//fail("Not yet implemented");
	}

}
