package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.*;

public class Eisdiele{
	static String typ;
	static String behaeltnis;
	static String art;
	static String[] sorten;
	static String[] extras;
	static Eis eis;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		begruessen();
		println("=====Eiskarte=====");
		println("Bitte geben Sie ihr Wunscheis ein!");
		println("1.Spaghettieis");
		println("2.Bananasplit");
		println("3.Nussbecher");
		typ = readLine();
		switch (typ) {
		case "Spaghettieis":
			break;
		case "Bananasplit":

			break;
		case "Nussbecher":
			break;
		default: 
			entschuldigen();
			break;
		};
		
		println("Bitte w�hlen Sie nun Ihr Wunschbeh�ltnis!");
		println("Waffel");
		println("Becher");
		println("Teller");
		println("Sch�ssel");
		println("Glas");
		behaeltnis = readLine();
		
		println("Bitte w�hlen Sie nun die Art von Ihrem Eis!");
		println("B�llchen");
		println("B�lle");
		println("Spaghettis");
		println("Kekse");
		art = readLine();
		
		println("Was f�r eine Sorte wollen Sie haben?");
		println("Vanille");
		println("Schokolade");
		println("Straciatella");
		println("Zitrone");
		//sorten;
		
		println("M�chten Sie noch paar extras auf Ihrem Eis?");
		println("Sahne");
		println("Schokostr�usel");
		println("Keks");
		println("So�e");
		//extras = readLine();
		
		bestellen(typ);
		
	}

	
	public static void bestellen(String typ){
		eis = new Eis(typ,0.0,behaeltnis,art,sorten,extras);
		kassieren();
	}


	static void begruessen(){
		println("Hallo und Herzlich Willkommen zu unserer Eisdiele!");
		println("Wie m�chten Sie ihr Eis gerne habe!");
	}
	
	static void kassieren(){
		double preis = eis.gebePreisZurueck();
		println("Das macht dann " + preis+"�");
		double geld = readInt();
		double restgeld=geld-preis;
		if(restgeld<0){
			println("Es fehlen noch "+(restgeld*(-1))+"�");

		}
		else{
			println("Sie bekommen noch "+restgeld+"�");
			verabschieden();
		}
	}
	
	static void verabschieden(){
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}
	
	static void entschuldigen(){
		println("Entschulden Sie, aber die von Ihnen ausgew�hlte Sorte haben wir leider nicht zur verf�gung!");
	}

}
