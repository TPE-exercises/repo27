package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe1;

public class Deadlock {

	private static String s1 = "Teil 1";
	private static String s2 = "Teil 2";

	private static class Thread1 extends Thread {
		@Override
		public void run() {
			synchronized (s1) {
				
				System.out.println(s1);

				//wir setzten den Thread in schlaf damit nicht der Thread schon beendet ist bevor der  andere startet
				
				try {
					sleep(20);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					return;
				}
				/* Da im anderen Thread s2 schon gelockt ist muss gewartet
				 werden bis der Thread s2 freigibt. Das passiert aber nicht.*/
				
				synchronized (s2) {
					
					System.out.println(s2);
				}
			}
		}
	}

	private static class Thread2 extends Thread {
		@Override
		public void run() {
			synchronized (s2) {
				
				System.out.println(s2);

				//wir setzten den Thread in schlaf damit nicht der Thread schon beendet ist bevor der  andere startet
				
				try {
					
					sleep(20);
					
				} catch (InterruptedException e) {
					
					System.out.println(e.getMessage());
					return;
				}

				/* Da im anderen Thread s1 schon gelockt ist muss gewartet
				 werden bis der Thread s1 freigibt. Das passiert aber nicht.*/
				synchronized (s1) {
					
					System.out.println(s1);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		 // durch den start beider Thread´s müssten 2mal Teil 1 und Teil 2 in der Konsole stehen
		
		t1.start();
		t2.start();
	}
}