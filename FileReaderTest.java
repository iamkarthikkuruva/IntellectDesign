package com.intellect.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("D:\\ToDo.txt");
			byte b = (byte) fr.read();
			while( b != -1 )  
			{
				System.out.print((char)b); 
				 b = (byte) fr.read(); 
				 Thread.sleep(10);
			}
			fr.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
