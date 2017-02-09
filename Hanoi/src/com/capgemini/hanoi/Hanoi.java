package com.capgemini.hanoi;
import java.util.Scanner;
import java.util.ArrayList;

public class Hanoi {
	public Hanoi() {

	}

	public ArrayList<Ring> listOfRings = new ArrayList<>();

	// creating list of rings - first is the biggest one, then in descending order
	public ArrayList<Ring> createRings(int numberOfRings) {
		for (int i = numberOfRings; i >=1; i--) {
			listOfRings.add(new Ring(i, 1));
		}
		return listOfRings;
	}
	public void showListOfRings(ArrayList<Ring> listaKrazkow){
		for (Ring k : listaKrazkow) {
			System.out.println(k);
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
		Hanoi hanoi = new Hanoi();
		//hanoi.showListOfRings(hanoi.createRings(3));
		System.out.println("How many rings do you want to put on first tower?");
		int numberOfRings, whichRing, origin, target;
		// TODO delimiter na niecyfry
		Scanner sc=new Scanner(System.in);
		numberOfRings=sc.nextInt();
		hanoi.showListOfRings(hanoi.createRings(numberOfRings));
		System.out.println("Specify which ring you want to move, from which peg and to where.\n Separate numbers with whitespaces");
		whichRing=sc.nextInt();
		origin=sc.nextInt();
		target=sc.nextInt();
		System.out.println("Ring "+whichRing+" from tower "+origin+" to tower "+target);
		sc.close();
	}
}
