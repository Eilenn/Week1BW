package com.capgemini.gameoflife;

public class Cell {
	private int columnIndex;
	private int rowIndex;
	private CellState cellState;

	public Cell(CellState cellState) {
		this.cellState = cellState;
	}

	public Cell(int rowIndex, int columnIndex) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	public Cell(int rowIndex, int columnIndex, CellState cellState) {
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
		this.cellState = cellState;
	}

	public Cell() {
	}

	public boolean isAlive() {

		return cellState == CellState.ALIVE;
	}

	public boolean shouldLiveInTheNextGeneration(int aliveNeighbours){
		if(isAlive()&&(aliveNeighbours==2||aliveNeighbours==3)){
			return true;
		}
		else if(!isAlive()&&aliveNeighbours==3){
			return true;
		}
		return false;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

}
