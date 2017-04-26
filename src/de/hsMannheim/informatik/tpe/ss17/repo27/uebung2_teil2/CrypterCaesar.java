package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2;

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
		for(int i=0; i<message.length();i++){
			//print(c[i]+",");
			int umwandeln = (int) c[i] - 32 + 3;
//			print((char)umwandeln);	
			c[i]=(char)umwandeln;
		}
		String neuesWort = String.valueOf(c);	
		return neuesWort;
	}

	public String decrypt(String cypherText) {
		print("decrypt: ");
		char[] c = cypherText.toCharArray();
		for(int i=0; i<cypherText.length();i++){
//			print(c[i]);
			int umwandeln = (int) c[i] + 32 - 3;
//			print((char)umwandeln);		
			c[i]=(char)umwandeln;
		}
		String neuesWort = String.valueOf(c);	
		return neuesWort;
	}

}
