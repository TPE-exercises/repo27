package de.hsMannheim.informatik.tpe.uebung1;

public interface BTree {
	
	
	/**
	 * Inserts an o into the tree
	 * @param o to insert
	 * @return true -> if the o can be inserted 
	 * 		   false-> if the o already exists in the tree
	 */
	boolean insert (Integer o);
	
	/**
	 * Insert all Elements from the file"filename"
	 * @param filename
	 * @return true -> when all elements are insert
	 * 		   false-> when one or more elements aren't insert
	 */
	boolean insert (String filename);
	
	/**
	 * Check if the element is already included
	 * @param o 
	 * @return true -> if the elements is already insert
	 * 		   false-> if not
	 */
	boolean contains (Integer o);
	
	/**
	 * Number of elements in the tree
	 * @return count of all elements in the tree
	 */
	int size();
	
	/**
	 * Determines the height of the tree.
	 * @return the height of the tree
	 */
	int height();
	
	/**
	 * Provides the largest element in the tree
	 * @return the largest element in the tree. Null when there is no element
	 */
	int getMax();
	
	/**
	 * Provides the smallest element in the tree
	 * @return the smallest element in the tree. Null when there is no element
	 */
	int getMin();
	
	/**
	 * Checks if the tree is empty (has no elements)
	 * @return true when the tree is empty, false if not
	 */
	boolean isEmpty();
	
	/**
	 * Adds all elements from an other tree to the current one Tree
	 * @param otherTree all elements from this tree will be inserted
	 * @return true if all elements could be inserted and false if one or more elements could not be inserted
	 */
	void addAll (B_Tree otherTree);

	/**
	 * creates a deep clone of the BTree 
	 * @return cloned tree
	 */
	B_Tree clone();

	void printInorder();
	void printPostorder();
	void printPreorder();
	void printLevelorder();
	
	
}
