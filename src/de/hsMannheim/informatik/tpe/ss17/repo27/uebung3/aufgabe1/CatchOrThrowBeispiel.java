package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1;

import static gdi.MakeItSimple.*;
import de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil.*;

public class CatchOrThrowBeispiel {


	public static void main(String[] args) throws OverflowException,UnderflowException {
		
		try{
			
			try{
				
				throw new UnderflowException("Test");
		
			
		}
		catch(UnderflowException underflow1){
			println("Das ist die erste OverflowException.");
			throw underflow1;
		}
			}
		
		 catch(UnderflowException underflow2){
			 println("Das ist die zweite UnderflowException.");
			 throw underflow2;
		 }
		    
		    
		    
		
}

}