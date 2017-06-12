package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;

import java.util.Random;

/**
 * Zuständig für das einfügen der Elemente im Ringpuffer
 * 
 * @author repo27
 */
public class putterThread extends Thread {

	Ringpuffer rp;
	private String name;
	private int time;

	putterThread(Ringpuffer rp, int time, String name) {
		this.rp = rp;
		this.time = time;
		this.name = name;
	}

	/**
	 * Threads die gestartet werden für die putMethode zuständig
	 */
	public void run() {
		while (!isInterrupted()) {

			try {
				Object element = (int) (Math.random() * 1000);
				sleep(time);
				rp.put(element);

				System.out.println(name + ":" + element);
			} catch (InterruptedException e) {

				interrupt();
			}
		}
	}
}
