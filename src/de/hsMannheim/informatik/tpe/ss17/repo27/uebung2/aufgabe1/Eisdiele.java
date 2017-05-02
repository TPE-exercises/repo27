package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eisdiele {

	static double preis;
	static Eis eis = new Eis();

	Eisdiele() {

	}

	public static void bestellen(String typ) {
		// Eis eis = new Eis();
		begruessen();

		if (typ.equals("Spaghettieis")) {
			eis.setName("Spaghettieis");
			eis.setPreis(5.50);
			eis.setBehaeltnis("Teller");
			eis.setArt("Spaghettis");
			String[] sorten = { "Vanille" };
			eis.setSorten(sorten);
			String[] extras = { "Sahne", "Erdbeersoße", "weiße Schokolade Raspeln" };
			eis.setExtras(extras);
		}

		if (typ.equals("Bananasplit")) {
			eis.setName("Bananasplit");
			eis.setPreis(6.70);
			eis.setBehaeltnis("ovaler Teller");
			eis.setArt("Bananasplit");
			String[] sorten = { "Vanille", "Banane" };
			eis.setSorten(sorten);
			String[] extras = { "Bananen", "Sahne", "Schokosoße", "Kekse" };
			eis.setExtras(extras);
		}

		if (typ.equals("Nussbecher")) {
			eis.setName("Nussbecher");
			eis.setPreis(6.00);
			eis.setBehaeltnis("höhes Glas");
			eis.setArt("Nussbecher");
			String[] sorten = { "Vanille", "Schoko", "Nuss" };
			eis.setSorten(sorten);
			String[] extras = { "Nüsse", "Sahne", "Schoko-/Karamelsoße", "Kekse" };
			eis.setExtras(extras);
		}

		eis.vorbereiten();
		eis.fuellen();
		eis.dekorieren();
		kassieren();

	}

	static void begruessen() {
		println("Hallo und Herzlich Willkommen zu unserer Eisdiele!");
		println("Ihr Eis kommt sofort!");
	}

	static void kassieren() {
		preis = eis.getPreis();
		println("Das macht dann " + preis + "€");
		println("Bitte geben Sie jetzt Ihre Summe ein!");
		double eingabe = 0.0;
		while (eingabe != preis) {
			double geld = readFloat();
			eingabe = eingabe + geld;
			double restgeld = eingabe - preis;
			if (restgeld < 0) {
				println("Es fehlen noch " + (restgeld * (-1)) + "€");

			} else {
				println("Sie bekommen noch " + restgeld + "€ zurück!");
				verabschieden();
			}
		}
	}

	static void verabschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	static void entschuldigen() {
		println("Entschulden Sie, aber die von Ihnen ausgewählte Sorte haben wir leider nicht zur verfügung!");

	}

}
