package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testSequentiell() {
		Comparable[] array = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		QuickSortSequentiell qss = new QuickSortSequentiell();
		qss.sort(array);
		String s =  "1 2 3 4 5 6 7 8 9 10";
		assertEquals("Gleich: ",s, qss.toString());
	
	}
	
	@Test
	public void testParallel() {
		Comparable[] array = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
		QuickSortParallel qsp = new QuickSortParallel();
		qsp.sort(array);
		String s =  "1 2 3 4 5 6 7 8 9 10";
		assertEquals("Gleich: ",s, qsp.toString());
	
	}

}
