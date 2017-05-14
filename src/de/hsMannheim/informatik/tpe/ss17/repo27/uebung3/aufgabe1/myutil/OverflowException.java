package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil;

public class OverflowException extends Exception{

private static final long serialVersionUID = 1L;
	
	private Object objectCausedOverflow;
	
	public Object getObjectCausedOverflow(){
		return this.objectCausedOverflow;
	}
	
	public OverflowException(String message, Object objectCausedOverflow){
		super(message);
		this.objectCausedOverflow = objectCausedOverflow;
	}
	
	public String toString(){
		String message = this.getMessage();
		message += "\n Durch das Objekt -" + objectCausedOverflow + "- wurde eine Overflowexception ausgelöst.";
		return message;
}
}
