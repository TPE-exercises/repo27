package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.BBaum;

import java.util.*;

public class BTreeInterator implements Iterator<Comparable> {

	private B_Tree tree;
	private Comparable key;

	BTreeInterator(B_Tree tree) {
		this.tree = tree;
		this.key = tree.getMin();
	}

	public Comparable getValue() {
		return this.key;
	}

	@Override
	public boolean hasNext() {
		if (key == null) {
			return false;
		}
		return (tree.getMax().compareTo(key) > 0);
	}

	@Override
	public Comparable next() {
		if (hasNext()) {
			key = tree.getRoot().next(key);
			return key;
		} else {
			System.out.println("Nothing next.");
		}
		return null;
	}

	@Override
	public void remove() {
		if (key == null) {
			System.out.println("Nothing to remove.");
			return;
		}
		Comparable safer = key;
		boolean hadNext;
		if (hasNext()) {
			key = tree.getRoot().next(key);
			hadNext = true;
		} else {
			hadNext = false;
		}
		tree.delete(safer);
		System.out.println("Removed: " + safer);
		if (!hadNext) {
			key = tree.getMax();
		}

	}

}
