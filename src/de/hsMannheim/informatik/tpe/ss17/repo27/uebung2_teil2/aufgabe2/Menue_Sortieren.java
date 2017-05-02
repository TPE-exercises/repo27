package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class Menue_Sortieren {

	/**
	 * select which array are to be created and with how many elements
	 */
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
			int[] arrayInt = new int[anzahl];
			println("-------------");
			if (anzahl == 0) {
				println("[]");
			} else {
				for (int index = 0; index < arrayInt.length; index++) {
					arrayInt[index] = readInt();

					 if (index == anzahl) {
					 break;
					 }
				}

				auswahl_Sortierverfahren(MyIntArray(arrayInt));
				break;
			}
		case 2:
			println("Bitte geben Sie die Anzahl der Elemente hier an, die Sie eingeben wollen!");
			int anzahl2 = readInt();
			String[] arrayString = new String[anzahl2];
			println("-------------");
			int index2 = 0;
			String x = readLine();
			for (int i = 0; i < arrayString.length; i++) {
				arrayString[i] = readLine();
			}
			auswahl_Sortierverfahren(MyString(arrayString));
			break;
		default:
			println("Auswahl nich gefunden");
			break;
		};
	}
	/**
	 * convert int array to MyInt-Object
	 * @param array -> int array to convert in MyInt-Object
	 * @return in MyInt converted array
	 */
	private static MyInt[] MyIntArray(int[] array) {

		MyInt[] myInt = new MyInt[array.length];

		for (int i = 0; i < array.length; ++i) {
			myInt[i] = new MyInt(array[i]);
		}

		return myInt;
	}
	/**
	 * convert int array to MyString-Object
	 * @param array ->  string array to convert in MyInt-Object
	 * @return in MyString converted array
	 */
	private static MyString[] MyString(String[] array) {

		MyString[] myString = new MyString[array.length];

		for (int i = 0; i < array.length; ++i) {
			myString[i] = new MyString(array[i]);
		}

		return myString;
	}

	/**
	 * Which sorting procedure should be selected
	 * @param array -> unsorted array
	 */
	public static void auswahl_Sortierverfahren(Comparable[] array) {

		println("Bitte wählen sie nun aus, welches Sortierverfahren Sie benutzen wollen!");
		println("1. Insertion-Sort");
		println("2. Shaker-Sort");
		println("3. Insertion-/Shaker-Sort");
		int auswahlS_Verfahren = readInt();
		switch (auswahlS_Verfahren) {
		case 1:
			sortArray(1, array);
			break;
		case 2:
			sortArray(2, array);
			break;
		case 3:
			sortArray(3, array);
			break;
		default:
			println("Auswahl nich gefunden");
			break;
		};

	}
	/**
	 * procedure of selected sorting 
	 * @param sortAlgorithm -> Selected sorting method
	 * @param array -> unsorted array to convert in sorted array
	 */
	private static void sortArray(int sortAlgorithm, Comparable[] array) {

		print("Ihre eingegebenen Daten (\"Unsortiert\"): ");
		println(Arrays.toString(array));
		switch (sortAlgorithm) {
		case 1:
			print("Insertion-Sort: ");
			Sortierverfahren.insertionSort(array);
			break;
		case 2:
			print("Shaker-Sort: ");
			Sortierverfahren.shakerSort(array);
			break;
		case 3:
			print("Insertion-Sort: ");
			Sortierverfahren.insertionSort(array);
			print("Shaker-Sort: ");
			Sortierverfahren.shakerSort(array);
			break;
		default:
			break;
		};

	}
}
