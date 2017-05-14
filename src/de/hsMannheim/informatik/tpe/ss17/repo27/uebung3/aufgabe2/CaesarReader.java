package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.println;
import java.io.*;

public class CaesarReader extends FilterReader {

	static char buchstaben[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };
	private static int verschiebung = 0;

	public static void main(String[] args) throws IOException {
		
//		CaesarReader caesarReader = new CaesarReader(0, new FileReader("test.txt"));
//		BufferedReader br = new BufferedReader(caesarReader);
//		String zeile = "";
//
//	    do
//	    {
//	      zeile = br.readLine();
//	      System.out.println(zeile);
//	    }
//	    while (zeile != null);
//
//	    br.close();
	}

	public CaesarReader(int anzVerschiebung, Reader out) {
		super(out);
		this.verschiebung = anzVerschiebung;
	}

	public int read() throws IOException {
		int entschluesseln = super.read();
		System.out.println("Steht in datei: " + (char) entschluesseln);
		char c = (char) entschluesseln;
		if (entschluesseln == -1) {
			return -1;
		} else {
			return decrypt(c, this.verschiebung);
		}
	}

	public int read(char[] cbuf, int off, int len) throws IOException {
		int entschluesseln = super.read(cbuf, off, len);
		for (int i = 0; i < len; ++i) {
			cbuf[i] = decrypt(cbuf[i], this.verschiebung);
		}
		return entschluesseln;
	}

	public char decrypt(char a, int caesarCryptPower) {

		int pos = buchstaben.length;
		for (int i = 0; i < buchstaben.length; i++) {
			if (buchstaben[i] == a) {
				pos = i - this.verschiebung;
			}
		}

		while (pos < 0) {
			pos += buchstaben.length;
		}
		if (pos < buchstaben.length) {
			return buchstaben[pos];
		} else {
			return a;
		}

		// char decrypted = '1';
		// //check for overflow and set p with Key-power
		//// for(int i=0; i < a.length() ;i++){
		//
		// for(int p=0; p<58;p++){
		// if(a == buchstaben[p]){
		// if(p - caesarCryptPower >= 58)
		// p=p - caesarCryptPower-58;
		// else if(p - caesarCryptPower < 0)
		// p=p - caesarCryptPower+58;
		// else
		// p= p - caesarCryptPower;
		//
		// //add char to decrpyted string
		// decrypted += buchstaben[p];
		// p=100;
		// }
		// }
		//// }
		//
		//
		// return decrypted;
	}

	public char[] decrypt(char[] cypherText, int caesarCryptPower) {

		char[] decrypted = {};
		// check for overflow and set p with Key-power
		for (int i = 0; i < cypherText.length; i++) {
			char a = cypherText[i];
			for (int p = 0; p < 58; p++) {
				if (a == buchstaben[p]) {
					if (p - caesarCryptPower >= 58)
						p = p - caesarCryptPower - 58;
					else if (p - caesarCryptPower < 0)
						p = p - caesarCryptPower + 58;
					else
						p = p - caesarCryptPower;

					// add char to decrpyted string
					// decrypted += buchstaben[p];
					p = 100;
				}
			}
		}

		return decrypted;
	}

}
