package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.BBaum;

import java.io.*;

public interface BTree_Interface {

	/**
	 * Inserts an o into the tree
	 * 
	 * @param o
	 *            to insert
	 * @return true -> if the o can be inserted false-> if the o already exists
	 *         in the tree
	 */
	boolean insert(Comparable o);

	/**
	 * @param filename
	 *            of file to insert
	 * 
	 * @return boolean, true if insertion was successful
	 * @throws FileNotFoundException
	 */
	boolean insert(String filename) throws FileNotFoundException;

	/**
	 * Check if the element is already included
	 * 
	 * @param o
	 * @return true -> if the elements is already insert false-> if not
	 */
	boolean contains(Comparable o);

	/**
	 * Number of elements in the tree
	 * 
	 * @return count of all elements in the tree
	 */
	int size();

	/**
	 * Determines the height of the tree.
	 * 
	 * @return the height of the tree
	 */
	int height();

	/**
	 * Provides the largest element in the tree
	 * 
	 * @return the largest element in the tree. Null when there is no element
	 */
	Comparable getMax();

	/**
	 * Provides the smallest element in the tree
	 * 
	 * @return the smallest element in the tree. Null when there is no element
	 */
	Comparable getMin();

	/**
	 * Checks if the tree is empty (has no elements)
	 * 
	 * @return true when the tree is empty, false if not
	 */
	boolean isEmpty();

	/**
	 * Adds all elements from an other tree to the current one Tree
	 * 
	 * @param otherTree
	 *            all elements from this tree will be inserted
	 * @return true if all elements could be inserted and false if one or more
	 *         elements could not be inserted
	 */
	void addAll(B_Tree otherTree);

	/**
	 * creates a deep clone of the BTree
	 * 
	 * @return cloned tree
	 */
	B_Tree deepClone();

	/**
	 * removes Integer
	 * 
	 * @param o
	 * @return
	 */
	boolean delete(Comparable o);

	/**
	 * @return prints numbers in natural order
	 */
	void printInorder();

	/**
	 * prints at first the lowest children of the left parttree, then the
	 * children of the right
	 */
	void printPostorder();

	/**
	 * prints at first the root, then the left child, childs child,... and then
	 * the other child of the lowest parent, after that of the other ones
	 */
	void printPreorder();

	/**
	 * prints nodes of tree level per level
	 */
	void printLevelorder();

}
