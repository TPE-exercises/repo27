package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.BBaum;

import static gdi.MakeItSimple.println;

import java.io.*;

public abstract class BTreeMenu {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int ordnung;
		do {
			System.out.println("Please set order: ");
			ordnung = Integer.parseInt(bf.readLine().trim());
		} while (ordnung < 1);

		B_Tree tree = new B_Tree(ordnung);
		int insertValue = 0;
		String inpstr;
		
		while (true) {
			// print Menue
			System.out.println();
			System.out.println("1:  insert value");
			System.out.println("2:  insert filename");
			System.out.println("3:  contains valu");
			System.out.println("4:  size");
			System.out.println("5:  height");
			System.out.println("6:  getMax");
			System.out.println("7:  getMin");
			System.out.println("8:  is Empty");
			System.out.println("9:  addAllFrom(BinaryTree otherTree)");
			System.out.println("10: delete number");
			System.out.println("11: iterate");
			System.out.println("12: Print Inorder");
			System.out.println("13: Print Postorder");
			System.out.println("14: Print Preorder");
			System.out.println("15: Print Levelorder");

			int input = Integer.parseInt(bf.readLine().trim());
			switch (input) {

			case (1):
				System.out.print("Value to insert: ");
				insertValue = Integer.parseInt(bf.readLine().trim());
				if (tree.insert(insertValue)) {
					System.out.println("insertion successfull: " + insertValue);
				} else {
					System.out.println("Failed");
				}
				break; // insert number

			case (2):
				System.out.print("File to insert: ");
				System.out.println();
				inpstr = bf.readLine();
				if (tree.insert(inpstr)) {
					System.out.println("insertion successfull");
				} else {
					System.out.println("Failed");
				}
				break; // insert File

			case (3):
				System.out.print("Number to search for: ");
				insertValue = Integer.parseInt(bf.readLine().trim());
				if (tree.contains(insertValue)) {
					System.out.println("Tree contains " + insertValue);
				} else {
					System.out.println("Tree doesn't contain " + insertValue);
				}
				break; // Contains
			case (4):
				System.out.println("Size: " + tree.size());
				break; // Size
			case (5):
				System.out.println("Height: " + tree.height());
				break; // Height
			case (6):
				System.out.println("getMax: " + tree.getMax());
				break; // Biggest Number
			case (7):
				System.out.println("getMin: " + tree.getMin());
				break; // Smallest Number
			case (8):
				if (tree.isEmpty()) {
					System.out.println("Tree is empty");
				} else {
					System.out.println("Tree isn't empty");
				}
				break; // insert number
			// case (9):
			// println("addAll(BinaryTree otherTree): ");
			// BTree tree = new BTree(i);
			// tree.addAll(tree);
			// break;
			case (10):
				System.out.print("Number to delete:");
				int toDelete = Integer.parseInt(bf.readLine().trim());
				boolean ret = tree.delete(toDelete);
				if (ret) {
					System.out.println("Success: " + toDelete + " got deleted.");
				} else {
					System.out.println("Failed");
				}
				break; // delete
			case (11):
				iteratorMenu(tree);
				break; // iterate
			case (12):
				tree.printInorder();
				break; // printInorder
			case (13):
				tree.printPostorder();
				break; // printPostorder
			case (14):
				tree.printPreorder();
				break; // printPreorder
			case (15):
				tree.printLevelorder();
				break; // printLevelorder
			}
		}
	}

	private static void iteratorMenu(B_Tree tree) {
		BTreeInterator bti = new BTreeInterator(tree);

		int input = 0;
		boolean endIterator = false;

		while (!endIterator) {
			printIteratorMenu(bti);
			try {
				input = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine().trim());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}

			switch (input) {
			case (0):
				if (bti.hasNext()) {
					System.out.println("hasNext == true");
				} else {
					System.out.println("hasNext == false");
				}
				break;
			case (1):
				Comparable n = (Comparable) bti.next();
				System.out.println("Next: " + n);
				break;
			case (2):
				bti.remove();
				break;
			case (3):
				endIterator = true;
				break;
			}
		}

	}

	private static void printIteratorMenu(BTreeInterator bbi) {
		System.out.println();
		System.out.println("Current value: " + bbi.getValue());
		System.out.println("0: hasNext");
		System.out.println("1: next");
		System.out.println("2: remove");
		System.out.println("3: Stop iterator");
	}

}
