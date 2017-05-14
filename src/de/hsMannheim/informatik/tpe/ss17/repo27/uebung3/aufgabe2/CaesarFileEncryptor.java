package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	static IFileEncryptor neu = new CaesarFileEncryptor();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("C:\\Users\\ISTEGAL\\Desktop\\test");
		File[] fileArray = f.listFiles();
		ueberpruefeVerzeichnis(f);

	}
	public static void ueberpruefeVerzeichnis(File file) throws IOException{
		File[] fileArray = file.listFiles();
		int anzahlOrdner = 0;
		int anzahlDatei = 0;
		if (file == null) {
			System.err.println("Ordner leer");
		} else {
			System.out.println("Ordner nicht leer");
			if (file != null) {
				for (int i = 0; i < fileArray.length; i++) {
					System.out.print(fileArray[i]);
					if (fileArray[i].isDirectory()) {
						System.out.print(" (Ordner)\n");
						anzahlOrdner++;
						//ueberpruefeVerzeichnis(files[i]); //Unterverzeichnis öffnen
					} 
						else {
						
						System.out.print(" (Datei)\n");
						neu.encrypt(fileArray[i]);
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
		String filename = sourceDirectory+"_encrypt"+".txt";
//		File f = new File("C:\\Users\\ISTEGAL\\Desktop\\test\\test12.txt");
		File f = new File(filename);
		
		FileReader fr = new FileReader(sourceDirectory);
		BufferedReader br = new BufferedReader(fr);
		CaesarWriter cw = new CaesarWriter(5, new FileWriter(f));
		
//		CaesarReader caesarReader = new CaesarReader(0, new FileReader("test.txt"));
		String zeile = "";
		try{
			 do
			    {
			      zeile = br.readLine();
			      cw.write(zeile);
			      cw.write(System.getProperty( "line.separator" ));
//			      System.out.println(zeile);
			    }
			    while (zeile != null);
		}
		catch(NullPointerException e){
			
		}

	    br.close();
	    cw.close();
		
//		try {
//			if (!sourceDirectory.exists()) {
//				System.err.println("Datei " + sourceDirectory + " existiert nicht oder Pfad falsch eingegeben!");
//			} else {
//				System.out.println("Datei existiert");
//				Reader f = new FileReader(sourceDirectory);
//				int res = f.read();
//				String wort = "";
//				while (res != -1) {
//					wort = wort + (char) res;
//				}
//				System.out.println(wort);
//				f.close();
//			}
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//
//		}

		return f;
	}

	@Override
	public File decrypt(File sourceDirectory) {

		return null;
	}

}
