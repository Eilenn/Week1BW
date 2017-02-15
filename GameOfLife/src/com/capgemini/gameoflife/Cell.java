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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellState == null) ? 0 : cellState.hashCode());
		result = prime * result + columnIndex;
		result = prime * result + rowIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (cellState != other.cellState)
			return false;
		if (columnIndex != other.columnIndex)
			return false;
		if (rowIndex != other.rowIndex)
			return false;
		return true;
	}

	public boolean isAlive() {

		return cellState == CellState.ALIVE;
	}

	public boolean shouldLiveInTheNextGeneration(int aliveNeighbours) {
		if (isAlive() && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
			return true;
		} else if (!isAlive() && aliveNeighbours == 3) {
			return true;
		} else {
			return false;
		}
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
