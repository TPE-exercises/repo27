package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

import java.util.Arrays;
/*
public class BTreeMenu {
	
	static BTree la[] = new BTree[3];  // array with 3 linked lists

	public static void main(String[] args) {
		
		for (int i = 0; i < la.length; i++){
			la[i] = new BTree(i);
		}

		while (true) {
			makeMenu();
		}
	}

	public static void makeMenu() {

		int wl = 0; // working list per default

		println("------------------- Menü -------------------");
		println("1: insert value");  // calls method toString
		println("2: insert filename");
		println("3: contains value");
		println("4: size");
		println("5: height");
		println("6: getMax");
		println("7: getMin");
		println("8: remove value");
		println("9: isEmpty");
		println("10: addAllFrom(BinaryTree otherTree)");
		println("11: addAllTo(BinaryTree otherTree)");
		println("12: BinaryTree clone");  // calls method clear
		println("13: printInorder");
		println("14: printPostorder");
		println("15: printPreorder");
		println("16: printLevelorder");		

		int selection = readInt();
		BTree list = la[wl];

		switch (selection) {
		case 1:
			println("Value to insert: ");
			int indexInsert = readInt();
			println("Element:");
			list.insert(indexInsert);
			break;
		case 2:
			println("Filename to insert: ");
			String lineInsert = readLine();
			println("Element:");
			list.insert(lineInsert);
			break;
		case 3:
			println("Value to contains: ");
			int indexContains = readInt();
			println("Element:");
			list.contains(indexContains);
			break;
		case 4:
			println("Size: ");
			println(list.size());
			break;
		case 5:
			println("Height: ");
			println(list.height());
			break;
		case 6:
			println("getMax: ");
			println(list.getMax());
			break;
		case 7:
			println("getMin: ");
			println(list.getMin());
			break;
		case 8:
			println("Value to remove: ");
			int indexRemove = readInt();
			println(list.remove(indexRemove));
			break;
		case 9:
			println("isEmpty: ");
			println(list.isEmpty());
			break;
		case 10:
			println("addAllFrom(BinaryTree otherTree): ");
			BTree tree = new BTree(i);
			list.addAllFrom(tree);
			break;
		case 11:
			println("addAllTo(BinaryTree otherTree): ");
			BTree tree2 = new BTree(i);
			list.addAllTo(tree2);
			break;
		case 12:
			println("BinaryTree clone: ");
			println(list.clone());
			break;		
		case 13:
			list.printInorder();
			break;
		case 14:
			list.printPostorder();
			break;
		case 15:
			list.printPreorder();
			break;
		case 16:
			list.printLevelorder();
			break;
		default:
			println("not a valid operation code");
			break;
		}
		;
		println();
		readLine();

	}
}

*/