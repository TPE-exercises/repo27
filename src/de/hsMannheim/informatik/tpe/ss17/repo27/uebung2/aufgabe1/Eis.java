package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eis {

	String name;
	double preis;
	String behaeltnis;
	String art;
	String[] sorten;
	String[] extras;

	Eis() {
		this.name = null;
		this.preis = 0.0;
		this.behaeltnis = null;
		this.art = null;
		this.sorten = null;
		this.extras = null;
	}
	/**
	 * Output for the container
	 */
	void vorbereiten() {
		println("Das Behältnis " + this.behaeltnis + " wird rausgenommen!");
	}
	/**
	 * Output with which varieties the container is filled
	 */
	void fuellen() {
		for (int n = 0; n < sorten.length; n++) {
			println("Behältnis wird mit: " + this.sorten[n] + "eis gefüllt!");
		}
	}
	/**
	 * Output with what the ice cream is garnishing
	 */
	void dekorieren() {
		for (int n = 0; n < extras.length; n++) {
			println("Das Eis wird mit: " + this.extras[n] + " ganiert");
		}
	}
	/**
	 * set the ice cream name
	 * @param name -> name of the ice cream
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * get the set ice cream name
	 * @return name of the ice cream
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * set price for the ice cream 
	 * @param preis -> price of the ice cream
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}
	/**
	 * get the price of the ice cream
	 * @return price of ice cream
	 */
	public double getPreis() {
		return this.preis;
	}
	/**
	 * set contains for the ice cream 
	 * @param behaeltnis -> container
	 */
	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}
	/**
	 * get the contains of the ice cream
	 * @return contains
	 */
	public String getBehaeltnis() {
		return this.behaeltnis;
	}
	/**
	 * set art for the ice cream 
	 * @param art -> art
	 */
	public void setArt(String art) {
		this.art = art;
	}
	/**
	 * get the arts of the ice cream
	 * @return art
	 */
	public String getArt() {
		return this.art;
	}
	/**
	 * set the ice cream art
	 * @param sorten ->  ice cream art
	 */
	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}
	/**
	 * get the ice cream arts
	 * @return ice cream arts
	 */
	public String[] getSorten() {
		return this.sorten;
	}
	/**
	 * set extras / decorations with the ice cream are garnishing
	 * @param extras -> garnishing arts
	 */
	public void setExtras(String[] extras) {
		this.extras = extras;
	}
	/**
	 * get the extras / decorations of the ice cream
	 * @return extras / decorations
	 */
	public String[] getExtras() {
		for (int i = 0; i < this.extras.length; i++) {
			println(extras[i]);
		}
		return this.extras;
	}

}
