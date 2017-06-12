package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;
/**
 * 
 * Zuständig für das Entfernen der Elemente  im Ringpuffer
 * 
 * @author repo27
 *
 */
public class getterThread extends Thread {

	Ringpuffer rp;
	private String name;
	private int time;

	getterThread(Ringpuffer rp, int time, String name) {
		this.rp = rp;
		this.time = time;
		this.name = name;
	}
	/**
	 * Threads werden gestartet
	 */
	public void run() {
		while (!isInterrupted()) {
			try {
				System.out.println(name + ":" + rp.get());
			} catch (InterruptedException e) {

				interrupt();
			}
		}
	}

}
