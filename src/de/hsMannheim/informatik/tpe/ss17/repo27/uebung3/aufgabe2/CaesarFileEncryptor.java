package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	static IFileEncryptor neu = new CaesarFileEncryptor();
	static int anzVerschiebung = 5;
	static String pfad ="";// "C:\\Users\\Ufuk\\workspace\\test";
	static String newFolderNameDecrypted = "";// pfad + "_decrypted";
	static String newFolderNameEncrypted = "";// pfad + "_encrypted";
	static CaesarFileEncryptor cfe = new CaesarFileEncryptor();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Bitte geben Sie hier Ihr Verzeichnis-Pfad ein: ");
		System.err.println("Bitte ACHTEN Sie bei der eingabe darauvf --> \\-->\\\\");
		
		String eingabe = readLine();
		cfe.setPfad(eingabe);
		File f = new File(cfe.getPfad());
		ueberpruefeVerzeichnis(f);

	}
	public void setPfad(String pfad){
		this.pfad = pfad;
		setNewFolderNameEncrypted(pfad);
		setNewFolderNameDecrypted(pfad);
	}
	
	public String getPfad(){
		return this.pfad;
	}
	
	public void setNewFolderNameEncrypted(String pfad){
		this.newFolderNameEncrypted=pfad+ "_encrypted";
	}
	
	public String getNewFolderNameEncrypted(){
		return this.newFolderNameEncrypted;
	}
	
	public void setNewFolderNameDecrypted(String pfad){
		this.newFolderNameDecrypted=pfad+ "_decrypted";
	}
	
	public String getNewFolderNameDecrypted(){
		return this.newFolderNameDecrypted;
	}
	
	
	public static void ueberpruefeVerzeichnis(File file) throws IOException {
		File[] fileArray = file.listFiles();
		int anzahlOrdner = 0;
		int anzahlDatei = 0;
		if (!file.exists()) {
			System.err.println("Ordner existiert nicht oder Pfad falsch eingegeben (ACHTUNG \\-->\\\\)");
		} else {
			System.out.println("Ordner existiert --> Überprüfe nach Elementen im Ordner");
			if (file != null) {
				for (int i = 0; i < fileArray.length; i++) {
					System.out.print(fileArray[i]);
					if (fileArray[i].isDirectory()) {
						System.out.print(" (Ordner)\n");
						anzahlOrdner++;
						 ueberpruefeVerzeichnis(fileArray[i]); //Unterverzeichnis
						// öffnen
					} else {

						System.out.print(" (Datei)\n");
						neu.encrypt(fileArray[i]);
						File encryptedFile = neu.encrypt(fileArray[i]);
						neu.decrypt(encryptedFile);
						anzahlDatei++;

					}
				}
			}
		}
		System.out.println("Anzahl Unterordner: " + anzahlOrdner);
		System.out.println("Anzahl Dateien: " + anzahlDatei);
	}

	@Override
	public File encrypt(File sourceDirectory) throws IOException {
		// filter filename from path
		String pfad = sourceDirectory + "";
		int index = pfad.lastIndexOf("\\");
		String fileName = pfad.substring(index + 1);

//		File f = new File(newFolderNameEncrypted);
		File f = new File(cfe.getNewFolderNameEncrypted());
		
		f.mkdir();
		FileReader fr = new FileReader(sourceDirectory);
		BufferedReader br = new BufferedReader(fr);
		CaesarWriter cw = new CaesarWriter(anzVerschiebung, new FileWriter(f + "\\" + fileName));
		String zeile = "";
		try {
			do {
				zeile = br.readLine();
				cw.write(zeile);
				cw.write(System.getProperty("line.separator"));
			} while (zeile != null);
		} catch (NullPointerException e) {

		}

		br.close();
		cw.close();

		File newFolderWithNewfile = new File(f + "\\" + fileName);

		return newFolderWithNewfile;
	}

	@Override
	public File decrypt(File sourceDirectory) throws IOException {
		// filter filename from path
		String pfad = sourceDirectory + "";
		int index = pfad.lastIndexOf("\\");
		String fileName = pfad.substring(index + 1);

//		File f = new File(newFolderNameDecrypted);
		File f = new File(cfe.getNewFolderNameDecrypted());

		f.mkdir();
		FileReader fr = new FileReader(sourceDirectory);
		BufferedReader br = new BufferedReader(fr);

		CaesarWriter cw = new CaesarWriter(0, new FileWriter(f + "\\" + fileName));
		CaesarReader cr = new CaesarReader(anzVerschiebung, new FileReader(cfe.getNewFolderNameEncrypted() + "\\" + fileName));

		String zeile = "";
		try {
			do {
				zeile = br.readLine();
				char[] cbuf = new char[zeile.length() + 2];
				cr.read(cbuf);
				cw.write(new String(cbuf));

			} while (zeile != null);

		} catch (NullPointerException e) {

		}

		br.close();
		cr.close();
		cw.close();

		File newFolderWithNewfile = new File(f + "\\" + fileName);

		return newFolderWithNewfile;
	}

}
