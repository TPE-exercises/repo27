package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class InsertionSort implements Sort{

	@Override
	public void sort(Comparable[] a) {
		print("Insertion-Sort: ");
		for (int index = 0; index < a.length; index++) {
			Comparable key = a[index];
			int position = index;

			// Shift larger values to the right
			while ((position > 0) && key.compareTo(a[position - 1]) < 0) {
				a[position] = a[position - 1];
				position--;
			}

			a[position] = key;

		}
		println(Arrays.toString(a));
	}

	

}
