package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

public class QuickSortParallel extends Thread implements SortAlgorithm {

	private Comparable[] array;
	private double startZeit = 0.0;
	private double endZeit = 0.0;
	private int vergleichen = 0;
	private int rekursionsAufrufe = 0;
	private int vertauschen = 0;

	public QuickSortParallel() {
	}

	public void sort(Comparable[] array) {
		startZeit = System.currentTimeMillis();
		this.array = array;
		// check if array empty
		if (array == null) {
			System.err.println("Array ist leer!");
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * 
	 * @param unsortedArray - Array to be sorted
	 * @param lowerElement - left element of the array
	 * @param upperElement - right element of the array
	 */
	private void quickSort(Comparable[] unsortedArray, int lowerElement, int upperElement) {

		rekursionsAufrufe++;

		if (upperElement > lowerElement) {
			int i = zerlege(unsortedArray, lowerElement, upperElement);
			// recursions calls
			quickSort(unsortedArray, lowerElement, i - 1);
			quickSort(unsortedArray, i + 1, upperElement);
		}
	}

	/**
	 * sort an unsorted array with the QuickSort
	 * 
	 * @param unsortedArray - Array to be sorted
	 * @param lowerElement - left element of the array
	 * @param upperElement - right element of the array
	 * @return
	 */
	public int zerlege(Comparable[] unsortedArray, int lowerElement, int upperElement) {
		int pivot = upperElement; // Index of the rightmost element.
		int index = lowerElement;// Index of the leftmost element.

		for (int pointer = lowerElement; pointer <= upperElement - 1; pointer++) {
			vergleichen++;
			// elements are only swapped if this condition is true
			if (unsortedArray[pointer].compareTo(unsortedArray[pivot]) == -1
					|| unsortedArray[pivot].compareTo(unsortedArray[pivot]) == 0) {
				if (index != pointer) {
					swap(unsortedArray, index, pointer);
				}
				index++;
			}
		}
		// bring the pivot-element to the right side
		swap(unsortedArray, index, pivot);
		return index;
	}

	/**
	 * Help method for swapping two elements in the array
	 * 
	 * @param unsortedArray - Array to be sorted
	 * @param number1 - passed parameter
	 * @param number2- passed parameter
	 */
	public void swap(Comparable[] unsortedArray, int number1, int number2) {
		vertauschen++;
		Comparable temp = unsortedArray[number1];
		unsortedArray[number1] = unsortedArray[number2];
		unsortedArray[number2] = temp;

	}

	public void printSortedArray(Comparable[] array) {
		System.out.print("Sortiertes Array { ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("}");
		System.out.println("");
		System.out.println("Rekursions Aufrufe: " + rekursionsAufrufe);
		System.out.println("Verglichene Elemente: " + vergleichen);
		System.out.println("Vertauschte Elemente: " + vertauschen);
	}

}
