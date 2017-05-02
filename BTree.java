package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

import TPESchramm.BTreeNode;

public class BTree implements B_Baum {//implements B_Baum{
	private  int ordnung;
	private  BTreeNode wurzel = null;
	
	
	public static void main(String[] args) {
		BTree bt = new BTree(2);
		
		BTreeNode a = new BTreeNode (bt, null, 2);
		bt.wurzel = a;
		BTreeNode b=  new BTreeNode (bt, null, 2);
		b = a.getKind(1);
		BTreeNode c=  new BTreeNode (bt, null, 2);
		c = a.getKind(1);
		
		wurzel.keys[1] = new Integer 
		
//		Integer i= new Integer (11);
//		bt.insert(i);
//		 i= new Integer (2);
//		bt.insert(i);
//		 i= new Integer (4);
//		bt.insert(i);
//		 i= new Integer (5);
//		bt.insert(i);
//		 i= new Integer (7);
//		bt.insert(i);
//		 i= new Integer (8);
//		bt.insert(i);
//		 i= new Integer (1);
//		bt.insert(i);
//		 i= new Integer (3);
//		bt.insert(i);
//		 i= new Integer (1);
//		bt.insert(i);
//		 i= new Integer (7);
//		bt.insert(i);
//		 i= new Integer (9);
//		bt.insert(i);
		bt.printInorder();
	}
	
	
	/**
	 * Erzeugt einen B-Baum der gegebenen Ordnung
	 * @param ordnung
	 */
	public BTree(int ordnung) {
		this.ordnung = ordnung;
		this.wurzel = null;
	}
	/**
	 * Sucht nach dem gegebenen Schl�ssel im Baum. Ist der Schl�ssel im Baum enthalten, wird 
	 * das im Baum gespeicherte Objekt zur�ckgegeben, andernfalls null
	 * @param key
	 * @return 
	 */
	public Integer suchen(Integer key) {
		if (wurzel == null) {
			return null;
		}
		return wurzel.suchen(key);
	}
	/**
	 * Fuegt einen Schl�ssel ein, sofern der noch nicht im Baum enthalten ist
	 * @param c
	 * @return true wenn erfolgreich eingef�gt, false wenn c bereits im Baum enthalten ist
	 */
	public boolean insert(Integer c) {
		if (wurzel == null) {
			wurzel = new BTreeNode(this, null, this.ordnung);
		}
		return wurzel.insert(c);
	}
	void setWurzel(BTreeNode wurzel) {
		this.wurzel = wurzel;
	}
	public String toString() {
		if (wurzel == null) {
			return "[leer]";
		} else {
			return wurzel.toString();
		}
	}
	
	public void printInorder() {
		if(wurzel != null) {
			wurzel.printInorder();
			println();
		} else {
			println("tree is empty");			
		}
	}


	@Override
	public boolean insert(int o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(int o) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getMax() {
			if(this.wurzel == null)
				println("Der Baum ist leer, und hat somit kein h�chstes Element.")
				
				this.wurzel.
				
				return 0;
		return 0;
	}


	@Override
	public int getMin() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void addAll(BTree otherTree) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printPostorder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printPreorder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub
		
	}
	
}