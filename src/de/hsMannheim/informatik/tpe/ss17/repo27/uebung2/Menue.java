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

		println("Bitte wählen Sie nun Ihr Wunschbehältnis!");
		println("Waffel");
		println("Becher");
		println("Teller");
		println("Schüssel");
		println("Glas");
		behaeltnis = readLine();

		println("Bitte wählen Sie nun die Art von Ihrem Eis!");
		println("Bällchen");
		println("Bälle");
		println("Spaghettis");
		println("Kekse");
		art = readLine();

		println("Was für eine Sorte wollen Sie haben?");
		println("Vanille");
		println("Schokolade");
		println("Straciatella");
		println("Zitrone");
		//sorten[];

		println("Möchten Sie noch paar extras auf Ihrem Eis?");
		println("Sahne");
		println("Schokosträusel");
		println("Keks");
		println("Soße");
		//extras = readLine();
		
		ed.bestellen(name);
		ed.eis.setName(name);
		ed.eis.setBehaeltnis(behaeltnis);
		ed.eis.setArt(art);
		ed.eis.setSorten(null);
		ed.eis.setExtras(null);
	}
}
