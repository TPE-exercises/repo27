package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class Menue_Sortieren {

	static Comparable[] sortArray;

	static Sortierverfahren sv = new Sortierverfahren();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		println("Bitte wählen Sie nun aus, was für Elemente Sie in das Array einfügen wollen!");
		println("1. Integer-Elemente");
		println("2. String-Elemente");
		int auswahl = readInt();
		switch (auswahl) {
		case 1:
			println("Bitte geben Sie die Anzahl der Elemente hier an, die Sie eingeben wollen!");
			int anzahl = readInt();
			println("-------------");
			if (anzahl == 0) {
				println("[]");
			} else {
				sortArray = new Comparable[anzahl];
				int index = 0;
				while (sortArray[index] == null) {
					sortArray[index] = readInt();
					index++;
					if (index == anzahl) {
						break;
					}
				}
				auswahl_Sortierverfahren(sortArray);
				break;
			}
		case 2:
			println("Bitte geben Sie die Anzahl der Elemente hier an, die Sie eingeben wollen!");
			int anzahl2 = readInt();
			println("-------------");
			sortArray = new Comparable[anzahl2];
			int index2 = 0;
			String x = readLine();
			for (int i = 0; i < sortArray.length; i++) {
				sortArray[i] = readLine();
			}
			auswahl_Sortierverfahren(sortArray);
			break;
		default:
			println("Auswahl nich gefunden");
			break;
		};
	}
	
	public static void auswahl_Sortierverfahren(Comparable[] array){
		print("Ihre eingegebenen Daten (\"Unsortiert\"): ");
		println(Arrays.toString(sortArray));
		println("Bitte wählen sie nun aus, welches Sortierverfahren Sie benutzen wollen!");
		println("1. Insertion-Sort");
		println("2. Shaker-Sort");
		println("3. Insertion-/Shaker-Sort");
		int auswahlS_Verfahren = readInt();
		switch(auswahlS_Verfahren){
		case 1:
			print("Insertion-Sort: ");
			sv.insertionSort(sortArray);
			break;
		case 2:
			print("Shaker-Sort: ");
			sv.shakerSort(sortArray);
			break;
		case 3:
			print("Insertion-Sort: ");
			sv.insertionSort(sortArray);
			print("Shaker-Sort: ");
			sv.shakerSort(sortArray);
			break;
		default:
			println("Auswahl nich gefunden");
		break;
		};
		
	}
}
