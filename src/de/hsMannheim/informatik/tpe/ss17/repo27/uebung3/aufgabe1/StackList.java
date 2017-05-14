package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1;

import static gdi.MakeItSimple.*;
import de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil.*;

public class StackList implements Stack,ADT{
	private int size;
	private LinkedList values;
//	private int exceptionFlag = 0;
	
	public StackList(int size){
		this.size = size;
		values = new LinkedList();
//		this.exceptionFlag = 0;
	}
	
	public StackList(){
		this(5);
	}
	
	@Override
	public boolean enter(Object toEnter) throws OverflowException {
		try{
			if(this.values.size()>= this.size){
				throw new OverflowException("Overflow : ", toEnter);
			}
			else{
				this.values.addFirst(toEnter);
			}
		}catch(OverflowException overflow){
//			if(exceptionFlag == 0){
//				this.size *= 2;
//				this.values.addFirst(toEnter);
//				this.exceptionFlag++;
//			}
//			else{
				throw overflow;
//			}
		}
		return true;
	}

	@Override
	public Object leave() throws UnderflowException {
		if(this.values.isEmpty()){
			throw new UnderflowException("Stack ist leer.");
		}
		else{
			Object toLeave = this.values.removeFirst(); // remove last ?
			return toLeave;
		}
	}

	@Override
	public Object front() {
		return this.values.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return this.values.isEmpty();
	}

	@Override
	public int size() {
		return this.values.size();
	}
	public String toString () {

		print("ADT : ");
		this.values.printList();
		
//		for(int i = 0 ; i < values.length; i++){
//		string +=   values[i] +" ";
//		}
	
		return " ";
	}
}

