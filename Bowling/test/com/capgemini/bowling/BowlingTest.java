package com.capgemini.bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingTest {
	private BowlingGame bowlingGame;

	@Before
	public void setUp() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void shouldReturn0WhenRollingAll0() {
		// given
		int numberOfPinsDown = 0;
		// when
		rollManyTimes(numberOfPinsDown, 20);
		// then
		assertEquals(0, bowlingGame.score());
	}

	@Test
	public void shouldReturn20WhenRollingAll1() {
		// given
		int numberOfPinsDown = 1;
		// when
		rollManyTimes(numberOfPinsDown, 20);
		// then
		assertEquals(20, bowlingGame.score());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingNegativeNumberOfPins() {
		// given
		int numberOfPinsDown = -1;
		// when
		bowlingGame.roll(numberOfPinsDown);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenKnockingMoreThan10Pins() {
		// given
		int numberOfPinsDown = 11;
		// when
		bowlingGame.roll(numberOfPinsDown);
	}

	@Test
	public void shouldScore37WhenRollingSpareThen5ThenStandardRollsOf1() {
		// given
		bowlingGame.roll(2);
		bowlingGame.roll(8);
		bowlingGame.roll(5);
		rollManyTimes(1, 17);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(37, score);
	}

	@Test
	public void shouldScore39WhenRollingOnesThenThenASpareThen5And3() {
		// given
		rollManyTimes(1, 16);
		rollSpare(1);
		bowlingGame.roll(5);
		bowlingGame.roll(3);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(39, score);
	}

	@Test
	public void shouldScore14WhenRollingStrikeThenOneThenOne() {
		// given
		rollStrike(1);;
		bowlingGame.roll(1);
		bowlingGame.roll(1);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(14, score);
	}

	@Test
	public void shouldScore30WhenRollingOneOneStrikeOne16Times() {
		// given
		rollManyTimes(1, 2);
		rollStrike(1);
		rollManyTimes(1, 16);
		int score = bowlingGame.score();
		// then
		assertEquals(30, score);
	}

	@Test
	public void shouldScore39WhenRollingStrikeOneOneSpareOne14Times() {
		// given
		rollStrike(1);
		rollManyTimes(1, 2);
		rollSpare(1);
		rollManyTimes(1, 14);
		int score = bowlingGame.score();
		// then
		assertEquals(39, score);
	}

	@Test
	public void shouldScore300ForPerfectGame() {
		// given
		rollStrike(12);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(300, score);
	}

	@Test
	public void shouldScore30ForAllOnesStrikeIn10thFrameOneOne() {
		// given
		rollManyTimes(1, 18);
		rollStrike(1);
		rollManyTimes(1, 2);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(30, score);
	}

	@Test
	public void shouldScore29WhenRollingOne18TimesSpareIn10thFrameOne() {
		// given
		rollManyTimes(1, 18);
		rollSpare(1);
		bowlingGame.roll(1);
		// when
		int score = bowlingGame.score();
		// then
		assertEquals(29, score);
	}

	@Test
	public void shouldReturnTrueFor20Rolls() {
		// given
		int numberOfPinsDown = 1;
		rollManyTimes(numberOfPinsDown, 20);
		bowlingGame.score();
		// when
		boolean isGameFinished = bowlingGame.isFinished();
		// then
		assertTrue(isGameFinished);
	}

	@Test
	public void shouldReturnTrueFor21Rolls() {
		// given
		rollManyTimes(1, 18);
		rollSpare(1);
		bowlingGame.roll(1);
		bowlingGame.score();
		// when
		boolean isGameFinished = bowlingGame.isFinished();
		// then
		assertTrue(isGameFinished);
	}

	@Test
	public void shouldReturnTrueFor22Rolls() {
		// given
		rollManyTimes(1, 18);
		rollStrike(1);
		rollManyTimes(1, 2);
		bowlingGame.score();
		// when
		boolean isGameFinished = bowlingGame.isFinished();
		// then
		assertTrue(isGameFinished);
	}

	@Test
	public void shouldReturnFalseFor19Rolls() {
		// given
		int numberOfRolls = 19;
		rollManyTimes(1, numberOfRolls);
		// when
		boolean isGameFinished = bowlingGame.isFinished();
		// then
		assertFalse(isGameFinished);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionFor23Rolls() {
		// given
		int numberOfRolls = 23;
		// when
		rollManyTimes(1, numberOfRolls);

	}

	private void rollManyTimes(int numberOfPinsDown, int numberOfRolls) {
		if (numberOfRolls > bowlingGame.MAXIMAL_NUMBER_OF_ROLLS) {
			throw new IllegalArgumentException("You cannot roll more than 22 times");
		}
		for (int i = 0; i < numberOfRolls; i++) {
			bowlingGame.roll(numberOfPinsDown);
		}
	}

	private void rollStrike(int numberOfRolls) {
		for (int i = 0; i < numberOfRolls; i++) {
			bowlingGame.roll(bowlingGame.PINS_DOWN_IN_A_STRIKE);
		}
	}

	private void rollSpare(int numberOfRolls) {
		for (int i = 0; i < numberOfRolls; i++) {
			rollManyTimes(5, 2);
		}
	}
}
