package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

public class B_Tree implements BTree {// implements B_Baum{
	private int ordnung;
	private BTreeNode root = null;

	public static void main(String[] args) {
		B_Tree bt = new B_Tree(2);

		BTreeNode a = new BTreeNode(2);
		bt.root = a;
		BTreeNode b = new BTreeNode(2);
		b = a.getChild(1);
		BTreeNode c = new BTreeNode(2);
		c = a.getChild(1);

		Integer i = new Integer(11);
		bt.insert(i);
		// i= new Integer (2);
		// bt.insert(i);
		// i= new Integer (4);
		// bt.insert(i);
		// i= new Integer (5);
		// bt.insert(i);
		// i= new Integer (7);
		// bt.insert(i);
		// i= new Integer (8);
		// bt.insert(i);
		// i= new Integer (1);
		// bt.insert(i);
		// i= new Integer (3);
		// bt.insert(i);
		// i= new Integer (1);
		// bt.insert(i);
		// i= new Integer (7);
		// bt.insert(i);
		// i= new Integer (9);
		// bt.insert(i);
		bt.printInorder();
	}

	/**
	 * Erzeugt einen B-Baum der gegebenen Ordnung
	 * 
	 * @param ordnung
	 */
	public B_Tree(int ordnung) {
		this.ordnung = ordnung;
		this.root = null;
	}

	@Override
	/**
	 * Inserts an o into the tree
	 * 
	 * @param o
	 *            to insert
	 * @return true -> if the o can be inserted false-> if the o already exists
	 *         in the tree
	 */
	public boolean insert(Integer o) {
		if (o == null)
			return false;
		else {
			if (root == null) {
				root = new BTreeNode(this.ordnung);
			}

			return root.insert(o);
		}
	}

	@Override
	/**
	 * Insert all Elements from the file"filename"
	 * @param filename
	 * @return true -> when all elements are insert
	 * 		   false-> when one or more elements aren't insert
	 */
	public boolean insert(String filename) {
		Object file;
		if (isFilePresent(filename)) {
			file = openInputFile(filename);
			while (!isEndOfInputFile(file)) {
				boolean x = insert(readInt(file));
				if (!x) {
					return false;
				}
			}
			closeInputFile(file);
			return true;
		} else {
			throw new GDIException("file does not exist");
		}

	}

	@Override
	/**
	 * Check if the element is already included
	 * @param o 
	 * @return true -> if the elements is already insert
	 * 		   false-> if not
	 */
	public boolean contains(Integer o) {
		if(o == null){
			throw new GDIException("No valid searchkey.");
		}
		
		if(root != null){
			return root.contains(o);
		}

		return false;
	}
	
	@Override
	/**
	 * Number of elements in the tree
	 * @return count of all elements in the tree
	 */
	public int size() {
		if(root != null){
			return root.size();
		}
		return 0;
	}

	@Override
	/**
	 * Determines the height of the tree.
	 * @return the height of the tree
	 */
	public int height() {
		if(root != null){
			return root.height();
		}
		return 0;
	}

	@Override
	/**
	 * Provides the largest element in the tree
	 * @return the largest element in the tree. Null when there is no element
	 */
	public Integer getMax() {
		if(root != null){
			return root.getMax();
		}
		else{
			throw new GDIException("Tree is empty");
		}
	}

	@Override
	/**
	 * Provides the smallest element in the tree
	 * @return the smallest element in the tree. Null when there is no element
	 */
	public Integer getMin() {
		if(root != null){
			return root.getMin();
		}
		else{
			throw new GDIException("Tree is empty");
		}
	}

	@Override
	/**
	 * Checks if the tree is empty (has no elements)
	 * @return true when the tree is empty, false if not
	 */
	public boolean isEmpty() {
		if(root == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	/**
	 * Adds all elements from an other tree to the current one Tree
	 * @param otherTree all elements from this tree will be inserted
	 * @return true if all elements could be inserted and false if one or more elements could not be inserted
	 */
	public void addAll(B_Tree otherTree) {
		if(otherTree.root != null){
			for(int i = 0; i<otherTree.size(); i++){
				
				Integer[] allElements = new Integer[otherTree.size()];
			
			}
			
		}

	}

	
	

	// /**
	// * Sucht nach dem gegebenen Schlüssel im Baum. Ist der Schlï¿½ssel im Baum
	// enthalten, wird
	// * das im Baum gespeicherte Objekt zurï¿½ckgegeben, andernfalls null
	// * @param key
	// * @return
	// */
	// public Integer search(Integer key) {
	// if (wurzel == null) {
	// return null;
	// }
	// return wurzel.search(key);
	// }



	
	@Override
	public void printInorder() {
		if (root != null) {
			root.printInorder();
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

	public B_Tree deepClone() {

		return null;
	}

	
	void setWurzel(BTreeNode wurzel) {
		this.root = wurzel;
	}

	public String toString() {
		if (root == null) {
			return "[leer]";
		} else {
			return root.toString();
		}
	}

}