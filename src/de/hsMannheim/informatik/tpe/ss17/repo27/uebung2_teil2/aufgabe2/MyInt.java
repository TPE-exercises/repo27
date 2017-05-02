package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

public class MyInt implements Comparable{

	private int value;

	/**
	 * Contructor for set value
	 * @param value - int elements
	 */
	public MyInt(int value) {

		this.value = value;
	}

	/**
	 * @param value to set
	 */
	public void setValue(int value) {

		this.value = value;
	}

	/**
	 * @return int value
	 */
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
	/**
	 * output int value
	 */
	@Override
	public String toString() {

		return "" + value;
	}

}
