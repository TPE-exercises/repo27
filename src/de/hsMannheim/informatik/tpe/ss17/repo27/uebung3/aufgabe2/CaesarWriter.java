package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarWriter extends FilterWriter {

	static char buchstaben[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö', 'ü' };

	public static void main(String[] args) throws IOException {
		
		CaesarWriter cw;
		cw = new CaesarWriter(5, new FileWriter("test.txt"));
//		cw.write(65);
//		cw.write(90);
//		cw.newLine();
		String x = "H";
		cw.write(x,0,x.length());
		cw.close();
	}

	private int verschiebung;

	public CaesarWriter(int anzVerschiebung, Writer out) {
		super(out);
		this.verschiebung = anzVerschiebung;
	}

	public void write(int c) throws IOException {
		char x = this.encrypt((char) c, this.verschiebung);
		super.write(x);
	}

	public void write(char[] c, int off, int len) throws IOException {
		char [] x  = this.encrypt(c, this.verschiebung);
		for (int i = 0; i < len; ++i) {
			write(c[off + i]);
		}
	}

	public void write(String str, int off, int len) throws IOException {
		String x = this.encrypt(str, this.verschiebung);
		write(str.toCharArray(), off, len);
	}

	public static char encrypt(char a, int caesarCryptPower) {

		// String encrypted = "";

		// for (int i = 0; i < message.length(); i++) {
		// char a = message.charAt(i);

		for (int p = 0; p < 58; p++) {
			if (a == buchstaben[p]) {
				// check for overflow and set p with Key-power
				if (p + caesarCryptPower >= 58)
					p = p + caesarCryptPower - 58;
				else if (p + caesarCryptPower < 0)
					p = p + caesarCryptPower + 58;
				else
					p = p + caesarCryptPower;

				// add char to encrpyted string
				a = buchstaben[p];

				println(a);
				p = 100;
			}
		}
		// }

		return a;
	}

	public char[] encrypt(char[] message, int caesarCryptPower) {
		char[] encrypted = {};
		for (int i = 0; i < message.length; i++) {
			char a = message[i];

			for (int p = 0; p < 58; p++) {
				if (a == buchstaben[p]) {
					// check for overflow and set p with Key-power
					if (p + caesarCryptPower >= 58)
						p = p + caesarCryptPower - 58;
					else if (p + caesarCryptPower < 0)
						p = p + caesarCryptPower + 58;
					else
						p = p + caesarCryptPower;

					// add char to encrpyted string
				//	encrypted[i] += buchstaben[p];

				//	println(encrypted[i]);
					p = 100;
				}
			}
		}

		return encrypted;
	}

	public String encrypt(String message, int caesarCryptPower) {
		String encrypted = "";
		for (int i = 0; i < message.length(); i++) {
			char a = message.charAt(i);

			for (int p = 0; p < 26; p++) {
				if (a == buchstaben[p]) {
					// check for overflow and set p with Key-power
					if (p + caesarCryptPower >= 58)
						p = p + caesarCryptPower - 58;
					else if (p + caesarCryptPower < 0)
						p = p + caesarCryptPower + 58;
					else
						p = p + caesarCryptPower;

					// add char to encrpyted string
					encrypted += buchstaben[p];

					println(encrypted);
					p = 100;
				}
			}
		}

		return encrypted;
	}

}
