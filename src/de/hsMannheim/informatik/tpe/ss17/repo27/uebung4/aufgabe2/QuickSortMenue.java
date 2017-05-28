package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

public class QuickSortMenue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortSequentiell qss = new QuickSortSequentiell();
		QuickSortParallel qsp = new QuickSortParallel();

		Comparable [] array = {"was","wie","wo","wer"};
//		Integer [] array = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		
		// output unsorted array
		System.out.print("Unsortiertes Array { ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("}");
		System.out.println("");
		
		System.out.println("____________________________");
		
		qss.sort(array);
		qsp.sort(array);

		// output sorted array
		System.out.println("Sorted Sequentiell: ");
		qss.printSortedArray(array);
		System.out.println("____________________________");
		System.out.println("Sorted Parallel");
		qsp.printSortedArray(array);
	}
}
