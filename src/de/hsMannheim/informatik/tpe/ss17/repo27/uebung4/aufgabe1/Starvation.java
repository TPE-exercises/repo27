package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe1;

public class Starvation extends Thread {

	private String s = " ist am arbeiten";

	@Override
	public void run() {

		synchronized (s) {
			for (int i = 0; i < 10; ++i) {
				
				// sagt kurz wer arbeitet
				
				System.out.println(  getName()+ " : " +s);
				
				try {
					
					sleep(100);
					
				} catch (InterruptedException e) {
					
					e.getMessage();
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Starvation s1 = new Starvation();
		Starvation s2 = new Starvation();
		Starvation s3 = new Starvation();
		Starvation s4 = new Starvation();
		
		//4 Thread´s werden gestarten, jedoch werden sie nicht in der gleichen Reihenfolge arbeiten
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}
}