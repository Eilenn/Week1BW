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
		rollManyTimes(numberOfPinsDown, 20);
		// then
		assertEquals(0, scoreCalculator.score());
	}

	@Test
	public void canRollAll1() {
		// given
		int numberOfPinsDown = 1;
		// when
		rollManyTimes(numberOfPinsDown, 20);
		// then
		assertEquals(20, scoreCalculator.score());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingNegativeNumberOfPins() {
		// given
		int numberOfPinsDown = -1;
		// when
			scoreCalculator.roll(numberOfPinsDown);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingMoreThan10Pins() {
		// given
		int numberOfPinsDown = 11;
		// when
		scoreCalculator.roll(numberOfPinsDown);
	}

	@Test
	public void shouldAddThrowsToList() {
		// given
		int numberOfPinsDown = 1;
		// when
		rollManyTimes(numberOfPinsDown, 20);
		// then
		// assertTrue(scoreCalculator.getTurns().size()==20);
		assertTrue(((BowlingGame) scoreCalculator).getTurns().contains(1));
	}
	
	@Test
	public void canRollSpare(){
		// given
		scoreCalculator.roll(2);
		scoreCalculator.roll(8);
		scoreCalculator.roll(5);
		rollManyTimes(1, 17);
		// when
		int score=scoreCalculator.score();
		// then
		assertEquals(37, score);
		}

	private void rollManyTimes(int numberOfPinsDown, int numberOfRolls) {
		for (int i = 0; i < numberOfRolls; i++) {
			scoreCalculator.roll(numberOfPinsDown);
		}
	}
}
