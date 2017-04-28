package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2;

import static gdi.MakeItSimple.println;

import java.util.Arrays;
import  java.lang.*;


public class Sortierverfahren implements Comparable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparable[] integer = {10,4,1,3,2,6,7,32,11};
		Comparable[] string = {"Birne","Apfel","Banane","Kiwi","Mango","Traube"};
		
		insertionSort(integer);
	}
	public static void insertionSort (Comparable[] list)
	   {
	      for (int index = 0; index < list.length; index++)
	      {
	         Comparable key = list[index];
	         int position = index;

	         //  Shift larger values to the right
	         while (position > 0 && key.compareTo(list[position-1]) < 0)
	         {
	            list[position] = list[position-1];
	            position--;
	         }
	            
	         list[position] = key;
	         println(list[position]);

	      }
	      
	   }
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
