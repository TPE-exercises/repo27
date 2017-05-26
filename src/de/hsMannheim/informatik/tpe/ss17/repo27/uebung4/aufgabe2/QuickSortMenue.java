package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

public class QuickSortMenue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortSequentiell qss = new QuickSortSequentiell();
		QuickSortParallel qsp = new QuickSortParallel();

		Comparable[] array = { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };

		// output unsorted array
		System.out.print("Unsortiertes Array { ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("}");
		System.out.println("");
		
		qsp.sort(array);

		// output sorted array
//		qs.printSortedArray(array);
		
	}
}
