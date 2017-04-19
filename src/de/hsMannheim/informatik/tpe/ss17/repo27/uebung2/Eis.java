package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.readInt;

public class Eis {

	String name;
	double preis;
	String behaeltnis;
	String art;
	String[] sorten = {"Vanille","Schokolade","Straciatella","Zitron"};
	String[] extras  = {"Sahne"," Schokostraeusel","Keks","Soﬂe"};

	public Eis(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras){
		this.name = name;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
		vorbereitet();
	}
		
	void vorbereitet(){
		switch (name) {
		case "Spaghettieis":
			preis = 4.99;
			art = "Spaghettis";
			break;
		case "Bananasplit":
			preis = 4.49;
			art = "";
			break;
		case "Nussbecher":
			preis = 3.99;
			art = "";
			break;
		default: 
			preis = 0.0;
			break;
		};
		
		switch (behaeltnis) {
		case "Waffel":
			behaeltnis = "Waffel";
			preis = preis+0.10;
			break;
		case "Becher":
			behaeltnis = "Becher";
			preis = preis+0.0;
			break;
		case "Teller":
			behaeltnis = "Teller";
			preis = preis+0.05;
			break;
		case "Schussel":
			behaeltnis = "Schussel";
			preis = preis+0.05;
			break;
		case "Glas":
			behaeltnis = "Glas";
			preis = preis+0.15;
			break;
		default: 
			behaeltnis = "";
			preis = 0;
			break;
		};
	}
	
	void fuellen(){
		
	}
	
	void dekorieren(){
		
	}
	
	double gebePreisZurueck(){
		return preis;
	}

}
