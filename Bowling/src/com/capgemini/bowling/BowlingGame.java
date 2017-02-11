package com.capgemini.bowling;

public class BowlingGame implements BowlingGameResultCalculator{
	final int NUMBER_OF_FRAMES=10;
	final int NUMBER_OF_THROWS_PER_FRAME=2;
	private int [][] knockedPinsInAGame=new int[NUMBER_OF_FRAMES][NUMBER_OF_THROWS_PER_FRAME];
	private int score=0;
	
	
	@Override
	public void roll(int numberOfPins) {
		// TODO Auto-generated method stub
		if(numberOfPins<0){
			throw new IllegalArgumentException("You cannot knock down negative number of pins");
		}
		else if(numberOfPins>10){
			throw new IllegalArgumentException("You cannot knock down more than 10 pins!");
		}
		score+=numberOfPins;

		
	}

	@Override
	public int score() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
