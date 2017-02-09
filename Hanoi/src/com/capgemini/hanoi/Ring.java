package com.capgemini.hanoi;

public class Ring {
	private int numberID;

	public int getNumerID() {
		return numberID;
	}

	public void setNumerID(int numerID) {
		this.numberID = numerID;
	}

	public int getObecnaWieza() {
		return currentTower;
	}

	public void setObecnaWieza(int obecnaWieza) {
		this.currentTower = obecnaWieza;
	}

	private int currentTower;

	public Ring(int numerID, int obecnaWieza) {
		this.numberID = numerID;
		this.currentTower = obecnaWieza;
	}
	public String toString(){
		return "Ring's number: "+numberID+", current tower's number: "+currentTower;
	}
}