package com.capgemini.hanoi;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * makes playing Hanoi towers game possible. Creates the board and collects
 * commands of a user through a console.
 * 
 * @author BOWROBEL
 *
 */
public class Hanoi {
	protected static Stack originTower;
	protected static Stack intermediateTower;
	protected static Stack targetTower;
	protected ArrayList<Integer> listOfRings = new ArrayList<>();
	protected static Set<Integer> indexesOfTowers = new HashSet<Integer>();
	protected static ArrayList<Integer[]> listOfMoves = new ArrayList<>();

	/**
	 * creates the board and runs the game
	 */
	public static void setBoard() {
		Hanoi hanoi=new Hanoi();
		creatingIndexesForTowers();
		System.out.println("Welcome to Hanoi Towers game, you have three empty towers numbered 1, 2 and 3.");
		System.out.println("How many rings do you want to put on the tower number 1?");
		Scanner sc = new Scanner(System.in);
		int numberOfRings = sc.nextInt();
		hanoi.listOfRings = hanoi.createRings(numberOfRings);
		createTowers(hanoi.listOfRings);
		System.out.println("Tower 1 looks like this:");
		originTower.displayVertical();
		Hanoi.getCommandsForMovingRings();
		System.out.println("Congratulations! You finished the game.");
		printListOfMoves();
		sc.close();
	}

	protected static void creatingIndexesForTowers() {
		indexesOfTowers.add(1);
		indexesOfTowers.add(2);
		indexesOfTowers.add(3);
	}

	/**
	 * creates list of rings - first is the biggest one, then in descending
	 * order
	 * 
	 * @param numberOfRings
	 * @return ArrayList of integer values meaning rings diameter
	 */
	protected ArrayList<Integer> createRings(int numberOfRings) {
		if (numberOfRings <= 0) {
			throw new IllegalArgumentException("Number of rings must be positive, integer value!");
		}
		for (int i = numberOfRings; i >= 1; i--) {
			listOfRings.add(i);
		}
		return listOfRings;
	}

	/**
	 * puts rings on the first tower from the biggest to the smallest and
	 * creates the other two
	 * 
	 * @param listOfRings
	 */
	public static void createTowers(ArrayList<Integer> listOfRings) {
		intermediateTower = new Stack(listOfRings.size());
		targetTower = new Stack(listOfRings.size());
		originTower = new Stack(listOfRings.size());
		for (int i = 0; i < listOfRings.size(); i++) {
			originTower.push(listOfRings.get(i).intValue());
		}
	}

	/**
	 * collects commands for moving rings in form of tower numbers
	 */
	public static void getCommandsForMovingRings() {
		Scanner sc = new Scanner(System.in);
		while (targetTower.getSize() < targetTower.getMaximumStackSize() - 1) {
			int originTowerNumber, targetTowerNumber;
			System.out.println("Choose a tower to take a ring from: ");
			originTowerNumber = sc.nextInt();
			System.out.println("Choose a tower to put a ring on: ");
			targetTowerNumber = sc.nextInt();
			Stack[] allTowers = { originTower, intermediateTower, targetTower };
			moveRingIfTowerNumberIsValid(originTowerNumber, targetTowerNumber, allTowers);
		}
		sc.close();
	}

	/**
	 * validates tower numbers entered by player, if in range of 1-3, it
	 * attempts to move the ring, if not it prints a message to the user
	 * 
	 * @param originTowerNumber
	 * @param targetTowerNumber
	 * @param allTowers
	 */
	public static void moveRingIfTowerNumberIsValid(int originTowerNumber, int targetTowerNumber, Stack[] allTowers) {
		if (indexesOfTowers.contains(originTowerNumber) && indexesOfTowers.contains(targetTowerNumber)) {
			if (originTowerNumber != targetTowerNumber) {
				Integer[] moveFromTo = { originTowerNumber, targetTowerNumber };
				listOfMoves.add(moveFromTo);
				Hanoi.moveRing(allTowers[originTowerNumber - 1], allTowers[targetTowerNumber - 1]);
			} else {
				System.out.println("Tower numbers you entered are the same!.");
			}
		} else {
			System.out.println("One or both of tower numbers are invalid! Towers are numbered 1, 2 and 3.\n");
		}
	}

	/**
	 * moves a ring from origin tower to target tower if origin tower is not
	 * empty and the moved ring's size is smaller than ring's on top of the
	 * target tower
	 * 
	 * @param origin
	 * @param target
	 */
	public static void moveRing(Stack origin, Stack target) {
		if (origin.isEmpty()) {
			System.out.println("The tower is empty! " + "\n Choose another move.");
			throw new IllegalStateException("Tower is empty");
		} else {
			if (target.isEmpty() || origin.peek() < target.peek()) {
				int temp = origin.pop();
				target.push(temp);
			} else {
				System.out.println("You cannot put a bigger ring on a smaller one! \nChoose another move.");
			}

		}
	}

	/**
	 * prints a list of valid moves made by the player
	 */
	public static void printListOfMoves() {
		System.out.println("Here is the list of your moves:");
		for (int i = 0; i < listOfMoves.size(); i++) {
			System.out.println("From " + listOfMoves.get(i)[0] + " to " + listOfMoves.get(i)[1]);
		}
	}
}
