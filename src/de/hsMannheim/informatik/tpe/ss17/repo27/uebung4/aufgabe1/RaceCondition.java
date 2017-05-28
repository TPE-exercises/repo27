package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe1;

public class RaceCondition extends Thread {

	private static int value = 0;

	@Override
	public void run() {
		
		//schleife läuft 1000mal und addiert somit 1000 zur value
		
		for(int i = 0; i < 1000; ++i) {
			
			// Mehrere Threads können gleichzeitig die Variable erhöhen 
			value += 1;
			
			try {
				
				// Schläft für 1 ms
				
				sleep(1);
				
			} catch (InterruptedException e) {
				
				System.out.println(this.getName() + " interrupted");
				return;
			}
		}
		
		System.out.println("value: " + value);
	}

	public static void main(String[] args) {
		
		RaceCondition rc1 = new RaceCondition();
		rc1.setName("rc1");
		RaceCondition rc2 = new RaceCondition();
		rc2.setName("rc2");
		
		// Startet 2 Threads und die Ausgabe müsste  (da 1000 + 1000 = 2000) 2000 sein
		
		rc1.start();
		rc2.start();
		
	}
}

