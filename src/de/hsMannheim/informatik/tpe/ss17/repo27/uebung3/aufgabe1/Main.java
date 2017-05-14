package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1;

import static gdi.MakeItSimple.*;

import de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe1.myutil.*;

public class Main {

		public static void main(String[] args) throws OverflowException, UnderflowException {
			
			//userinteraction for choosing of ADT
			ADT currentADT = selectionOfADT();
			boolean menue = true;
			
			//MainMenu loop
			while (menue) {
				printMainMenue();
				int input = readInt();
				readLine();
				switch (input) {

				case (0):
					enterADT(currentADT);
					break;
					
				case (1):
					println("Das Objekt: " + currentADT.leave() + " wurde entfernt.");
					println(currentADT.toString());
					break;

				case (2):
					println("Das Erste Element der ADT ist: " + currentADT.front());
					break;

				case (3):
					if(currentADT.isEmpty()){
						println("ADT ist leer");
					} else {
						println("ADT ist nicht leer");
					}
					break;

				case (4):
					println("Die Größe der ADT ist: " + currentADT.size());
					break;

				case (5):
				currentADT = selectionOfADT();
				break;

				case (6):
					menue = false;
					println("Das Programm wurde beendet.");
					println("____________________________________________________________");
					println("____________________________________________________________");
					break;
				}
			}

		}
		
		/**
		 * menu to enter objects (integer/string) to the currentADT
		 *
		 * @param currentADT
		 * @throws OverflowException for ADT
		 */
		private static void enterADT(ADT currentADT) throws OverflowException{
			println("____________________________________________________________");
			println("Welches Objekt wollen sie einfügen?");
			println("0:   Integer         ");
			println("1:   String          ");
			println("____________________________________________________________");
		
			int input = readInt();
			readLine();
			switch (input) {
			//switch for Integer and String handling
			case (0):
				println("Welches Integer-Objekt soll eingefügt werden?");
				println("____________________________________________________________");
				Integer integerToEnter = readInt();
				readLine();
				currentADT.enter(integerToEnter);
				println("Das Integer-Objekt: " + integerToEnter + " wurde eingefügt.");
				println("");
				println("____________________________________________________________");
				println("");
				println(currentADT.toString());
				break;
			case (1):
				println("Welches String-Objekt soll eingefügt werden?");
				String stringToEnter = readLine();
				currentADT.enter(stringToEnter);
				println("Das String-Objekt: " + stringToEnter + " wurde eingefügt.");
				println("");
				println("____________________________________________________________");
				println("");
				println(currentADT.toString());
				
				break;
				
		}
		}

		/**
		 * menu for choosing the ADT the user wants to work with
		 * @return currentADT of users choice
		 */
		private static ADT selectionOfADT() {
			//userinteraction for length of ADT
			
			println("Welche länge soll ihre ADT haben?");
			int sizeDynamic = readInt();
			
			 ADT queueWithArray = new QueueArray(sizeDynamic);
			 ADT queueWithLinkedList = new QueueList(sizeDynamic);

			 ADT stackWithArray = new StackArray(sizeDynamic);
			 ADT stackWithLinkedList = new StackList(sizeDynamic);
			
			
			println("____________________________________________________________");
			println("Bitte wählen sie ein ADT."    );
			println("0:   Queue mit Array         ");
			println("1:   Queue mit LinkedList     ");
			println("2:   Stack mit Array         ");
			println("3:   Stack mit LinkedList     ");
			println("____________________________________________________________");
			
			int input = readInt();
			readLine();
			switch (input) {

			case (0):
				return queueWithArray;

			case (1):
				return queueWithLinkedList;

			case (2):
				return stackWithArray;

			case (3):
				return stackWithLinkedList;

			default:
				println("You get a QueueArray");
				return queueWithArray;

			}

		}
		
		/**
		 * printing of mainmenu 
		 */
		private static void printMainMenue() {
			println("____________________________________________________________");
			println("--------Menü--------");
			println("0:   enter           ");
			println("1:   leave          ");
			println("2:   front           ");
			println("3:   isEmpty        ");
			println("4:   size            ");
			println("5:   ADT wechseln   ");
			println("6:   Menü beenden    ");
			println("____________________________________________________________");
		}

	}
