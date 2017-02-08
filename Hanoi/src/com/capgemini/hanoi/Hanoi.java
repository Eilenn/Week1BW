package com.capgemini.hanoi;

import java.util.ArrayList;

public class Hanoi {
	public Hanoi() {

	}

	public ArrayList<Krazek> listaKrazkow = new ArrayList<>();

	public ArrayList<Krazek> stworzKrazki(int iloscKrazkow) {
		for (int i = 1; i <= iloscKrazkow; i++) {
			listaKrazkow.add(new Krazek(i, i, 1));
		}
		return listaKrazkow;
	}
	public void wyswietlListeKrazkow(ArrayList<Krazek> listaKrazkow){
		for (Krazek k : listaKrazkow) {
			System.out.println(k);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.wyswietlListeKrazkow(hanoi.stworzKrazki(20));
	}
}
