package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

import java.util.*;

public class BTreeNode {
	private int ordnung;
	private B_Tree baum;
	private BTreeNode vater;
//	private BTreeNode linksNode;
//	private BTreeNode rechtsNode;
	private Integer[] keys;
	private BTreeNode[] kinder;
	int maxSchluessel;
	int counter = 0;
	int height = 0;

	boolean ret;
	boolean nodeSplit;

	public BTreeNode(B_Tree baum, BTreeNode vater, int ordnung) {
		this.maxSchluessel = ordnung * 2 + 1;
		this.baum = baum; // this
		this.vater = vater; // Vater
		this.ordnung = ordnung; // Ordnung

		this.keys = new Integer[this.maxSchluessel]; // Schl�ssel
		this.kinder = new BTreeNode[this.maxSchluessel + 1]; // Unterb�ume
	}

	public BTreeNode getVater() {
		return vater;
	}

	Integer[] getSchluessel() {
		return keys;
	}

	BTreeNode getKind(int i) {
		return this.kinder[i];
	}

	public int getOrdnung() {
		return ordnung;
	}

	public boolean istBlatt() {
		for (int i = 0; i < kinder.length; i++) {
			if (kinder[i] != null) {
				return false;
			}
		}
		return true;
	}

	
	
	public boolean insert(Integer key) {

		ret = true;
		if (key == null) {
			return false;
		}

		if (this.keys[0] == null)
			this.keys[0] = key;

		this.insertRekursiv(key);

		return ret;
	}

	public void insertRekursiv(Integer key) {

		// prüfe ob vorhNDEN
		if (!this.contains(key)) {

			/*
			 * Blatt gefunden...f�ge ein
			 */
			if (istBlatt()) {
				// System.out.println("insert "+key+" in "+getSchluessel());
				int i = einfuegePosition(key, keys);
				nodeSplit = this.addInBlatt(i, key);

				if (nodeSplit) {
					this.split();
				}

				/*
				 * �berpr�fe ob gegl�ttet werden muss
				 */
				if (keys.length > 2 * getOrdnung()) {
					split();
				}
			} else
				// Suche korrekten Teilbaum
				getTeilbaumFuer(key).insertRekursiv(key);
			;
		} else
			ret = false;

	}

	
	public String toString() {
		int level = -1;
		BTreeNode k = this;
		while (k != null) {
			level++;
			k = k.vater;
		}
		char[] a = new char[level * 3];
		Arrays.fill(a, ' ');
		String s = new String(a);
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		for (Iterator it = keys.iterator(); it.hasNext();) {
			sb.append(it.next());
			sb.append(" ");
		}
		sb.append("\n");
		for (Iterator it = kinder.iterator(); it.hasNext();) {
			sb.append(s);
			sb.append(it.next());
			// sb.append("\n");
		}
		return sb.toString();
	}

	/* zu implementierende Methoden */

	public Integer search(Integer key) {
		int idx = keys.indexOf(key);
		if (idx >= 0) {
			return (Integer) keys.get(idx); // Gibt das Element zur�ck
		}
		// Wert nicht gefunden, mache weiter
		if (istBlatt()) {
			return null; // Blatt..habe keine Werte mehr
		}
		BTreeNode kind = getTeilbaumFuer(key); // Suche im korrekten Unterbaum
		return kind.search(key); // startet rekursive Suche und gibt Wert
									// zur�ck
	}

	public boolean contains(Integer key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) {
				System.out.println("Schluessel schon vorhanden: " + key);
				return true;
			}

		}
		return false;
	}

	/*
	 * Einf�gen: erst normal Einf�gen und dann splitten bis keine
	 * �berl�ufe
	 */
	boolean addInBlatt(int einfuegePosition, Integer key) {
		int merker1;
		int merker2;
		merker1 = this.keys[einfuegePosition];
		this.keys[einfuegePosition] = key;
		for (int i = einfuegePosition + 1; i < keys.length; i++) {
			merker2 = keys[i];
			keys[i] = merker1;
			merker1 = merker2;
		}

		if (keys[(ordnung * 2) + 1] == null)
			return false;
		else
			return true;

	}

	int einfuegePosition(Integer key, Integer[] ls) {
		int i = 0;
		while (i < ls.length) { // Durchlaufe die Werteliste
			if (ls[i] == null) {
				return i;
			}
			if (key < ls[i]) { // Vergleiche Key, falls kleiner gib die Position
								// zur�ck
				return i;
			} else {
				i++; // Ansonsten weiter
			}
		}
		return i;
	}

	BTreeNode getTeilbaumFuer(Integer key) {
		int i = einfuegePosition(key, keys); // �berpr�fe die
												// Einf�geposition
		return this.kinder[i]; // Nimm den Unterbaum an der Einf�geposition
	}

	void split() {

		int mittelKey = this.keys[((getOrdnung() * 2 + 1) / 2)];
		// Hole Vater vom aktuellen Knoten als Hilfsvariable
		BTreeNode vater = getVater();

		// Falls Wurzel, muss ein neuer Knoten angelegt werden
		if (isEmpty()) {
			// generiere neues Objekt f�r Vater
			vater = new BTreeNode(this.baum, null, getOrdnung());
			// jetzt ist Vaterknoten die Wurzel
			this.baum.setWurzel(vater);
		}

		// Ueberlauf -> aufspalten (einfacher Algorithmus)
		BTreeNode b1 = new BTreeNode(this.baum, vater, getOrdnung());

		// Kopiere Schl�ssel bis Ordnung = MAX/2
		int j = 0;
		while (keys[j] < mittelKey) {
			b1.keys[j] = this.keys[j];
			j++;
		}

		// Zweiter Baum ab Ordnung MAX/2
		BTreeNode b2 = new BTreeNode(this.baum, vater, getOrdnung());

		int k = 0;
		while (keys[k] < mittelKey) {
			b2.keys[k] = this.keys[k];
			k++;
		}

		// Falls kein Blatt
		if (!istBlatt()) {
			int mittelIndex = (getOrdnung() * 2 + 1) / 2;

			// Laufe �ber Kinder bis MAX/2 und f�ge sie dem Unterbaum zu
			int m = 0;
			while (m <= mittelIndex) {
				b1.kinder[m] = this.kinder[m];
				m++;

			}

			int n = mittelIndex + 1;
			while (n < kinder.length) {
				b2.kinder[n] = this.kinder[n];
				n++;
			}

			// Laufe �ber Kinder bis MAX/2 und f�ge sie dem Unterbaum zu
			for (int j = 0; j <= getOrdnung(); j++) {
				BTreeNode kind = (BTreeNode) getKinder().get(j);
				b1.getKinder().add(kind);
				kind.vater = b1;
			}

			// Laufe ab MAX/2 bis MAX und kopiere Kinder
			for (int j = getOrdnung() + 1; j <= keys.length; j++) {
				BTreeNode kind = (BTreeNode) getKinder().get(j);
				b2.getKinder().add(kind);
				kind.vater = b2;
			}
		}

		// L�sche aus Vaterknoten
		vater.getKinder().remove(this);

		// Hole den Schl�sselwert aus der Mitte
		Integer mitte = (Integer) getSchluessel().get(getOrdnung());

		// Versuche in Vater zu integrieren
		int k = einfuegePosition(mitte, vater.getSchluessel());
		// System.out.println("Vaterknoten:\n"+vater+"k = "+k);
		// F�ge in den Vater ein
		vater.getSchluessel().addInBlatt(k, mitte);
		// Der Vater hat nun alten linken und rechten Teil als S�hne
		vater.getKinder().add(k, b1);
		vater.getKinder().add(k + 1, b2);

	}

	/*
	 * 
	 */
	private boolean isEmpty() {
		return getVater() == null;
	}
	

	public void printValue() {
		print(" " + keys + " ");
	}



	public int size() {
		this.sizeRecursiv();
		return counter;
	}

	public void sizeRecursiv() {
		for (int i = 0; i < ordnung * 2 && this.kinder[i] != null; i++) {
			if (null != this.kinder[i])
				this.kinder[i].sizeRecursiv();

			counter++;

			if (null != this.kinder[i + 1])
				this.kinder[i + 1].sizeRecursiv();
		}
	}

	public int height() {
		height = 0;
		this.heightRecursiv();
		return height;
	}

	public void heightRecursiv() {
		height++;
		if (null != this.kinder[0])
			this.kinder[0].heightRecursiv();
	}

	public int getMax() {

		return 0;
	}

	public void getMaxRecursiv() {
		//set var to max
		if(null != this.kinder[(getOrdnung()*2)+1]) 
		this.kinder[(getOrdnung()*2)+1].heightRecursiv();
	 
	}

	public int getMin() {
		if (this.kinder[0] == null)
			return this.keys[0];
		else
			return 0;
	}

	public void getMinRecursiv() {
		//set var to min
		
		if(null != this.kinder[0]) 
		this.kinder[0].heightRecursiv();
	}
	
	BTreeNode deepClone() {
		BTreeNode newNode = new BTreeNode(null , null , ordnung);
		
		//Clone elements
		for(int i = 0; i< keys.length; i++) {
			if(keys[i] != null) {
				newNode.keys[i] = keys[i];
			}
		}
		
		//clone children
		for(int i = 0; i < kinder.length; i++) {
			if(kinder[i] != null) {
				newNode.kinder[i] = kinder[i].deepClone();
			}
		}
		
		return newNode;
	}

	
	public void printInorder() {

		for (int i = 0; i < ordnung * 2 && this.kinder[i] != null; i++) {

			if (null != this.kinder[i])
				this.kinder[i].printInorder();

			println(keys[i].intValue());
			i++;

			// if(null != this.kinder[i+1])
			// this.kinder[i+1].printInorder();

		}

	}

	public void printPreorder() {

		for (int i = 0; i < ordnung * 2 && this.kinder[i] != null; i++) {

			println(keys[i].intValue());
			i++;

			if (null != this.kinder[i])
				this.kinder[i].printPreorder();

			// if(null != this.kinder[i+1])
			// this.kinder[i+1].printPreorder();
			//
		}
		println("-|-");
	}

	public void printPostorder() {

		for (int i = 0; i < ordnung * 2 && this.kinder[i] != null; i++) {

			if (null != this.kinder[i])
				this.kinder[i].printPostorder();

			// if(null != this.kinder[i+1])
			// this.kinder[i+1].printPostorder();
			//
			println(keys[i].intValue());
			i++;
		}
		println("-|-");
	}

	public void printLevelorder() {

		for (int i = 0; i < ordnung * 2 && this.kinder[i] != null; i++) {

			// if(null != this.kinder[i])
			// this.kinder[i].printLevelorder();
			//
			//
			// println(keys[i].intValue());
			// i++;
			//
			// if(null != this.kinder[i])
			// this.kinder[i].printLevelorder();
			//
		}
		println("-|-");
	}
}