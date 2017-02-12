package com.capgemini.hanoi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HanoiTest {

	/*
	 * @Test public void shouldPlayCorrectly() { // given Hanoi.setBoard(); //
	 * when
	 * 
	 * fail("Not yet implemented"); }
	 */

	@Test
	public void shouldCreateSpecifiedNumberOfRings() {
		// given
		int numberOfRings = 10;
		// when
		ArrayList<Integer> listOfRings = Hanoi.createRings(numberOfRings);
		// then
		assertTrue(listOfRings.size() == numberOfRings);
	}

}
