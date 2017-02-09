package com.capgemini.hanoi;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.showListOfRings(hanoi.createRings(3));
	}
}
