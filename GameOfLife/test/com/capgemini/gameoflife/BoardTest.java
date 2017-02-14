package com.capgemini.gameoflife;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class BoardTest {
	private static final CellState ALIVE = CellState.ALIVE;
	private static final CellState DEAD = CellState.DEAD;
	private Board board;

	@Test
	@Ignore // another method does the same - for dead board
	public void shouldReturnCorrectNumberOfColumnsForCreatedBoard() {
		// given
		int numberOfColumns = 10;
		int numberOfRows = 11;
		board = new Board(numberOfRows, numberOfColumns);
		// when
		int actualNumberOfColumns = board.getNumberOfColumns();
		// then
		assertEquals(numberOfColumns, actualNumberOfColumns);
	}

	@Test
	@Ignore // another method does the same one step further - for dead board
	public void shouldReturnCorrectNumberOfRowsForCreatedBoard() {
		// given
		int numberOfColumns = 10;
		int numberOfRows = 11;
		board = new Board(numberOfRows, numberOfColumns);
		// when
		int actualNumberOfRows = board.getNumberOfRows();
		// then
		assertEquals(numberOfRows, actualNumberOfRows);
	}

	@Test
	public void shouldReturnCorrectNumberOfRowsForInitialBoard() {
		// given
		int numberOfColumns = 10;
		int numberOfRows = 11;
		board = new Board(numberOfRows, numberOfColumns);
		board.createBoard();
		Cell[][] boardOfCells = board.getBoardOfCells();
		// when
		int actualNumberOfRows = boardOfCells.length;
		// then
		assertEquals(numberOfRows, actualNumberOfRows);
	}

	@Test
	public void shouldReturnCorrectNumberOfColumnsForInitialBoard() {
		// given
		int numberOfColumns = 10;
		int numberOfRows = 11;
		board = new Board(numberOfRows, numberOfColumns);
		board.createBoard();
		Cell[][] boardOfCells = board.getBoardOfCells();
		// when
		int actualNumberOfColumns = boardOfCells[0].length;
		// then
		assertEquals(numberOfColumns, actualNumberOfColumns);
	}

	@Test
	public void shouldReturnDeadForAnyCellOfTheInitialBoard() {
		// given
		board = new Board(1, 1);
		board.createBoard();
		// when
		CellState actualState = board.getBoardOfCells()[0][0].getCellState();
		// then
		assertEquals(DEAD, actualState);
	}
	
	@Test
	public void shouldReturnAliveForAliveCellInInitializedBoard(){
		// given
		board = new Board(5, 5);
		board.createBoard();
		Cell[][] initialBoard=board.getBoardOfCells();
		board.setCellStateToAlive(0,0, initialBoard);
		// when
		board.createBoardInitializedToPlay(initialBoard);
		CellState actualState=board.getBoardOfCells()[0][0].getCellState();
		// then
		assertEquals(ALIVE,actualState);
	}
	
	@Test
	public void shouldReturnDeadForDeadCellInInitializedBoard(){
		// given
		board = new Board(5, 5);
		board.createBoard();
		Cell[][] initialBoard=board.getBoardOfCells();
		board.setCellStateToAlive(0,0, initialBoard);
		// when
		board.createBoardInitializedToPlay(initialBoard);
		CellState actualState=board.getBoardOfCells()[0][1].getCellState();
		// then
		assertEquals(DEAD,actualState);
	}
	


}
