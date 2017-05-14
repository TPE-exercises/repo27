package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil;

public interface ADT {
	/**
	 * if the queue gets full after entering of last objekt the size gets doubled if its the first time for the ADT,otherwise throw overflow exception
	 *
	 * @param element to enter
	 * @return ADT with element
	 *  @throws OverflowException 
	 */
	public boolean enter(Object element) throws OverflowException;;
	
	/**
	 * Removes first element in the ADT
	 *  
	 * @return first element thats kicked out
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * @return gets first element of the ADT
	 */
	public Object front();
	
	
	/**
	 * @return true, if ADT is empty
	 * @return false, if ADT isn't empty
	 */
	public boolean isEmpty();
	
	
	/** 
	 * checks the size of the ADT
	 * 
	 * @return the size of the queue
	 */
	public int size();
}