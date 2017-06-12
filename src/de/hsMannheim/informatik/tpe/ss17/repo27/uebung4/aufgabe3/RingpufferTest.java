package de.hsMannheim.informatik.tpe.ss17.repo27.uebung4.aufgabe3;

import static org.junit.Assert.*;
import org.junit.Test;

public class RingpufferTest {
	Ringpuffer rp = new Ringpuffer(4);
	
	
	/**
	 * repo27
	 * Methode testet Arraystelle von put-Methoden
	 * 
	 */
	@Test
	public void RingpufferPutPositionTest() throws InterruptedException {
		
		rp.put(1);
		rp.put(2);
		rp.put(3);
		rp.put(4);
		Object array [] = rp.getArray();
		assertEquals(1, array[array.length-1]);
		assertEquals(2, array[2]);
		assertEquals(3, array[1]);
		assertEquals(4, array[0]);
		
	}
	/**
	 * Methode testet Arraystelle von get-Methoden
	 * 
	 */
	
	@Test
	public void RingpufferGetPositionTest() throws InterruptedException{
		rp.put(1);
		rp.put(2);
		rp.put(3);
		rp.put(4);
		rp.get();
		Object array [] = rp.getArray();
		assertEquals(null, array[0]);
		
		
	}
	/**
	 * Methode testet isEmpty
	 * 
	 */
	@Test
	public void RingpufferIsEmpty() throws InterruptedException{
		
		assertTrue(rp.isEmpty());
		rp.put(1);
		assertFalse(rp.isEmpty());
}
}

