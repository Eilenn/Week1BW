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
		((BowlingGame) scoreCalculator).rollManyTimes(numberOfPinsDown, 20);
		// then
		assertEquals(0, scoreCalculator.score());
	}

	@Test
	public void canRollAll1() {
		// given
		int numberOfPinsDown = 1;
		// when
		((BowlingGame) scoreCalculator).rollManyTimes(numberOfPinsDown, 20);
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
	public void canRollSpareThenStandardRolls() {
		// given
		scoreCalculator.roll(2);
		scoreCalculator.roll(8);
		scoreCalculator.roll(5);
		((BowlingGame) scoreCalculator).rollManyTimes(1, 17);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(37, score);
	}

	@Test
	public void canRollStandardRollsThenASpare() {
		// given
		((BowlingGame) scoreCalculator).rollManyTimes(1, 16);
		scoreCalculator.roll(2);
		scoreCalculator.roll(8);
		scoreCalculator.roll(5);
		scoreCalculator.roll(3);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(39, score);
	}

	@Test
	public void canRollStrikeFirst() {
		// given
		scoreCalculator.roll(10);
		scoreCalculator.roll(1);
		scoreCalculator.roll(1);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(14, score);
	}

	@Test
	public void canRollStandardRollsThenStrike() {
		// given
		((BowlingGame) scoreCalculator).rollManyTimes(1, 2);
		((BowlingGame) scoreCalculator).rollStrike(1);
		((BowlingGame) scoreCalculator).rollManyTimes(1, 16);
		int score = scoreCalculator.score();
		// then
		assertEquals(30, score);
	}

	@Test
	public void canRollStrikeStandardSpareStandard() {
		// given
		((BowlingGame) scoreCalculator).rollStrike(1);
		((BowlingGame) scoreCalculator).rollManyTimes(1, 2);
		((BowlingGame) scoreCalculator).rollSpare(1);
		((BowlingGame) scoreCalculator).rollManyTimes(1, 14);
		int score = scoreCalculator.score();
		// then
		assertEquals(39, score);
	}

	@Test
	public void canRollPerfectGame() {
		// given
		((BowlingGame) scoreCalculator).rollStrike(12);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(300, score);
	}

	@Test
	public void canRollStrikeIn10thFrame() {
		// given
		((BowlingGame) scoreCalculator).rollManyTimes(1, 18);
		((BowlingGame) scoreCalculator).rollStrike(1);
		((BowlingGame) scoreCalculator).rollManyTimes(1, 2);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(30, score);
	}

	@Test
	public void canRollSpareIn10thFrame() {
		// given
		((BowlingGame) scoreCalculator).rollManyTimes(1, 18);
		((BowlingGame) scoreCalculator).rollSpare(1);
		scoreCalculator.roll(1);
		// when
		int score = scoreCalculator.score();
		// then
		assertEquals(29, score);
	}

}
