package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

public class QuickSortParallel extends Thread implements SortAlgorithm {

	private Comparable[] unsortedArray;
	private double startZeit = 0.0;
	private double endZeit = 0.0;
	private int vergleichen = 0;
	private int rekursionsAufrufe = 0;
	private int vertauschen = 0;
	private int thread;
	private int joinings;
	private int upperElement,lowerElement;
	
	public QuickSortParallel(){
		
	}
	
	/**
	 *unsorted array was sorted
	 */
	public void sort(Comparable[] array) {
		startZeit = System.currentTimeMillis();
		this.unsortedArray = array;
		// check if array empty
		if (array == null) {
			System.err.println("Array ist leer!");
			return;
		}
		quickSortParallel(array, 0, array.length - 1);
	}

	/**
	 * 
	 * @param unsortedArray - Array to be sorted
	 * @param lowerElement - left element of the array
	 * @param upperElement - right element of the array
	 */
	private void quickSortParallel(Comparable[] unsortedArray, int lowerElement, int upperElement) {
		rekursionsAufrufe++;

		if (upperElement > lowerElement) {
			
			int i = zerlege(unsortedArray, lowerElement, upperElement);
			// recursions calls
			
			Thread lowerThread = new Thread (new QuickSortParallel(unsortedArray,lowerElement, i - 1));
			Thread upperThread = new Thread (new QuickSortParallel(unsortedArray,i + 1,upperElement));
			thread = thread +2;
			lowerThread.start();
			upperThread.start();
			
			try {
				lowerThread.join();
				upperThread.join();
				joinings++;
				}
			catch(InterruptedException e){
				
			}
		}
	}
	/**
	 * Second Konstructor with 3 parameter
	 * @param unsortedArray - Array to be sorted
	 * @param lowerElement - left element of the array
	 * @param upperElement - right element of the array
	 */
	public QuickSortParallel(Comparable[] unsortedArray, int lowerElement, int upperElement){
		this.unsortedArray = unsortedArray;
		this.lowerElement = lowerElement;
		this.upperElement = upperElement;
	}
	
	/**
	 * Thread was startet
	 */
	public void run(){
		quickSortParallel(this.unsortedArray,this.lowerElement,this.upperElement);	
		
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

		for (int pointer = lowerElement; pointer < upperElement; pointer++) {
			vergleichen++;
			// elements are only swapped if this condition is true
//			if (unsortedArray[pointer].compareTo(unsortedArray[pivot]) == -1 || unsortedArray[pivot].compareTo(unsortedArray[pivot]) == 0) {
			if(unsortedArray[pointer].compareTo(unsortedArray[pivot]) <= 0){
				if (index != pointer) {
					swap(unsortedArray, index, pointer);
				}
				index++;

			}
		}
		// bring the pivot-element to the right side
		if (index != pivot) {
			swap(unsortedArray, index, pivot);
		}
//		swap(unsortedArray, index, pivot);
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
	
	/**
	 * output Sorted Array with 
	 * @param array - Sorted array
	 */
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
		System.out.println("Zeit: " + endZeit + "ms");
		System.out.println("Threads: " + thread);
		System.out.println("Join: " + joinings);
	}
	
	/**
	 *  write Comparable Array in String
	 */
	public String toString(){
		String s ="";
		for(int i = 0; i < unsortedArray.length; i++) {
			if(i == unsortedArray.length-1){
				s = s + unsortedArray[i];
			}
			else{
				s = s + unsortedArray[i]+" ";
			}
			
		}

		return s;
	}

}
