package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe2;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;

import java.util.Arrays;

public class ShakerSort implements Sort {

	@Override
	public void sort(Comparable[] a) {
		print("Shaker-Sort: ");

		for (int i = 0; i < a.length/2; i++) {
	        boolean swapped = false;
	        for (int j = i; j < a.length - i - 1; j++) {
	            if (a[j].compareTo(a[j]) < a[j].compareTo(a[j+1])) {
	                Comparable tmp = a[j];
	                a[j] = a[j+1];
	                a[j+1] = tmp;
	                swapped = true;
	            }
	        }
	        for (int j = a.length - 2 - i; j > i; j--) {
	            if (a[j].compareTo(a[j]) > a[j].compareTo(a[j-1])) {
	            	Comparable tmp = a[j];
	                a[j] = a[j-1];
	                a[j-1] = tmp;
	                swapped = true;
	            }
	        }
	        if(!swapped) break;
	    }
		println(Arrays.toString(a));
	}
	
	

}
