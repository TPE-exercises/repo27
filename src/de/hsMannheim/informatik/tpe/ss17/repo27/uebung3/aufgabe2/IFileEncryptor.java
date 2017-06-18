package de.hsMannheim.informatik.tpe.ss17.repo27.uebung3.aufgabe2;

import java.io.*;

public interface IFileEncryptor {
	
	/**
	 * encrypted file from the folder
	 * @param sourceDirectory path of the folder
	 * @return
	 * @throws IOException
	 */
	public File encrypt(File sourceDirectory) throws IOException;
	
	/**
	 * decrypted file from the folder
	 * @param sourceDirectory path of the folder
	 * @return
	 * @throws IOException
	 */
	public File decrypt(File sourceDirectory)throws IOException;

}
