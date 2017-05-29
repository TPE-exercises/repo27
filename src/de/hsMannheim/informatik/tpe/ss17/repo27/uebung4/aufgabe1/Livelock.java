package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe1;

public class Livelock {

	private class Person extends Thread {

		private String name;
		private boolean laesstVor;

		public Person(String name, boolean laesstVor) {
			this.name = name;
			this.laesstVor = laesstVor;
		}

		public void geheInWarteschlange(Warteschlange warteschlange, Person otherPerson) {

			while (stehtInSchlange()) {
				// Wenn jemand anderes vor einem steht wartet die Person solange.
				if (warteschlange.werIstErster() != this) {

					System.out.println(
							"stehe hinter " + warteschlange.werIstErster().getPersonName() + ", da er erster in der Warteschlange ist.");

					try {
						sleep(10);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
						return;
					}
				}

				// Wenn jemand anderes in der Warteschlange steht lässt man ihm den Vortritt.
				
				if (otherPerson.stehtInSchlange()) {
					System.out
							.println("lasse " +  warteschlange.werIstErster().getPersonName() + " vor mich in der Warteschlange.");

					warteschlange.setErsterInSchlange(otherPerson);
				} else {
					
					// steht niemand anderes in der Warteschlange bin ich erster und einziger  und somit bald dran.
					
					laesstVor = false;
				}
			}
		}

		public boolean stehtInSchlange() {
			return laesstVor;
		}

		public String getPersonName() {
			return name;
		}
	}

	private class Warteschlange {

		private Person ersterInSchlange;

		public Warteschlange(Person andrerInWarteschlange) {
			this.ersterInSchlange = andrerInWarteschlange;
		}

		public Person werIstErster() {
			return ersterInSchlange;
		}

		public synchronized void setErsterInSchlange(Person ersterInSchlange) {
			this.ersterInSchlange = ersterInSchlange;
		}
	}

	public static void main(String[] args) {

		Person p1 = new Livelock().new Person("Person1", true);
		Person p2 = new Livelock().new Person("Person2", true);
		Warteschlange s1 = new Livelock().new Warteschlange(p1);
		
		//zwei (Thread´s) Personen werden in die Warteschlange gesetzt, wobei sich beide immer wieder vorlassen werden.
		
		new Thread() {
			@Override
			public void run() {
				p1.geheInWarteschlange(s1, p2);
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				p2.geheInWarteschlange(s1, p1);
			}
		}.start();
	}
}