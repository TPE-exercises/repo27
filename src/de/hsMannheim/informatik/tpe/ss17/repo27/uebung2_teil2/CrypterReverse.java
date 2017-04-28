package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2;

import static gdi.MakeItSimple.*;

public class CrypterReverse implements Crypter{
	static Crypter x = new CrypterCaesar();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		println("Bitte geben Sie hier ein Wort ein!");
		String s = readLine();
		println(umkehr(s));
		
		String umkehrWort = umkehr(s);
		
		String z = x.decrypt(umkehrWort);
		println(z);
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
		print("decrypt: ");
		char[] c = cypherText.toCharArray();
		int umwandeln;
		
		for(int i=0; i<cypherText.length();i++){
			if((int)c[i] == (int) 'A' || (int)c[i] == (int) 'B' || (int)c[i] == (int) 'C'){
				umwandeln = (int) c[i] + 55;// muss noch geändert werden
			}
			else{
			umwandeln = (int) c[i] + 27;
			}
			
			c[i]=(char)umwandeln;
		}
		String neuesWort = String.valueOf(c);	
		return neuesWort;
	}
	
}
