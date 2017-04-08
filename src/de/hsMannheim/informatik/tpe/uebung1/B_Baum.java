package de.hsMannheim.informatik.tpe.uebung1;

import TPESchramm.BTree;

public interface B_Baum {
	
	boolean insert (int o);
	boolean insert (String filename);
	boolean contains (int o);
	int size();
	int height();
	int getMax();
	int getMin();
	boolean isEmpty();
	void addAll (BTree otherTree);

	void printInorder();
	void printPostorder();
	void printPreorder();
	void printLevelorder();

}
