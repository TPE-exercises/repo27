package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

public class B_Tree implements BTree {//implements B_Baum{
	private  int ordnung;
	private  BTreeNode wurzel = null;
	
	
	public static void main(String[] args) {
		B_Tree bt = new B_Tree(2);
		
		BTreeNode a = new BTreeNode (bt, null, 2);
		bt.wurzel = a;
		BTreeNode b=  new BTreeNode (bt, null, 2);
		b = a.getKind(1);
		BTreeNode c=  new BTreeNode (bt, null, 2);
		c = a.getKind(1);
		
	//	wurzel.keys[1] = new Integer;
		
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
	public B_Tree(int ordnung) {
		this.ordnung = ordnung;
		this.wurzel = null;
	}
	/**
	 * Sucht nach dem gegebenen Schlüssel im Baum. Ist der Schlï¿½ssel im Baum enthalten, wird 
	 * das im Baum gespeicherte Objekt zurï¿½ckgegeben, andernfalls null
	 * @param key
	 * @return 
	 */
	public Integer search(Integer key) {
		if (wurzel == null) {
			return null;
		}
		return wurzel.search(key);
	}
	/**
	 * Fuegt einen Schlüssel ein, sofern der noch nicht im Baum enthalten ist
	 * @param c
	 * @return true wenn erfolgreich eingefï¿½gt, false wenn c bereits im Baum enthalten ist
	 */
	@Override
	public boolean insert(Integer c) {
		if (wurzel == null) {
			wurzel = new BTreeNode(this, null, this.ordnung);
		}
		return wurzel.insert(c);
	}
	
	
	@Override
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean contains(Integer o) {
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
		// TODO Auto-generated method stub
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
	public void addAll(B_Tree otherTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printInorder() {
		if(wurzel != null) {
			wurzel.printInorder();
			println();
		} else {
			println("tree is empty");			
		}
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

	
}