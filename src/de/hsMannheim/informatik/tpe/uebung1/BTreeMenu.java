package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class BTreeMenu {
	
	 BTree la[] = new BTree[0];  // BTre with orderx
	 BTree lb[] = new BTree[0];  // BTre with orderx
	 
	public static void main(String[] args) {
		
		for (int i = 0; i < la.length; i++){
			la[i] = new B_Tree(i);
		}

		while (true) {
			makeMenu();
		}
	}

	public static void makeMenu() {

		int wl = 0; // working list per default

		println("------------------- Menü -------------------");
		println("1: set order of trees");
		println("1: insert value");  // calls method toString
		println("2: insert filename");
		println("3: contains value");
		println("4: size");
		println("5: height");
		println("6: getMax");
		println("7: getMin");
		
		println("9: isEmpty");
		println("10: addAllFrom(BinaryTree otherTree)");
		
		println("12: BinaryTree clone");  // calls method clear
		println("13: printInorder");
		println("14: printPostorder");
		println("15: printPreorder");
		println("16: printLevelorder");		

		int selection = readInt();
		BTree tree = la[wl];

		switch (selection) {
		case 1:
			println("Value for order: ");
			int indexInsert = readInt();
			println("Element:");
			tree.insert(indexInsert);
			break;
		case 1:
			println("Value to insert: ");
			int indexInsert = readInt();
			println("Element:");
			tree.insert(indexInsert);
			break;
		case 2:
			println("Filename to insert: ");
			String lineInsert = readLine();
			println("Element:");
			tree.insert(lineInsert);
			break;
		case 3:
			println("Value to contains: ");
			int indexContains = readInt();
			println("Element:");
			tree.contains(indexContains);
			break;
		case 4:
			println("Size: ");
			println(tree.size());
			break;
		case 5:
			println("Height: ");
			println(tree.height());
			break;
		case 6:
			println("getMax: ");
			println(tree.getMax());
			break;
		case 7:
			println("getMin: ");
			println(tree.getMin());
			break;
		case 9:
			println("isEmpty: ");
			println(tree.isEmpty());
			break;
//		case 10:
//			println("addAllFrom(BinaryTree otherTree): ");
//			BTree tree = new BTree(i);
//			tree.addAll(tree);
//			break;
		case 12:
			println("BinaryTree clone: ");
			println(tree.deepClone());
			break;		
		case 13:
			tree.printInorder();
			break;
		case 14:
			tree.printPostorder();
			break;
		case 15:
			tree.printPreorder();
			break;
		case 16:
			tree.printLevelorder();
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
