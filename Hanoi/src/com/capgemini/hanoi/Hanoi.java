package com.capgemini.hanoi;
import java.util.Scanner;
import java.util.ArrayList;

public class Hanoi {
	public Hanoi() {

	}
	public static Stack originTower;
	public static Stack helperTower;
	public static Stack targetTower;
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
		helperTower=new Stack(listOfRings.size());
		targetTower=new Stack(listOfRings.size());
		originTower=new Stack(listOfRings.size());
		for (int i = 0; i < listOfRings.size(); i++) {
			originTower.push(listOfRings.get(i).intValue());
		}
	}
	
	public void moveRing(Stack origin, Stack target){
		if(origin.isEmpty()){
			System.out.println("First tower is empty!");
			//TODO ponowne wywolanie metody z prosba o inne dane
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
			System.out.println("This operation is not allowed!");
			}
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
		//showListOfRings(createRings(numberOfRings));
		createOriginTower(createRings(numberOfRings));
		originTower.display();
		System.out.println("\n");
		targetTower.display();
		hanoi.moveRing(originTower, targetTower);
		/*System.out.println("Specify which ring you want to move, from which peg and to where.\n Separate numbers with whitespaces");
		whichRing=sc.nextInt();
		origin=sc.nextInt();
		target=sc.nextInt();
		System.out.println("Ring "+whichRing+" from tower "+origin+" to tower "+target);*/
		sc.close();
	}
}
