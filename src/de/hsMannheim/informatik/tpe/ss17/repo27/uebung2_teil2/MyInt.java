package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2;

public class MyInt implements Comparable{

	private int value;

	//Contructor for set value
	public MyInt(int value) {

		this.value = value;
	}

	//set value
	public void setValue(int value) {

		this.value = value;
	}

	//return value
	public int getValue() {

		return value;
	}

	@Override
	public int compareTo(Object o) {

		int otherValue = ((MyInt) o).getValue();

		if (value > otherValue) {
			return 1;
		} else if (value < otherValue) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {

		return "" + value;
	}

}
