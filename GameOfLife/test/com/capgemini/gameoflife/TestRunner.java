package com.capgemini.gameoflife;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.capgemini.gameoflife.*;

public class TestRunner {
	public static void main(String[] args) {
		Result resultCell = JUnitCore.runClasses(CellTest.class, BoardTest.class, GameOfLifeTest.class);

		for (Failure failure : resultCell.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(resultCell.wasSuccessful());
	}
}
