package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarMenue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Bitte geben Sie ihr Wort ein!");
		String eingabe = readLine();

		System.out.println("Bitte geben Sie nun die Anzahl der Verschiebung an!");
		int verschieben = readInt();
		
		
		String fileName = "encrypt.txt";
		
		CaesarWriter caesarWriter  = new CaesarWriter(verschieben, new FileWriter(fileName));
		CaesarReader caesarReader = new CaesarReader(verschieben, new FileReader(fileName));
		System.out.println("Verschlüsselt:");
//		caesarWriter.write(eingabe, 0, eingabe.length());
//		caesarWriter.close();
		char [] cbuf = new char[eingabe.length()];
		caesarReader.read(cbuf);
		caesarReader.close();
		
		String entschluesselt = new String(cbuf);
		System.out.println("Entschlüsselt: " + entschluesselt);
	}

}
