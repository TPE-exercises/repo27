package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2;

import static gdi.MakeItSimple.*;

public class Eis {

	String name;
	double preis;
	String behaeltnis;
	String art;
	String[] sorten = { "Vanille", "Schokolade", "Straciatella", "Zitron" };
	String[] extras;//= { "Sahne", " Schokostraeusel", "Keks", "Soﬂe" };

	public Eis(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		this.name = name;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		//this.extras = extras;

	}

	public Eis() {
		this.name = null;
		this.preis = 0.0;
		this.behaeltnis = null;
		this.art = null;
		this.sorten = null;
		//this.extras = null;
	}

	void vorbereiten() {
		this.behaeltnis = getBehaeltnis(); 
	}

	void fuellen() {
		
	}

	void dekorieren() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public double getPreis() {
		return this.preis;
	}

	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}

	public String getBehaeltnis() {
		return this.behaeltnis;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getArt() {
		return this.art;
	}

	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}

	public String[] getSorten() {
		return this.sorten;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}

	public String[] getExtras() {
		for(int i=0; i<this.extras.length;i++){
			println(extras[i]);
		}
		return this.extras;
	}

}
