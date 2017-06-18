package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.BBaum;

import java.io.*;
import java.util.*;

public class B_Tree implements BTree_Interface {

	private int order;
	private BTreeNode root;

	/**
	 * constructor of BTree
	 * 
	 * @param order
	 *            number of the order
	 */
	B_Tree(int order) {
		this.order = order;
		root = new BTreeNode(order);
	}

	/**
	 * constructor of BTree
	 * 
	 * @param order
	 *            -> number of the order
	 * @param filename
	 */
	B_Tree(int order, String filename) {
		this(order);
		try {
			insert(filename);
		} catch (FileNotFoundException e) {
			System.out.println("File Does not exist!");
		}
	}

	public BTreeNode getRoot() {
		return root;
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
	public boolean insert(Comparable o) {
		Comparable ins = o;
		if (contains(ins)) {
			return false;
		}

		BTreeNode node = new BTreeNode(this.order);
		boolean temp = root.insert(ins, false, node);
		if (node.getKeys()[0] != null) {
			root = node;
		}
		return temp;
	}

	@Override
	/**
	 * Insert all Elements from the file"filename"
	 * 
	 * @param filename
	 * @return true -> when all elements are insert false-> when one or more
	 *         elements aren't insert
	 */
	public boolean insert(String filename) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return insertString(input);
	}

	public boolean insertString(String numberString) {
		boolean temp = true;
		for (int i = 0; i < numberString.length(); i++) {
			if (numberString.charAt(i) == ' ') {
				temp = temp && insert(Integer.parseInt(numberString.substring(0, i)));
				temp = temp && insertString(numberString.substring(i + 1, numberString.length()));
				i = numberString.length();
			}
		}
		return temp;
	}

	@Override
	/**
	 * Check if the element is already included
	 * 
	 * @param o
	 * @return true -> if the elements is already insert false-> if not
	 */
	public boolean contains(Comparable o) {
		return root.contains(o);
	}

	@Override
	/**
	 * delete the elemente o frpm the tree
	 * 
	 * @param o
	 *            -> element to delete
	 * @return true -> delete was successful false-> the element does not delete
	 */
	public boolean delete(Comparable o) {
		if (this.contains(o)) {
			boolean ret = root.delete(o);
			B_Tree deletedBTree = new B_Tree(this.order);
			this.root.delete(o);
			deletedBTree.addAll(root);
			this.root = deletedBTree.root;
			return ret;
		}
		return false;
	}

	@Override
	/**
	 * Number of elements in the tree
	 * 
	 * @return count of all elements in the tree
	 */
	public int size() {
		return root.getSize();
	}

	@Override
	/**
	 * Determines the height of the tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		if (isEmpty()) {
			return 0;
		} else
			return root.height();
	}

	@Override
	/**
	 * Provides the largest element in the tree
	 * 
	 * @return the largest element in the tree. Null when there is no element
	 */
	public Comparable getMax() {
		return root.getMax();
	}

	@Override
	/**
	 * Provides the smallest element in the tree
	 * 
	 * @return the smallest element in the tree. Null when there is no element
	 */
	public Comparable getMin() {
		return root.getMin();
	}

	@Override
	/**
	 * Checks if the tree is empty (has no elements)
	 * 
	 * @return true when the tree is empty, false if not
	 */
	public boolean isEmpty() {
		if (root == null || root.getKeys()[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * Adds all elements from an other tree to the current one Tree
	 * 
	 * @param otherTree
	 *            all elements from this tree will be inserted
	 * @return true if all elements could be inserted and false if one or more
	 *         elements could not be inserted
	 */
	public void addAll(B_Tree otherTree) {
		addAll(otherTree.root);
	}

	/**
	 * adds every value of otherTree to this
	 * 
	 * @param otherNode
	 *            to get insert
	 */
	public void addAll(BTreeNode otherNode) {
		for (int i = 0; i < otherNode.getChildren().length; i++) {
			if (otherNode.getChildren()[i] != null) {
				addAll(otherNode.getChildren()[i]);
			}
			if (i < otherNode.getKeys().length && otherNode.getKeys()[i] != null) {
				insert(otherNode.getKeys()[i]);
			}
		}
	}

	@Override
	/**
	 * @return prints numbers in natural order
	 */
	public void printInorder() {
		System.out.println("Inorder: ");
		root.printInorder();
		System.out.println();
	}

	@Override
	/**
	 * prints at first the lowest children of the left parttree, then the
	 * children of the right
	 */
	public void printPostorder() {
		System.out.println("Postorder: ");
		root.printPostorder();
		System.out.println();
	}

	@Override
	/**
	 * prints at first the root, then the left child, childs child,... and then
	 * the other child of the lowest parent, after that of the other ones
	 */
	public void printPreorder() {
		System.out.println("Preorder: ");
		root.printPreorder();
		System.out.println();
	}

	@Override
	/**
	 * prints nodes of tree level per level
	 */
	public void printLevelorder() {
		System.out.println("Levelorder: ");
		root.printLevelorder();
		System.out.println();
	}

	@Override
	public B_Tree deepClone() {
		if (this.root == null) {
			return null;
		} else if (this.root != null) {
			B_Tree newTree = new B_Tree(this.order);

			// return newTree.root.deepClone();
		}
		return null;
	}

}
