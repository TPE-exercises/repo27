package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.*;

public class Menue{

	static String name;
	static String behaeltnis;
	static String art;
	static String[] sorten;
	static String[] extras;
	static Eis eis;

	static Eisdiele ed = new Eisdiele();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ed.begruessen();
		
		println();		
		println("=====Eiskarte=====");
		println("Bitte geben Sie ihr Wunscheis ein!");
		println("Spaghettieis");
		println("Bananasplit");
		println("Nussbecher");
		name = readLine();
		switch (name) {
		case "Spaghettieis":
			break;
		case "Bananasplit":

			break;
		case "Nussbecher":
			break;
		default:
			ed.entschuldigen();
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
		//sorten[];

		println("M�chten Sie noch paar extras auf Ihrem Eis?");
		println("Sahne");
		println("Schokostr�usel");
		println("Keks");
		println("So�e");
		//extras = readLine();
		
		ed.bestellen(name);
		ed.eis.setName(name);
		ed.eis.setBehaeltnis(behaeltnis);
		ed.eis.setArt(art);
		ed.eis.setSorten(null);
		ed.eis.setExtras(null);
	}
}
