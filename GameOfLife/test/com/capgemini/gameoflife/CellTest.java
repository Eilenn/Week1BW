package com.capgemini.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

	private static final CellState DEAD = CellState.DEAD;
	private static final CellState ALIVE = CellState.ALIVE;
	private Cell cell;

	@Test
	public void shouldReturnCorrectRowIndexForExistingCell() {
		// given
		int rowIndex = 1;
		int columnIndex = 1;
		cell = new Cell(rowIndex, columnIndex);
		// when
		int actualRowIndex = cell.getRowIndex();
		// then
		assertEquals(rowIndex, actualRowIndex);
	}

	@Test
	public void shouldReturnCorrectColumnIndexForExistingCell() {
		// given
		int rowIndex = 1;
		int columnIndex = 1;
		cell = new Cell(rowIndex, columnIndex);
		// when
		int actualColumnIndex = cell.getColumnIndex();
		// then
		assertEquals(rowIndex, actualColumnIndex);
	}

	@Test
	public void shouldReturnAliveWhenCellIsAlive() {
		// given
		cell = new Cell();
		cell.setCellState(ALIVE);
		// when
		CellState actualCellState = cell.getCellState();
		// then
		assertEquals(ALIVE, actualCellState);
	}

	@Test
	public void shouldReturnDeadWhenCellIsDead() {
		// given
		cell = new Cell();
		cell.setCellState(DEAD);
		// when
		CellState actualCellState = cell.getCellState();
		// then
		assertEquals(DEAD, actualCellState);
	}

	@Test
	public void shouldReturnTrueForAliveCell() {
		// given
		cell = new Cell(ALIVE);
		// when
		boolean isCellAlive = cell.isAlive();
		// then
		assertEquals(true, isCellAlive);
	}

	@Test
	public void shouldReturnFalseForDeadCell() {
		// given
		cell = new Cell(DEAD);
		// when
		boolean isCellAlive = cell.isAlive();
		// then
		assertEquals(false, isCellAlive);
	}

}
