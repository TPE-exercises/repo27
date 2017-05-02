package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Menue{
	static int auswahl;
	static String name;
	static String behaeltnis;
	static String art;
	static String[] sorten=null;
	static String[] extras=null;
	static Eis eis;
	static int[] anzahlKugel = null;
	static int[] anzahlExtras = null;
	static Eisdiele ed = new Eisdiele();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		println();		
		println("=====Eiskarte=====");
		println("Bitte geben Sie ihr Wunscheis ein!");
		println("----------------------------");
		println("1: Spaghettieis"+
				"\n"+"-Behältnis: Teller"+
				"\n"+"-Art: Spaghettis"+
				"\n"+"-Sorte: Vanille"+
				"\n"+"-Extras: Sahne & Erdbeersoße & weiße Schokolade Raspeln"+
				"\n"+"-Preis: 5.50€");
		println("----------------------------");
		println("2: Bananasplit"+
				"\n"+"-Behältnis: ovaler Teller"+
				"\n"+"-Art: Bananensplit"+
				"\n"+"-Sorte: Vanille & Banane"+
				"\n"+"-Extras: Bananen & Sahne & Schokosoße & Kekse"+
				"\n"+"-Preis: 6.70€");
		println("----------------------------");
		println("3: Nussbecher"+
				"\n"+"-Behältnis: höhes Glas"+
				"\n"+"-Art: Nussbecher"+
				"\n"+"-Sorte: Vanille & Schoko & Nuss"+
				"\n"+"-Extras: Nüsse & Sahne & Schoko-/Karamelsoße & Kekse"+
				"\n"+"-Preis: 6.00€");
		println("----------------------------");
		println("Bitte geben Sie jetzt ihre Wunschnummer ein!");
		
		auswahl = readInt();
		switch (auswahl) {
		case 1:	name ="Spaghettieis";
			break;
		case 2: name ="Bananasplit";
			break;
		case 3: name ="Nussbecher";
			break;
		default:
			ed.entschuldigen();
			println("=======");
			main(args);
			break;
		};

		ed.bestellen(name);
		
	}
}
