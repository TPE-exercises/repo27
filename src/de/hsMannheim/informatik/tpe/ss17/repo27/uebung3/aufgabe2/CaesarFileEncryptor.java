package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	static IFileEncryptor neu = new CaesarFileEncryptor();
	static int anzVerschiebung = 2;
	static String pfad = "C:\\Users\\ISTEGAL\\workspace\\test";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File(pfad);
		ueberpruefeVerzeichnis(f);

	}
	public static void ueberpruefeVerzeichnis(File file) throws IOException{
		File[] fileArray = file.listFiles();
		int anzahlOrdner = 0;
		int anzahlDatei = 0;
		if (!file.exists()) {
			System.err.println("Ordner leer oder Pfad falsch eingegeben (ACHTUNG \\-->\\\\)");
		} else {
			System.out.println("Ordner nicht leer --> �berpr�fe nach Elementen im Ordner");
			if (file != null) {
				for (int i = 0; i < fileArray.length; i++) {
					System.out.print(fileArray[i]);
					if (fileArray[i].isDirectory()) {
						System.out.print(" (Ordner)\n");
						anzahlOrdner++;
						//ueberpruefeVerzeichnis(files[i]); //Unterverzeichnis �ffnen
					} 
						else {
						
						System.out.print(" (Datei)\n");
						neu.encrypt(fileArray[i]);
						File encryptedFile = neu.encrypt(fileArray[i]);
						neu.decrypt(encryptedFile);
						anzahlDatei++;
						
					}
				}
			}
		}
		System.out.println("Anzahl Ordner: " + anzahlOrdner);
		System.out.println("Anzahl Dateien: " + anzahlDatei);
	}
	
	@Override
	public File encrypt(File sourceDirectory) throws IOException {
		String newFolderName = this.pfad + "_encrypted";
		String pfad = sourceDirectory+"";
		int index = pfad.lastIndexOf("\\");
		String fileName = pfad.substring(index + 1);
		
//		String filename = sourceDirectory+"_encrypted"+".txt";
		
//		File f = new File("C:\\Users\\ISTEGAL\\Desktop\\test\\test12.txt");
		File f = new File(newFolderName);
		f.mkdir();
		FileReader fr = new FileReader(sourceDirectory);
		BufferedReader br = new BufferedReader(fr);
		CaesarWriter cw = new CaesarWriter(anzVerschiebung, new FileWriter(f+"\\"+fileName));
		
//		CaesarReader caesarReader = new CaesarReader(0, new FileReader("test.txt"));
		String zeile = "";
		try{
			 do
			    {
			      zeile = br.readLine();
			      cw.write(zeile);
			      cw.write(System.getProperty( "line.separator" ));
			    }
			    while (zeile != null);
		}
		catch(NullPointerException e){
			
		}

	    br.close();
	    cw.close();
	   
	    File newFolderWithNewfile = new File(f+"\\"+fileName);

		return newFolderWithNewfile;
	}

	@Override
	public File decrypt(File sourceDirectory)  throws IOException {
		String newFolderName = this.pfad + "_decrypted";
		String pfad = sourceDirectory+"";
		int index = pfad.lastIndexOf("\\");
		String fileName = pfad.substring(index + 1);
		System.out.println(sourceDirectory);
		File f = new File(newFolderName);
		f.mkdir();
		
		FileReader fr = new FileReader(sourceDirectory);
		BufferedReader br = new BufferedReader(fr);
		CaesarReader cr = new CaesarReader(anzVerschiebung, new FileReader(sourceDirectory));
		
		CaesarWriter cw = new CaesarWriter(anzVerschiebung, new FileWriter(f+"\\"+fileName));
		String zeile = "";
		try{
			 do
			    {
			      zeile = br.readLine();
			      cw.write(cr.read());
			    }
			    while (zeile != null);
		}
		catch(NullPointerException e){
			
		}

	    br.close();
	    cr.close();
	    cw.close();
		
	    File newFolderWithNewfile = new File(f+"\\"+fileName);
	    
		return newFolderWithNewfile;
	}

}
