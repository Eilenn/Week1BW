package com.capgemini.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private BowlingGameResultCalculator scoreCalculator;

	@Before
	public void setUp() {
		scoreCalculator = new BowlingGame();
	}

	@Test
	public void canRollAll0() {
		// given
		int numberOfPinsDown = 0;
		// when
		for (int i = 0; i < 20; i++) {
			scoreCalculator.roll(numberOfPinsDown);
		}
		// then
		assertEquals(0, scoreCalculator.score());
	}

	@Test
	public void canRollAll1() {
		// given
		int numberOfPinsDown = 1;
		// when
		for (int i = 0; i < 20; i++) {
			scoreCalculator.roll(numberOfPinsDown);
		}
		// then
		assertEquals(20, scoreCalculator.score());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingNegativeNumberOfPins() {
		// given
		int numberOfPinsDown = -1;
		// when
		for (int i = 0; i < 20; i++) {
			scoreCalculator.roll(numberOfPinsDown);
		}
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingMoreThan10Pins() {
		// given
		int numberOfPinsDown = 11;
		// when
		for (int i = 0; i < 20; i++) {
			scoreCalculator.roll(numberOfPinsDown);
		}
	}
}
