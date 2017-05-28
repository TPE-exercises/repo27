package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

public class QuickSortMenue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortSequentiell qss = new QuickSortSequentiell();
		QuickSortParallel qsp = new QuickSortParallel();

//		Comparable [] array = {"was","wie","wo","wer"};
//		Integer [] array = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		Integer[] array = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
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
