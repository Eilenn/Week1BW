package com.capgemini.gameoflife;

public interface GameOfLifeInterface {
	Cell nextGeneration();
	int countAliveNeighbours();
}
