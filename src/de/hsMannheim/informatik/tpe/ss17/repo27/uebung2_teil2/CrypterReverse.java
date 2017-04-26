package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2;

import static gdi.MakeItSimple.*;

public class CrypterReverse implements Crypter{

	static Crypter x = new CrypterCaesar();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		println("Bitte geben Sie hier ein Wort ein!");
		String s = readLine();
		
		println(umkehr(s));
	}
	
	public static String umkehr(String message){
		println("Umgekehrt: ");
		char[] c = message.toCharArray();
		char[]neu = new char [message.length()+1];
		
		for(int i=c.length-1; i>=0;){
			for(int j=0; j<=c.length-1;j++){
				neu[j]=c[i];
				i--;
			}
		}
		String neuesWort = String.valueOf(neu);
		return neuesWort;
	}
	
	public String encrypt(String message){
		
		
		return null;
	}
	
	public String decrypt(String cypherText){
		
		return null;
	}
	
}
