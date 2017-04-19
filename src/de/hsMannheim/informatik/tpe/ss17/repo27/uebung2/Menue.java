package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.*;

public class Menue{

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
			println("=======");
			main(args);
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
		//println("Bälle"); ??ist doch dasselbe wie eine Zeilen oebn?
		println("Spaghettis");
		println("Kekse");
		art = readLine();
		
		if(art.equals("Bällchen")){
			println("Bitte geben Sie an, wieviele Bälle Sie haben möchten!");
			anzahlKugel = new int[readInt()];
			sorten = new String[anzahlKugel.length+1];
		}
		println("Was für eine Sorte wollen Sie haben?");
		println("Vanille");
		println("Schokolade");
		println("Straciatella");
		println("Zitrone");
		
		for(int i=0; i<sorten.length ;i++){
			sorten[i]=readLine();

		}

		println("Möchten Sie noch paar extras auf Ihrem Eis?");
		println("Sahne");
		println("Schokosträusel");
		println("Keks");
		println("Soße");
		println("");
		println("Bitte geben Sie an, wieviele extras Sie haben möchten!");
		anzahlExtras = new int[readInt()];
		if(anzahlExtras.length != 0) {
			extras = new String[anzahlExtras.length + 1];
			for (int i = 0; i <extras.length; i++) {
				extras[i]=readLine();
			ed.eis.setExtras(extras);
			}
		}
		
		ed.eis.setBehaeltnis(behaeltnis);
		ed.eis.setArt(art);
		ed.eis.setSorten(null);
		ed.eis.setExtras(null);
		
		ed.bestellen(name);
		
		ed.eis.vorbereiten();
		ed.eis.fuellen();
		ed.eis.dekorieren();
		
		ed.kassieren();
		println(ed.eis.getExtras());
	}
}
