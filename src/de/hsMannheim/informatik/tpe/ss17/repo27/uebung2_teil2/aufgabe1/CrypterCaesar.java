package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe1;

import static gdi.MakeItSimple.*;

public class CrypterCaesar implements Crypter{
	
	static Crypter x = new CrypterCaesar();
	static String wort;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		println("Bitte geben Sie hier ihr passwort ein!");
		wort = readLine();
		String s = x.encrypt(wort);
		println(s);
		String z = x.decrypt(s);
		println(z);
	}
	
	public String encrypt(String message) {
		print("encrypt: ");
		char[] c = message.toCharArray();
		int umwandeln;
		for(int i=0; i<message.length();i++){
			if((int)c[i] == (int) 'x' || (int)c[i] == (int) 'y' || (int)c[i] == (int) 'z'){
				umwandeln = (int) c[i] - 55;
			}
			else{
				umwandeln = (int) c[i] - 29;
			}
			c[i]=(char)umwandeln;
		}
		String neuesWort = String.valueOf(c);	
		return neuesWort;
	}

	public String decrypt(String cypherText) {
		print("decrypt: ");
		char[] c = cypherText.toCharArray();
		int umwandeln;
		
		for(int i=0; i<cypherText.length();i++){
			if((int)c[i] == (int) 'A' || (int)c[i] == (int) 'B' || (int)c[i] == (int) 'C'){
				umwandeln = (int) c[i] + 55;
			}
			else{
			umwandeln = (int) c[i] + 29;
			}
			
			c[i]=(char)umwandeln;
		}
		String neuesWort = String.valueOf(c);	
		return neuesWort;
	}

}
