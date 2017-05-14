package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import java.io.*;

public interface IFileEncryptor {
	
	public File encrypt(File sourceDirectory) throws IOException;
	
	public File decrypt(File sourceDirectory)throws IOException;

}
