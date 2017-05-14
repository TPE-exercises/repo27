package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil;

public interface Queue {
	/**
	 * if the queue gets full after entering of last objekt the size gets doubled if its the first time for the queue,otherwise throw overflow exception
	 *
	 * @param element to enter
	 * @return Queue with element
	 *  @throws OverflowException 
	 */
	public boolean enter(Object element) throws OverflowException;;
	
	/**
	 * Removes first element in the queue
	 *  
	 * @return first element thats kicked out
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * @return gets first element of the queue
	 */
	public Object front();
	
	
	/**
	 * @return true, if queue is empty
	 * @return false, if queue isn't empty
	 */
	public boolean isEmpty();
	
	
	/** 
	 * checks the size of the queue
	 * 
	 * @return the size of the queue
	 */
	public int size();
}