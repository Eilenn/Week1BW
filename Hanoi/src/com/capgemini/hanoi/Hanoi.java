package com.capgemini.hanoi;
import java.util.Scanner;
import java.util.ArrayList;

public class Hanoi {
	public Hanoi() {

	}
	public static Stack originTower;
	public static ArrayList<Integer> listOfRings=new ArrayList<>();
	//public ArrayList<Ring> listOfRings = new ArrayList<>();

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
	
	//dodawanie krazkow na pierwsza wieze
	public static void createOriginTower(ArrayList<Integer> listOfRings){
		originTower=new Stack(listOfRings.size());
		for (int i = 0; i < listOfRings.size(); i++) {
			originTower.push(listOfRings.get(i).intValue());
		}
	}
	
	public void moveRing(int numberOfRings, int originTower, int helperTower, int endTower){
		if(numberOfRings==1){
			//moveRing();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Hanoi hanoi = new Hanoi();
		//hanoi.showListOfRings(hanoi.createRings(3));
		System.out.println("How many rings do you want to put on first tower?");
		int numberOfRings, whichRing, origin, target;
		// TODO delimiter na niecyfry
		Scanner sc=new Scanner(System.in);
		numberOfRings=sc.nextInt();
		//showListOfRings(createRings(numberOfRings));
		createOriginTower(createRings(numberOfRings));
		originTower.display();
		/*System.out.println("Specify which ring you want to move, from which peg and to where.\n Separate numbers with whitespaces");
		whichRing=sc.nextInt();
		origin=sc.nextInt();
		target=sc.nextInt();
		System.out.println("Ring "+whichRing+" from tower "+origin+" to tower "+target);*/
		sc.close();
	}
}
