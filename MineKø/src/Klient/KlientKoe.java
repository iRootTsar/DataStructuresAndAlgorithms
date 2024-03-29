package Klient;

import Exception.EmptyCollectionException;
import KoeADT.KoeADT;
import SirkulaerTabellKoe.SirkulaerTabellKoe;

public class KlientKoe {

	public static void main(String[] args) {
		KoeADT<Character> tegnKoe = new SirkulaerTabellKoe<>();
		//KoeADT<Character> tegnKoe = new KjedetKoe<>();
		//Bytte ut med KjedetKoe og med SirkulaerKoe
		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();
		for (int i = 0; i < lengde; i++) {
			tegnKoe.innKoe(streng.charAt(i));
		}
		System.out.println(tegnKoe); // kall p� toString()
		try {
			while (!tegnKoe.erTom()) {
				char tegn = tegnKoe.utKoe();
				System.out.print(tegn);
			}
		} catch (EmptyCollectionException e) {
			System.out.print(e.getMessage());

		}
	}
}
		
