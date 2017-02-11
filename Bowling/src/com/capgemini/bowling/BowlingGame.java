package com.capgemini.bowling;

import java.util.ArrayList;

public class BowlingGame implements BowlingGameResultCalculator {
	final int NUMBER_OF_FRAMES = 10;
	final int NUMBER_OF_ROLLS_PER_FRAME = 2;
	final int MAXIMAL_NUMBER_OF_ROLLS = 22;
	private int[] listOfRolls = new int[MAXIMAL_NUMBER_OF_ROLLS - 1];
	private int currentRoll = 0;
	private int currentTurn = 1;
	private ArrayList<Integer> turns = new ArrayList<>();

	@Override
	public void roll(int numberOfPins) {
		if (numberOfPins < 0) {
			throw new IllegalArgumentException("You cannot knock down negative number of pins");
		} else if (numberOfPins > 10) {
			throw new IllegalArgumentException("You cannot knock down more than 10 pins!");
		} else {
			listOfRolls[currentRoll] = numberOfPins;
			currentRoll++;
			turns.add(numberOfPins);
			//score += numberOfPins;
		}

	}

	@Override
	public int score() {
		int score=0;
		int whichRoll=0;
		for(int frames=0;frames<NUMBER_OF_FRAMES;frames++){
		if(listOfRolls[whichRoll]+listOfRolls[whichRoll+1]==10){
			score=score+listOfRolls[whichRoll]+listOfRolls[whichRoll+1]+listOfRolls[whichRoll+2];
		}
		else{
			score=score+listOfRolls[whichRoll]+listOfRolls[whichRoll+1];
		}
		whichRoll=whichRoll+2;
		}
		return score;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Integer> getTurns() {
		return turns;
	}

}
