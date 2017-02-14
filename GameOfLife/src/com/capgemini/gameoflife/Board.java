package com.capgemini.gameoflife;

public class Board {
	private static final CellState ALIVE = CellState.ALIVE;
	private static final CellState DEAD = CellState.DEAD;
	private int numberOfColumns;
	private int numberOfRows;

	public Cell[][] getBoardOfCells() {
		return boardOfCells;
	}

	public void setBoardOfCells(Cell[][] boardOfCells) {
		this.boardOfCells = boardOfCells;
	}

	private Cell[][] boardOfCells;

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public Board(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
		boardOfCells = new Cell[numberOfRows][numberOfColumns];

	}

	public void createBoard() {
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				boardOfCells[i][j] = new Cell(i, j, DEAD);
			}
		}
	}

	public void createBoardInitializedToPlay(Cell[][] initialBoard) {
		int numberOfRows = initialBoard.length;
		int numberOfColumns = initialBoard[0].length;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (initialBoard[i][j].isAlive()) {
					boardOfCells[i][j] = new Cell(i, j, ALIVE);
				} else {
					boardOfCells[i][j] = new Cell(i, j, DEAD);
				}
			}
		}
	}
	public void setCellStateToAlive(int rowIndex, int columnIndex, Cell[][] board){
		board[rowIndex][columnIndex].setCellState(ALIVE);
	}
	
	public void setCellStateToDead(int rowIndex, int columnIndex, Cell[][] board){
		board[rowIndex][columnIndex].setCellState(DEAD);
	}

}
