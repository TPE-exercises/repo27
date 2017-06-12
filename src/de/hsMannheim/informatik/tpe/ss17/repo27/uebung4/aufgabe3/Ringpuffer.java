package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;
	/**
	 * Erzeugung eines Ringpuffers mit einer beliebigen Größe Die Größe wird durch
	 * den Konstruktor bestimmt
	 * 
	 * @author repo27
	 *
	 */
	public class Ringpuffer extends Thread {

		private Object array[];
		private int pointer;
		private int counter;

		public Ringpuffer(int size) {
			if(size< 0){
				size=size*-1;
			}
			array = new Object[size];
			pointer = size + 1;
			counter = 0;
			
		}

		/**
		 * Methode um Object Elmente hineinzufügen
		 * 
		 * @param element
		 *            Element welches hinzugefügt wird
		 * @throws InterruptedException
		 */
		synchronized public void put(Object element) throws InterruptedException {
			pointer--;
			while (array[0] != null) {
				// System.out.println("Ringpuffer ist voll" );
				wait();
			}

			notifyAll();
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] == null) {
					array[i] = element;
					break;
				}

			}

		}

		/**
		 * Methode um ein Object element zu entfernen
		 * 
		 * @return das entfernte element
		 * @throws InterruptedException
		 */
		synchronized public Object get() throws InterruptedException {
			Object element = 0;
			while (array[array.length - 1] == null) {
				// System.out.println("Kein element im Ringpuffer");
				wait();
			}

			notifyAll();
			element = array[array.length - 1];

			Object newArray[] = new Object[array.length];
			int c = counter;
			for (int i = pointer; i < array.length && c < array.length; i++, c++) {
				newArray[i] = array[c];
			}
			array = newArray;

			pointer++;
			counter++;

			return element;
		}

		/**
		 * methode um ein Array zu printen
		 */
		void printArray() {
			for (int i = 0; i < array.length; i++) {
				System.out.print(" , " + array[i]);
			}
			System.out.println();

		}

		/**
		 * testet ob es leer ist
		 * 
		 * @return boolean
		 */
		boolean isEmpty() {
			return array[array.length - 1] == null;
		}

		/**
		 * 
		 * @return Object []
		 */
		Object[] getArray() {
			return array;
		}
	}