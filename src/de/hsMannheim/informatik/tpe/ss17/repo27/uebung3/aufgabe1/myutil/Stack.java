package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil;

public interface Stack {

	
	/**
	 * if the queue gets full after entering of last objekt the size gets doubled if its the first time for the stack,otherwise throw overflow exception
	 *
	 * @param element to enter
	 * @return stack with element
	 *  @throws OverflowException 
	 */
	public boolean enter(Object element) throws OverflowException;;
	
	/**
	 * Removes first element in the stack
	 *  
	 * @return first element thats kicked out
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * @return gets first element of the stack
	 */
	public Object front();
	
	
	/**
	 * @return true, if stack is empty
	 * @return false, if stack isn't empty
	 */
	public boolean isEmpty();
	
	
	/** 
	 * checks the size of the stack
	 * 
	 * @return the size of the stack
	 */
	public int size();
}