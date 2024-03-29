package bagklient;

import adt.BagADT;
import kjedettabell.TabellBag;

public class KlientTabellBag {
	
		static Person personer[] = { new Person("Berit", 4), new Person("Kamil", 2), new Person("Eirik", 1),
				new Person("Alina", 3), new Person("Marius", 5) };

		public static void main(String[] args) {

	// Noe enkel og mangelfull testing

			BagADT<Person> bag = new TabellBag<>(5);
			// Legger til personer
			for (int i = 0; i < personer.length; i++) {
				bag.leggTil(personer[i]);
			}
			// Skriver ut samlingen
			((TabellBag<Person>) bag).skriv();

	// Fjerner personen i posisjon i = 2 fra samlingen som fins
			Person resultat = null;
			Person person = personer[2];
			if (!bag.erTom()) {
				resultat = bag.fjern(person);
			}
			if (resultat != null) {
				System.out.println("\nPersonen " + person + " ble fjernet");
			} else {
				System.out.println("\nPersonenen " + person + " er ikke i samlingen");
			}

	//B�r ogs� teste n�r personen ikke fins i samlingen

	// Test p� inneholder
			person = new Person("Berit", 4);
			if (bag.innehodler(person)) {
				System.out.println("\nSamlingen inneholder " + person);
			} else {
				System.out.println("\nSamlingen inneholder ikke " + person);
			}
	// B�r ogs� teste p� en person som ikke er med i samlingen

			// Alt1: Skriver ut en full tabell (mangler en person som er fjernet)
			System.out.println("\nAlternativ1\n");
			((TabellBag<Person>) bag).skrivnyBag();

			System.out.println("\nAlternativ2\n");

			Object[] Personer = (Object[]) bag.tilTabell();
			// Utskrift
			for (Object pers : Personer) {
				System.out.println(pers);
			}

			// Nullstiller bag'en
			bag.nullstill();
			if (bag.erTom()) {
				System.out.println("\nBagen er nullstilt");
			} else {
				System.out.println("\nNullstilling feiler");

			}
		}// main

}
