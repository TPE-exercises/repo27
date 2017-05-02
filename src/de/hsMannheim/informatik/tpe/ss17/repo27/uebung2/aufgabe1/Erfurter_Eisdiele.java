package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2.aufgabe1;
import static gdi.MakeItSimple.*;

public class Erfurter_Eisdiele extends Eisdiele{

	/**
	 * Ordering process for the Erfurter ice cream parlor
	 */

	@Override
	public Eis erstellen(String typ) {
		
		begruessen();
		
		Eis eis = new Eis();
		
		if(!( typ.equals("Spaghettieis") || typ.equals("Bananasplit") || typ.equals("Nussbecher")))
			entschuldigen();
		
		else{
		
		if (typ.equals("Spaghettieis")) {
			eis.setName("Spaghettieis");
			eis.setPreis(5.50);
			eis.setBehaeltnis("Teller");
			eis.setArt("Spaghettis");
			String[] sorten = { "Vanille" };
			eis.setSorten(sorten);
			String[] extras = { "Sahne", "Erdbeerso�e", "wei�e Schokolade Raspeln" };
			eis.setExtras(extras);
		}

		if (typ.equals("Bananasplit")) {
			eis.setName("Bananasplit");
			eis.setPreis(6.70);
			eis.setBehaeltnis("ovaler Teller");
			eis.setArt("Bananasplit");
			String[] sorten = { "Vanille", "Banane" };
			eis.setSorten(sorten);
			String[] extras = { "Bananen", "Sahne", "Schokoso�e", "Kekse" };
			eis.setExtras(extras);
		}

		if (typ.equals("Nussbecher")) {
			eis.setName("Nussbecher");
			eis.setPreis(6.00);
			eis.setBehaeltnis("h�hes Glas");
			eis.setArt("Nussbecher");
			String[] sorten = { "Vanille", "Schoko", "Nuss" };
			eis.setSorten(sorten);
			String[] extras = { "N�sse", "Krokant", "Sahne", "Schokoso�e","Eierlik�r", "Kekse" };
			eis.setExtras(extras);
		}

		eis.vorbereiten();
		eis.fuellen();
		eis.dekorieren();
		kassieren(eis.preis);
		
		}
		
		return eis;
	}

	@Override
	void begruessen() {
		println("th�ringisch: Hallo und Herzlich Willkommen zu unserer Eisdiele!");
		println("th�ringisch: Ihr Eis kommt sofort!");
		
	}

	@Override
	void kassieren(double preis) {
		
		println("th�ringisch: Das macht dann " + preis + "�");
		println("th�ringisch: Bitte geben Sie jetzt Ihre Summe ein!");
		double eingabe = 0.0;
		while (eingabe != preis) {
			double geld = readFloat();
			eingabe = eingabe + geld;
			double restgeld = eingabe - preis;
			if (restgeld < 0) {
				println("th�ringisch: Es fehlen noch " + (restgeld * (-1)) + "�");

			} else {
				println("th�ringisch: Sie bekommen noch " + restgeld + "� zur�ck!");
				verabschieden();
			}
		}
		
	}

	@Override
	void verabschieden() {
		println("th�ringisch: Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
		
	}
	/**
	 * Error message if something is wrong
	 */
	@Override
	void entschuldigen() {
		println("th�ringisch: Entschulden Sie, aber die von Ihnen ausgew�hlte Sorte haben wir leider nicht zur verf�gung!");
		
	}

}
