package de.hsMannheim.informatik.tpe.ss17.repo27.uebung1;

import static gdi.MakeItSimple.*;

import java.util.Arrays;

public class BTreeMenu {
	
	static BTree original; 
	static BTree tree; 
	static BTree otherTree;
	
	
	public static void main(String[] args) {
		println("Please set order");
		int order = readInt();
		
		tree = new B_Tree(order);  // BTre with orderx
		otherTree = new B_Tree(order);  // BTre with orderx
		
//		for (int i = 0; i < la.length; i++){
//			la[i] = new B_Tree(i);
//		}

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
		
		println("8: isEmpty");
		println("9: addAllFrom(BinaryTree otherTree)");
		
		println("10: BinaryTree clone");  // calls method clear
		println("11: printInorder");
		println("12: printPostorder");
		println("13: printPreorder");
		println("14: printLevelorder");		
		
		int selection = readInt();
		
		println(" Welchen Baum wollen sie Bearbeiten?");
		println(" 1 : Tree");
		println(" 2 : OtherTree");
		
		int baum = readInt();
		if(baum == 1)
			original = tree;
		else if(baum==2){
			original = otherTree;
		}else 
			println("False Value of Tree.");

		switch (selection) {

		case 1:
			println("Value to insert: ");
			int indexInsert = readInt();
			println("Element:");
			original.insert(indexInsert);
			break;
		case 2:
			println("Filename to insert: ");
			String lineInsert = readLine();
			println("Element:");
			original.insert(lineInsert);
			break;
		case 3:
			println("Value to contains: ");
			int indexContains = readInt();
			println("Element:");
			original.contains(indexContains);
			break;
		case 4:
			println("Size: ");
			println(original.size());
			break;
		case 5:
			println("Height: ");
			println(original.height());
			break;
		case 6:
			println("getMax: ");
			println(original.getMax());
			break;
		case 7:
			println("getMin: ");
			println(original.getMin());
			break;
		case 9:
			println("isEmpty: ");
			println(original.isEmpty());
			break;
//		case 10:
//			println("addAllFrom(BinaryTree otherTree): ");
//			BTree tree = new BTree(i);
//			tree.addAll(tree);
//			break;
		case 12:
			println("BinaryTree clone: ");
			println(original.deepClone());
			break;		
		case 13:
			original.printInorder();
			break;
		case 14:
			original.printPostorder();
			break;
		case 15:
			original.printPreorder();
			break;
		case 16:
			original.printLevelorder();
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
