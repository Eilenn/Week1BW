package com.capgemini.hanoi;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Hanoi {

	public static Stack originTower;
	public static Stack intermediateTower;
	public static Stack targetTower;
	public static ArrayList<Integer> listOfRings=new ArrayList<>();
	private static Set<Integer> indexesOfTowers=new HashSet<Integer>();
	

	// creating list of rings - first is the biggest one, then in descending order
	public static ArrayList<Integer> createRings(int numberOfRings) {
		
		for (int i = numberOfRings; i >=1; i--) {
			listOfRings.add(i);
		}
		return listOfRings;
	}
	public static void showListOfRings(ArrayList<Integer> listOfRings){
		for (Integer k : listOfRings) {
			System.out.println(k);
		}
	}
	
	//adding rings to first tower and creating other towers
	public static void createTowers(ArrayList<Integer> listOfRings){
		intermediateTower=new Stack(listOfRings.size());
		targetTower=new Stack(listOfRings.size());
		originTower=new Stack(listOfRings.size());
		for (int i = 0; i < listOfRings.size(); i++) {
			originTower.push(listOfRings.get(i).intValue());
		}
	}
	
	
	public static void moveRing(Stack origin, Stack target){
		if(origin.isEmpty()){
			System.out.println("The tower is empty! "
					+ "\n Choose another move.");
		}
		else{
			if(target.isEmpty()||origin.peek()<target.peek()){
				//System.out.println(origin.peek()); //podglad wierzcholka pierwotnej
				int temp=origin.pop();
				//System.out.println(origin.peek()); //podglad wierzcholka pierwotnej po zdjeciu elementu
				target.push(temp);
				//System.out.println(target.peek());
			}
			else{
				System.out.println("You cannot put a bigger ring on a smaller one! \nChoose another move.");
			}

		}
		
	}
	
	public static void setBoard(){
		//Hanoi hanoi = new Hanoi();
		indexesOfTowers.add(1);
		indexesOfTowers.add(2);
		indexesOfTowers.add(3);
		int numberOfRings;
		System.out.println("Welcome to Hanoi Towers game, you have three empty towers numbered 1, 2 and 3.");
		System.out.println("How many rings do you want to put on the tower number 1?");
		Scanner sc=new Scanner(System.in);
		numberOfRings=sc.nextInt();
		createTowers(createRings(numberOfRings));
		System.out.println("Tower 1 looks like this:");
		originTower.displayVertical();
		Hanoi.commandToMove();
		System.out.println("Game is finished, tower 3 is full and looks like this:");
		targetTower.displayVertical();
		sc.close();
	}
	
	public static void commandToMove(){
		Scanner sc=new Scanner(System.in);
		while(targetTower.getSize()<targetTower.getMaximumStackSize()-1)
		{
			//System.out.println(targetTower.getSize());
		System.out.println("Specify which tower (first number) you want to move the top ring from "
				+ "and where to move it (second number).\n Separate towers' numbers with whitespaces and press Enter. "
				+ "Example: 1 3\n");
		
		int originTowerNumber, targetTowerNumber;
		originTowerNumber=sc.nextInt();
		targetTowerNumber=sc.nextInt();
		Stack[] allTowers={originTower, intermediateTower, targetTower};
		//System.out.println(allTowers.length);
		if(indexesOfTowers.contains(originTowerNumber)&&indexesOfTowers.contains(targetTowerNumber)){
			Hanoi.moveRing(allTowers[originTowerNumber-1], allTowers[targetTowerNumber-1]);
		}
		else{
			System.out.println("One or both of tower numbers are invalid!\nTower are numbered 1, 2 and 3.\n"
					+ "Choose another combination.");
		}
		
		
		}
		sc.close();
		}
		
		
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Hanoi hanoi = new Hanoi();
		Hanoi.setBoard();

	}
}
