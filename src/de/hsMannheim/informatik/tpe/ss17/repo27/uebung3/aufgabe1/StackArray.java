package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1;

import static gdi.MakeItSimple.*;

import de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil.*;

public class StackArray implements Stack,ADT{
	
	private Object[] values;
	private int exceptionFlag = 0;
		
		
	public StackArray(int size){
			this.values = new Object[size];
			this.exceptionFlag = 0;
		}
		
	public StackArray(){
		this(5);
	}
	
	@Override
	public boolean enter(Object toEnter) throws OverflowException{
			try{
				if(values[values.length -1] == null){
					for(int i = 0; i < values.length; i++){
						if(values[i] == null){
							values[i] = toEnter;
							break;
						}
					}
				}
				else{
					throw new OverflowException("Overflow : " , toEnter );
				}
			}catch(OverflowException overflow){
				if(exceptionFlag == 0){
					doublesSize(toEnter);
					this.exceptionFlag++;
				}
				else{
					throw overflow;
				}
			}
			return true;
			
			
		}
		
	private Object[] doublesSize(Object toEnter){
			Object[] doubled = new Object[(this.values.length * 2)];
			for(int i = 0; i < this.values.length; i++){
				doubled[i] = values[i];
			}
			doubled[this.values.length] = toEnter;
			this.values = doubled;
			println("Die Länge des ADT wurde verdoppelt.");
			return this.values;
		}
		

		@Override
	public Object leave() throws UnderflowException{
			if(this.isEmpty()){
				throw new UnderflowException("");
			}
			else{
				Object toLeave = values[values.length-1];
				for(int i = 1; i < values.length; i++){
					if(values[i] == null){
						toLeave = values[i-1];
						values[i-1] = null;
						return toLeave;
					}
				}
				values[values.length-1] = null;
				return toLeave;
			}
		}

	@Override
	public Object front() {
			for(int i = 1; i < values.length; i++){
				if(values[i] == null){
					return values[i-1];
				}
			}
			return values[values.length-1];
		}

	@Override
	public boolean isEmpty() {
			if(values[0]==null){
				return true;
			}
			else{
				return false;
			}
		}

	@Override
	public int size() {
			for(int i = 0; i < values.length; i++){
				if(values[i]==null){
					return i;
				}
			}
			return values.length;
		}
	
	public String toString () {
		
		String string = "ADT : ";
		
		for(int i = 0 ; i < values.length; i++){
		string +=   values[i] +" ";
		}
		
		return string;
	}
}
