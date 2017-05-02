package de.hsMannheim.informatik.tpe.ss17.repo27.uebung2_teil2.aufgabe1;

public class CrypterReverse implements Crypter{

	public static void main(String[] args) {
		Crypter cryp = new CrypterReverse();
		String max = "maxistderbeste";
		String f = cryp.encrypt(max);
		System.out.println(f);
		String g = cryp.decrypt(f);
		System.out.println(g);
	}
	
	@Override
	public String encrypt(String message) {
		
			String encrypted = "";
			
			for (int i = message.length(); i > 0; i--) {
				
				encrypted += message.charAt(i-1);
			}
			return encrypted;
		}
	/**
	 * @param  message to decrypt
	 * @return the decrypted message
	 */
		public String decrypt(String cypherText) {
			
			return encrypt(cypherText);
	}

}
