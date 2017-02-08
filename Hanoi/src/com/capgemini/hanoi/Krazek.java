package com.capgemini.hanoi;

public class Krazek {
	private int numerID;

	public int getNumerID() {
		return numerID;
	}

	public void setNumerID(int numerID) {
		this.numerID = numerID;
	}

	private int srednica;
	public int getSrednica() {
		return srednica;
	}

	public void setSrednica(int srednica) {
		this.srednica = srednica;
	}

	public int getObecnaWieza() {
		return obecnaWieza;
	}

	public void setObecnaWieza(int obecnaWieza) {
		this.obecnaWieza = obecnaWieza;
	}

	private int obecnaWieza;

	public Krazek(int numerID, int srednica, int obecnaWieza) {
		this.numerID = numerID;
		this.srednica = srednica;
		this.obecnaWieza = obecnaWieza;
	}
	public String toString(){
		return "Numer krazka: "+numerID+", srednica: "+srednica+", numer obecnej wiezy: "+obecnaWieza;
	}
}