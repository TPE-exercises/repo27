package de.hsMannheim.informatik.tpe.ss17.repo27.uebung1;

import static gdi.MakeItSimple.*;

import java.util.*;

public class BTreeNode {
	private int order;
	private B_Tree tree;
	private BTreeNode parent;

	private Integer[] keys;
	private BTreeNode[] children;
	int maxKeys;
	int counter = 0;
	int height = 0;
	Integer maxValue;
	Integer minValue;
	boolean ret;
	boolean nodeSplit;

	public BTreeNode(int ordnung) {
		this.maxKeys = ordnung * 2 + 1;
		this.parent = null; // Vater
		this.order = ordnung; // Ordnung

		this.keys = new Integer[this.maxKeys]; // Schlï¿½ssel
		this.children = new BTreeNode[this.maxKeys + 1]; // Unterbï¿½ume
	}

	public BTreeNode getParent() {
		return parent;
	}

	Integer getKey(int i) {
		return keys[i];
	}

	BTreeNode getChild(int i) {
		return this.children[i];
	}

	public int getOrder() {
		return order;
	}

	public boolean isLeaf() {
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				return false;
			}
		}
		return true;
	}

	public boolean insert(Integer key) {
//		if (key == null) {
//			return false;
//		}
//		else if (this.keys.length == 0){
//			return false;
//		}
//		
//		for(int i=0; i<this.keys.length;i++){
//			
//			if(this.keys[i]==null){
//				this.keys[i]=key;
//				return true;
//			}
//			else{
//				if(this.keys[i].equals(key)){
//					println("Im Baum schon vorhanden");
//					return false;
//				}
//			}
//			
//		}
//		return false;
		
		
		
		ret = true;
		if (key == null) {
			return false;
		}

		else if (this.keys[0] == null){
			this.keys[0] = key;
			return true;
		}
		else{
			this.insertRecursiv(key);
			return ret;
		}
		
	}

	public void insertRecursiv(Integer key) {

		// prÃ¼fe ob vorhNDEN
		if (!this.contains(key)) {

			/*
			 * Blatt gefunden...fï¿½ge ein
			 */
			if (isLeaf()) {
				// System.out.println("insert "+key+" in "+getSchluessel());
				int i = einfuegePosition(key, keys);
				nodeSplit = this.addKey(i, key);
				ret = nodeSplit;
				
				

				/*
				 * ï¿½berprï¿½fe ob geglï¿½ttet werden muss //
				 */
				// if (keys.length > 2 * getOrder()) {
				// split();
				// }
			} else
				// Suche korrekten Teilbaum
				getTeilbaumFuer(key).insertRecursiv(key);
			;
		} 
		else
			ret = false;

	}

	public boolean contains(Integer key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals(key)) {
				System.out.println("Schluessel schon vorhanden: " + key);
				return true;
			}
			else if(isLeaf()){
				return false;
			}
		}

		return getTeilbaumFuer(key).contains(key);
	}

	/*
	 * Einfügen: erst normal Einfügen und dann splitten bis keine
	 * Überläufe
	 */
	boolean addKey(int einfuegePosition, Integer key) {
		Integer merker1;
		Integer merker2;

		merker1 = this.keys[einfuegePosition];
		this.keys[einfuegePosition] = key;
		for (int i = einfuegePosition + 1; i < keys.length; i++) {
			merker2 = keys[i];
			keys[i] = merker1;
			merker1 = merker2;

			if (!isLeaf()) {
				BTreeNode merkerKind1 = this.children[einfuegePosition + 1];
				BTreeNode merkerKind2 = null;
				for (int k = einfuegePosition + 2; k < children.length; i++) {
					merkerKind2 = children[k];
					children[k] = merkerKind1;
					merkerKind1 = merkerKind2;
				}
			}

		}

		if (keys[(order * 2) ] == null)
			return false;
		else
			return true;

	}

	int einfuegePosition(Integer key, Integer[] ls) {
		
		for(int i = 0; i<ls.length;i++){
			if (ls[i] == null) {
				return i;
			}
			else if (key < ls[i]) { // Vergleiche Key, falls kleiner gib die Position
								// zurï¿½ck
				return i;
			} 
			else{
				
			}
		}
		return 0;
//		int i = 0;
//		while (i < ls.length) { // Durchlaufe die Werteliste
//			if (ls[i] == null) {
//				return i;
//			}
//			if (key < ls[i]) { // Vergleiche Key, falls kleiner gib die Position
//								// zurï¿½ck
//				return i;
//			} else {
//				i++; // Ansonsten weiter
//			}
//		}
//		return i;
	}

	BTreeNode getTeilbaumFuer(Integer key) {
		int i = einfuegePosition(key, keys); // ï¿½berprï¿½fe die
												// Einfï¿½geposition
		return this.children[i]; // Nimm den Unterbaum an der Einfï¿½geposition
	}

	void split() {

		Integer mittelKey = this.keys[(maxKeys / 2)];
		// Hole Vater vom aktuellen Knoten als Hilfsvariable
		BTreeNode parent = getParent();

		// Falls Wurzel, muss ein neuer Knoten angelegt werden
		if (parent == null) {
			// generiere neues Objekt fï¿½r Vater
			parent = new BTreeNode(getOrder());
			// jetzt ist Vaterknoten die Wurzel
			this.tree.setWurzel(parent);
		}

		// Ueberlauf -> aufspalten (einfacher Algorithmus)
		BTreeNode b1 = new BTreeNode(getOrder());
		b1.parent = parent;

		// Kopiere Schlüssel bis Ordnung = MAX/2
		int j = 0;
		while (keys[j] < mittelKey) {
			b1.keys[j] = this.keys[j];
			j++;
		}

		// Zweiter Baum ab Ordnung MAX/2
		BTreeNode b2 = new BTreeNode(getOrder());
		b2.parent = parent;

		int k = j + 1;
		while (keys[k] > mittelKey && k <= maxKeys) {
			b2.keys[k] = this.keys[k];
			k++;
		}

		// Falls kein Blatt
		if (!isLeaf()) {
			int mittelIndex = maxKeys / 2;

			// Laufe ï¿½ber Kinder bis MAX/2 und fï¿½ge sie dem Unterbaum zu
			int m = 0;
			while (m <= mittelIndex) {
				b1.children[m] = this.children[m];
				this.children[m].parent = b1;
				m++;

			}

			int n = mittelIndex + 1;
			while (n < children.length) {
				b2.children[n] = this.children[n];
				this.children[n].parent = b2;
				n++;
			}

			// // Laufe ï¿½ber Kinder bis MAX/2 und fï¿½ge sie dem Unterbaum zu
			// for (int j = 0; j <= getOrder(); j++) {
			// BTreeNode kind = (BTreeNode) getKinder().get(j);
			// b1.getKinder().add(kind);
			// kind.parent = b1;
			// }
			//
			// // Laufe ab MAX/2 bis MAX und kopiere Kinder
			// for (int j = getOrder() + 1; j <= keys.length; j++) {
			// BTreeNode kind = (BTreeNode) getKinder().get(j);
			// b2.getKinder().add(kind);
			// kind.parent = b2;
			// }
		}

		int placeToInsert = parent.einfuegePosition(mittelKey, parent.keys);
		parent.addKey(placeToInsert, mittelKey);

		parent.children[placeToInsert] = b1;
		parent.children[placeToInsert + 1] = b2;

		// // Lï¿½sche aus Vaterknoten
		// parent.getKinder().remove(this);
		//
		// // Hole den Schlï¿½sselwert aus der Mitte
		// Integer mitte = (Integer) getKeys().get(getOrder());
		//
		// // Versuche in Vater zu integrieren
		// int k = einfuegePosition(mitte, parent.getKeys());
		// // System.out.println("Vaterknoten:\n"+vater+"k = "+k);
		// // Fï¿½ge in den Vater ein
		// parent.getKeys().addKey(k, mitte);
		// // Der Vater hat nun alten linken und rechten Teil als Sï¿½hne
		// parent.getKinder().add2(k, b1);
		// parent.getKinder().add2(k + 1, b2);

	}

	/*
	 * 
	 */
	private boolean isEmpty() {
		return (getParent() == null);
	}

	public void printValue() {
		print(" " + keys + " ");
	}

	public int size() {
		this.sizeRecursiv();
		return counter;
	}

	public void sizeRecursiv() {
		for (int i = 0; i < order * 2 && this.children[i] != null; i++) {
			if (null != this.children[i])
				this.children[i].sizeRecursiv();

			counter++;

			if (null != this.children[i + 1])
				this.children[i + 1].sizeRecursiv();
		}
	}

	public int height() {
		height = 0;
		this.heightRecursiv();
		return height;
	}

	public void heightRecursiv() {
		height++;
		if (null != this.children[0])
			this.children[0].heightRecursiv();
	}

	public Integer getMax() {
		maxValue = 0;

		this.getMaxRecursiv();

		return maxValue;
	}

	public void getMaxRecursiv() {
		boolean bol = true;
		int i = getOrder() * 2;

		if (this.isLeaf())
			for (int k = getOrder() * 2; i > 0; i--) {
				if (this.keys[k] != null) {
					if (this.keys[k] > maxValue)
						maxValue = this.keys[k];
				}

			}
		else {

			while (bol) {
				if (this.children[i + 1] != null) {
					this.getMaxRecursiv();
					bol = false;
				}
				i--;
			}

		}
	}

	public Integer getMin() {

		minValue = 0;

		this.getMinRecursiv();

		return minValue;
	}

	public void getMinRecursiv() {

		if (null != this.children[0])
			this.children[0].getMinRecursiv();
		else
			minValue = keys[0].intValue();
	}

	BTreeNode deepClone() {
		BTreeNode newNode = new BTreeNode(order);

		// Clone elements
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != null) {
				newNode.keys[i] = keys[i];
			}
		}

		// clone children
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				newNode.children[i] = children[i].deepClone();
			}
		}

		return newNode;
	}

	public void printInorder() {
		for(int i=0; i<keys.length;i++){
			if(keys[i]==null){
			print("null ");
			}
			else
			print(keys[i].intValue()+" ");
		}
		
//		for (int i = 0; i < order * 2 && this.children[i] != null; i++) {
//
//			if (null != this.children[i])
//				this.children[i].printInorder();
//
//			println(keys[i].intValue());
//			i++;
//
//			// if(null != this.kinder[i+1])
//			// this.kinder[i+1].printInorder();
//
//		}
	}

	public void printPreorder() {

		for (int i = 0; i < order * 2 && this.children[i] != null; i++) {

			println(keys[i].intValue());
			i++;

			if (null != this.children[i])
				this.children[i].printPreorder();

			// if(null != this.kinder[i+1])
			// this.kinder[i+1].printPreorder();
			//
		}
		println("-|-");
	}

	public void printPostorder() {

		for (int i = 0; i < order * 2 && this.children[i] != null; i++) {

			if (null != this.children[i])
				this.children[i].printPostorder();

			// if(null != this.kinder[i+1])
			// this.kinder[i+1].printPostorder();
			//
			println(keys[i].intValue());
			i++;
		}
		println("-|-");
	}



	public void printLevelorder(BTreeNode root, int m) {
		BTreeNode node = root;
		if (node == null)
			return;
		else {
			for (int i = 0; i < tree.height(); i++) {

				print(" ");
				printLevelorder_rec(node, i, m);
				nodeLevel++;
			}
		}
	}

	private int nodeLevel = 0;

	private void printLevelorder_rec(BTreeNode node, int level, int m) {
		if (level > 0) {
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getChild(i) != null) {
					print(getKey(i));
					printLevelorder_rec(node.getChild(i), level - 1, m);
					print(getKey(i));
				}
			}
		} else {
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getKey(i) != null) {
					print(getKey(i));
				}
			}

		}
	}


}
