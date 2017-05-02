package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe1;

public class CrypterCaesar implements Crypter{

	
	private static char clear[] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static char secret[] ={'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'};
	private static int caesarCryptPower = 0;
	
	
	
	//die Main-methode löst die Aufgabe d) 
	public static void main(String[] args) {
		

		
		Crypter cryp1 = new CrypterCaesar();
		Crypter cryp2 = new CrypterReverse();
		String wort = "XHMSNYYXYJQQJS";
		wort = cryp2.decrypt(wort);

		System.out.println(wort);
		setPower(2);
		wort = cryp1.decrypt(wort);
		setPower(0);
		System.out.println(wort);
		
		wort = cryp2.decrypt(wort);
		
		System.out.println(wort);

	}

	private static void println(String f) {
		// TODO Auto-generated method stub
		
	}

	//adjust Key-power, (Key 5 =2, Key 3 =0, Key 0 =-3) -> key 5 = 3 + (2)
	public static void setPower (int var){
		caesarCryptPower = var;
	}
	
	
	
	
	/**
	 * @param  message to encrypt in caesar
	 * @return the encrypted message
	 */
	@Override
	public String encrypt(String message) {
		
		String encrypted = "";
		
		for(int i=0; i < message.length() ;i++){
			char a = message.charAt(i);
			
			for(int p=0; p<26;p++){
				if(a == clear[p]){	
					//check for overflow and set p with Key-power
					if(p + caesarCryptPower > 26)
						p=p + caesarCryptPower-26;
					else if(p + caesarCryptPower < 0)
							p=p + caesarCryptPower+26;
					else
						p= p +caesarCryptPower;
					
					//add char to encrpyted string
					encrypted += secret[p];
					
					println(encrypted);
					p=100;
				}
			}
		}
		
		
		return encrypted;
	}
	/**
	 * @param  message to decrypt in caesar
	 * @return the decrypted message
	 */
	@Override
	public String decrypt(String cypherText) {

		String decrypted = "";
		//check for overflow and set p with Key-power
		for(int i=0; i < cypherText.length() ;i++){
			char a = cypherText.charAt(i);
			for(int p=0; p<26;p++){
				if(a == secret[p]){
					if(p - caesarCryptPower > 26)
						p=p - caesarCryptPower-26;
					else if(p - caesarCryptPower < 0)
							p=p - caesarCryptPower+26;
					else
						p= p - caesarCryptPower;
				
					//add char to decrpyted string
					decrypted += clear[p];
					p=100;
				}
			}
		}
		
		
		return decrypted;
	}

}
