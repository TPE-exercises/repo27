package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

import static gdi.MakeItSimple.*;
import java.util.Arrays;
import java.lang.*;

public class Sortierverfahren implements Comparable {
	
	/**
	 * test menue for the sorting process
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Comparable[] integer = { 10, 4, 1, 3, 2, 6, 7, 32, 11 };
//		Comparable[] string = {"Traube", "Birne", "Apfel", "Banane", "Kiwi", "Mango" };
//
//		print("Unsortiert Integer: ");
//		println(Arrays.toString(integer));
//		print("Insertion Sort: ");
//		insertionSort(integer);
//		print("Shaker Sort: ");
//		shakerSort(integer);
//		
//		println("");
//		
//		print("Unsortiert String: ");
//		println(Arrays.toString(string));
//		print("Insertion Sort: ");
//		insertionSort(string);
//		print("Shaker Sort: ");
//		shakerSort(string);
	}
	/**
	 * unsorted array are sorted with the insertionSort algorithm
	 * @param list -> unsorted array
	 */
	public static void insertionSort(Comparable[] list) {
		for (int index = 0; index < list.length; index++) {
			Comparable key = list[index];
			int position = index;

			// Shift larger values to the right
			while ((position > 0) && key.compareTo(list[position - 1]) < 0) {
				list[position] = list[position - 1];
				position--;
			}

			list[position] = key;

		}
		println(Arrays.toString(list));
	}
	/**
	 * unsorted array are sorted with the shakerSort algorithm
	 * @param array ->unsorted array
	 */
	public static void shakerSort(Comparable[] array) {
	    for (int i = 0; i < array.length/2; i++) {
	        boolean swapped = false;
	        for (int j = i; j < array.length - i - 1; j++) {
	            if (array[j].compareTo(array[j]) < array[j].compareTo(array[j+1])) {
	                Comparable tmp = array[j];
	                array[j] = array[j+1];
	                array[j+1] = tmp;
	                swapped = true;
	            }
	        }
	        for (int j = array.length - 2 - i; j > i; j--) {
	            if (array[j].compareTo(array[j]) > array[j].compareTo(array[j-1])) {
	            	Comparable tmp = array[j];
	                array[j] = array[j-1];
	                array[j-1] = tmp;
	                swapped = true;
	            }
	        }
	        if(!swapped) break;
	    }
		println(Arrays.toString(array));
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
