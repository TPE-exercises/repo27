package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1;

import static gdi.MakeItSimple.*;
import de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil.*;

public class QueueArray implements Queue,ADT {

	private Object[] values;
	private int exceptionFlag = 0;
	private int inputPosition;
	private int outputPosition;

	public QueueArray(int size) {
			this.values = new Object[size];
			this.inputPosition = 0;
			this.outputPosition = 0;
			this.exceptionFlag = 0;
		}
	public QueueArray() {
		this(5);
	}

	@Override
	public boolean enter(Object toEnter) {
			try {
				if(inputPosition >= this.values.length){
					throw new OverflowException("Overflow : ", toEnter);
				}
				else{
					this.values[inputPosition] = toEnter;
					if(this.inputPosition == this.outputPosition){
						this.outputPosition++;
						if(this.outputPosition >= this.values.length){
							this.outputPosition = 0;
						}
					}
					this.inputPosition ++;
				}
			} catch (OverflowException overflow) {
				if (this.exceptionFlag == 0) {
					this.doublesSize();
					this.values[inputPosition] = toEnter;
					this.inputPosition++;
					this.exceptionFlag++;
				} else {
//					this.inputPosition = 0;
//					this.values[this.inputPosition] = toEnter;
//					if(this.outputPosition == this.inputPosition){
//						this.outputPosition++;
//					}
//					this.inputPosition++;
					System.out.println(overflow.toString());
					
				}
			}
			return true;
		}

	private Object[] doublesSize() {
			Object[] doubled = new Object[(this.values.length * 2)];
			for (int i = 0; i < this.values.length; i++) {
				doubled[i] = values[i];
			}
			this.values = doubled;
			println("Die Länge des ADT wurde verdoppelt.");
			return this.values;
		}

	@Override
	public Object leave() throws UnderflowException {
			if (this.isEmpty()) {
				throw new UnderflowException("Queue is empty");
			} else {
				Object toLeave = this.values[0];
//				this.values[0] = null;
				for(int i = 0 ; i < values.length-1; i++){
					this.values[i] = this.values[i+1];
				}
				this.values[this.values.length-1] = null;
				this.inputPosition--;
				this.outputPosition--;
				
				
				return toLeave;

			}

		}

	@Override
	public Object front(){
			return values[0]; 
			}
		

	@Override
	public boolean isEmpty() {
			for(int i = 0; i < this.values.length; i++){
				if(this.values[i] != null){
					return false;
				}
			}
			return true;
		}

	@Override
	public int size() {
			int size = 0;
			for(int i = 0; i < values.length; i++){
				if(values[i] != null){
					size++;
				}
			}
			return size;
		}
	public String toString () {
		
		String string = "ADT : ";
		
		for(int i = 0 ; i < values.length; i++){
			if(values[i] != null)
			string +=   values[i] +" ";
		}
		
		return string;
	}
	
	}
