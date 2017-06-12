package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;

public class menue {

	public static void main(String[] args) throws InterruptedException {

		Ringpuffer rp = new Ringpuffer(-5);

		rp.put(1);
		rp.put(2);
		rp.put(3);
		rp.put(4);

//		 rp.get();
//		 rp.get();
		// rp.get();
		// rp.get();
		rp.put(5);

		rp.printArray();
	}

}
