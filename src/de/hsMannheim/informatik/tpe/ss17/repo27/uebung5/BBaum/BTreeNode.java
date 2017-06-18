package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.BBaum;

import java.util.*;

public class BTreeNode {

	private int maxValues;
	private Comparable[] keys;
	private BTreeNode[] children;
	private BTreeNode parent = null;

	BTreeNode(int order) {
		maxValues = order * 2;
		keys = new Comparable[maxValues + 1];
		children = new BTreeNode[maxValues + 2];
	}

	BTreeNode(int order, BTreeNode parent) {
		this(order);
		this.parent = parent;
	}

	public Comparable[] getKeys() {
		return keys;
	}

	public BTreeNode[] getChildren() {
		return children;
	}

	/**
	 * @return amount of values in nodes
	 */
	public int getSize() {
		int sum = 0;
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				sum++;
			}
		}
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				sum += children[i].getSize();
			}
		}
		return sum;
	}

	/**
	 * @param value
	 *            to search in the pointer
	 * @return position of pointer with the "value"
	 */
	private int getInsertPosition(Comparable value) {
		for (int i = 0; i < maxValues + 1; i++) {
			if (children[i].keys[0] == value) {
				return i;
			}
		}
		return -1;
	}

	// methods

	/**
	 * adds new pointer
	 * 
	 * @param node
	 *            to insert
	 */
	public void addPosition(BTreeNode toInsert) {
		for (int i = 0; i < maxValues + 2; i++) {
			if (children[i] == null) {
				children[i] = toInsert;
				sortPosition();
				return;
			}
		}
	}

	/**
	 * 
	 * @return true if one value too much in node
	 */
	private boolean isFull() {
		if (keys[maxValues] != null)
			return true;
		else
			return false;
	}

	/**
	 * split the node, mid get inserted in parent, parent gets new pointer
	 * 
	 * @param node
	 *            dummy, if there is no parent, it becomes new root
	 * @return null, if there was an parent before, else return node
	 */
	public BTreeNode burst(BTreeNode dummy) {
		int mid = maxValues / 2;
		if (parent != null) {
			// if there is already a parent, the full node gets split
			BTreeNode leftNode = new BTreeNode(maxValues / 2, parent);
			BTreeNode rightNode = new BTreeNode(maxValues / 2, parent);
			// add values to nodes
			for (int i = 0; i < mid; i++) {
				leftNode.insert(keys[i], false, dummy);
			}
			for (int i = mid + 1; i < maxValues + 1; i++) {
				rightNode.insert(keys[i], false, dummy);
			}
			// add pointer to new nodes
			for (int i = 0; i < maxValues + 2; i++) {
				if (children[i] == null) {
					i = maxValues + 2;
				} else if (children[i].keys[0].compareTo(keys[mid]) < 0) {
					leftNode.addPosition(children[i]);
					children[i].parent = leftNode;
				} else {
					rightNode.addPosition(children[i]);
					children[i].parent = rightNode;
				}
			}
			int placeForLeft = parent.getInsertPosition(keys[0]);
			if (placeForLeft < 0) {
				System.out.println("Fehler bei: " + keys[0]);
			}
			parent.children[placeForLeft] = leftNode;
			parent.addPosition(rightNode);
			parent.insert(keys[mid], true, dummy);

		} else {
			// if there is no parent, node becomes the new root
			BTreeNode leftNode = new BTreeNode(maxValues / 2, dummy);
			BTreeNode rightNode = new BTreeNode(maxValues / 2, dummy);
			// add values to new nodes
			for (int i = 0; i < mid; i++) {
				leftNode.insert(keys[i], false, dummy);
			}
			for (int i = mid + 1; i < maxValues + 1; i++) {
				rightNode.insert(keys[i], false, dummy);
			}
			// add pointer to new nodes
			for (int i = 0; i < maxValues + 2; i++) {
				if (children[i] == null) {
					i = maxValues + 2;
				} else if (children[i].keys[0].compareTo(keys[mid]) < 0) {
					leftNode.addPosition(children[i]);
					children[i].parent = leftNode;
				} else {
					rightNode.addPosition(children[i]);
					children[i].parent = rightNode;
				}
			}

			dummy.insert(keys[mid], false, dummy);
			dummy.children[0] = leftNode;
			dummy.children[1] = rightNode;
			return dummy;
		}
		return null;
	}

	/**
	 * @param to
	 *            search Integer o
	 * @return true, if node or nodes under it contain o
	 */

	public boolean contains(Comparable o) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null && o.compareTo(keys[i]) == 0) {
				return true;
			} else if (keys[i] == null || o.compareTo(keys[i]) < 0 || i == keys.length - 1) {
				if (children[i] != null) {
					return children[i].contains(o);
				}
			}
		}
		return false;
	}

	private Comparable searchInParentsForNext(Comparable value) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null && (keys[i].compareTo(value) > 0)) {
				return keys[i];
			}
		}
		if (parent != null) {
			return parent.searchInParentsForNext(value);
		}
		return null;
	}

	private Comparable nextComparable(Comparable value) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == value) {
				if (children[i + 1] != null) {
					return children[i + 1].getMin();
				} else if (i < keys.length - 1 && keys[i + 1] != null) {
					return keys[i + 1];
				} else if (parent != null) {
					return parent.searchInParentsForNext(value);
				}

			}
		}
		return null;
	}

	public Comparable next(Comparable value) {
		for (int i = 0; i < this.keys.length; i++) {
			if (keys[i] != null && value.compareTo(keys[i]) == 0) {
				return nextComparable(value);
			} else if ((keys[i] == null || keys[i].compareTo(value) > 0) && children[i] != null) {
				return children[i].next(value);
			}
		}
		return children[children.length - 1].next(value);
	}

	/**
	 * sort pointer of a node with insertionsort
	 */
	private void sortPosition() {
		for (int i = maxValues; i > 0; i--) {
			if (children[i] != null && children[i - 1].keys[0].compareTo(children[i].keys[0]) > 0) {
				BTreeNode temp = children[i - 1];
				children[i - 1] = children[i];
				children[i] = temp;
			}
		}
	}

	/**
	 * 
	 * @param values2
	 *            gets inserted
	 * @param burst
	 *            if true: forced to insert in this node
	 * @param node
	 *            dummy node, if there is no parent, it becomes the new root
	 * @return true if it was succesfull, false if it wasnt succesfull
	 */
	public boolean insert(Comparable values2, boolean burst, BTreeNode node) {
		if (children[0] == null || burst) {
			for (int i = 0; i < maxValues + 1; i++) {
				if (keys[i] == null) {
					keys[i] = values2;
					insertionSort();
					if (isFull()) {
						burst(node);
						return true;
					}
					return true;
				}
			}
		} else {
			for (int i = 0; i < maxValues + 1; i++) {
				if (keys[i] == null || keys[i].compareTo(values2) > 0) {
					return children[i].insert(values2, false, node);
				}
			}
		}
		return false;
	}

	/**
	 * sorts values by insertion sort
	 */
	public void insertionSort() {
		int lastInsertion = maxValues;
		for (int i = 0; i < maxValues + 1; i++) {
			if (keys[i] == null) {
				lastInsertion = i - 1;
				i = maxValues + 1;
			}
		}
		for (int i = lastInsertion; i > 0; i--) {
			if (keys[i].compareTo(keys[i - 1]) < 0) {
				Comparable temp = keys[i];
				keys[i] = keys[i - 1];
				keys[i - 1] = temp;
			} else
				return;
		}

	}

	/**
	 * @return values of node as a String
	 */
	public String toString() {
		String ret = "(";
		for (int i = 0; i < maxValues; i++) {
			if (keys[i] != null) {
				ret = ret + keys[i] + " ";
			}
		}
		ret = ret + ")";
		return ret;
	}

	/**
	 * 
	 * @return max Value
	 */
	public Comparable getMax() {
		if (children[0] != null) {
			for (int i = children.length - 1; i >= 0; i--) {
				if (children[i] != null) {
					return children[i].getMax();
				}
			}
		} else {
			for (int i = keys.length - 1; i >= 0; i--) {
				if (keys[i] != null) {
					return keys[i];
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @return min Value
	 */
	public Comparable getMin() {
		if (children[0] != null) {
			return children[0].getMin();
		} else {
			if (keys[0] != null) {
				return keys[0];
			}
		}
		return null;
	}

	/**
	 * @return level of node
	 */
	public int height() {
		if (children[0] == null) {
			return 1;
		} else {
			return 1 + children[0].height();
		}
	}

	public void printLevelorder() {
		for (int i = 0; i < height(); i++) {
			printLevel(i);
			System.out.println();
		}
	}

	public void printLevel(int lvl) {
		if (lvl == 0) {
			System.out.print(toString());
		} else {
			for (int i = 0; i < children.length; i++) {
				if (children[i] != null) {
					children[i].printLevel(lvl - 1);
				}
			}
		}
	}

	public void printInorder() {
		System.out.print("(");
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				children[i].printInorder();
			}
			if (i < keys.length && keys[i] != null) {
				System.out.print(keys[i] + " ");
			}
		}
		System.out.print(")");
	}

	public void printPostorder() {
		System.out.print("(");
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				children[i].printPostorder();
			}
		}
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				System.out.print(keys[i] + " ");
			}
		}
		System.out.print(")");
	}

	public void printPreorder() {
		System.out.print("(");
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				System.out.print(keys[i] + " ");
			}
		}
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				children[i].printPreorder();
			}
		}
		System.out.print(")");
	}

	public boolean delete(Comparable o) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null && o.compareTo(keys[i]) == 0) {
				keys[i] = null;
				return true;
			} else if (keys[i] == null || o.compareTo(keys[i]) < 0 || i == keys.length - 1) {
				if (children[i] != null) {
					return children[i].delete(o);
				}
			}
		}
		return false;
	}
}
