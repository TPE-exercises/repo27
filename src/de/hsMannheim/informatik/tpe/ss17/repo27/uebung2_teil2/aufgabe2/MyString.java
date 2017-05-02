package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

public class MyString implements Comparable {

	private String string;

	//Contructor for set value
	public MyString(String string) {
		this.string = string;
	}

	//set value
	public void setString(String string) {
		this.string = string;
	}

	//return value
	public String getString() {
		return string;
	}

	@Override
	public int compareTo(Object o) {

		return string.compareTo((String) o.toString());
	}

	@Override
	public String toString() {
		return string;
	}
}