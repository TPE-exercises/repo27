package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.*;

public class Eisdiele extends Eis{
	static Eis eis = new Eis();
		
	Eisdiele(){
			
	}

	
	public static void bestellen(String typ){
		
		switch (typ) {
		case "Spaghettieis":
			eis.setPreis(4.99);
			break;
		case "Bananasplit":
			eis.setPreis(3.99);
			break;
		case "Nussbecher":
			eis.setPreis(2.99);
			break;
		default:
			entschuldigen();
			break;
		};
		
	}


	static void begruessen(){
		println("Hallo und Herzlich Willkommen zu unserer Eisdiele!");
		println("Wie möchten Sie ihr Eis gerne habe!");
	}
	
	static void kassieren(){
		double preis = eis.getPreis();
		println("Das macht dann " + preis+"€");
		println("Bitte geben Sie jetzt Ihre Summe ein!");
		double geld = readInt();
		double restgeld=geld-preis;
		if(restgeld<0){
			println("Es fehlen noch "+(restgeld*(-1))+"€");

		}
		else{
			println("Sie bekommen noch "+restgeld+"€");
			verabschieden();
		}
	}
	
	static void verabschieden(){
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}
	
	static void entschuldigen(){
		println("Entschulden Sie, aber die von Ihnen ausgewählte Sorte haben wir leider nicht zur verfügung!");
	}

}
