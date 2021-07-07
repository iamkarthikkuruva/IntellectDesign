package com.intellect.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationTest {

	public static void main(String[] args) {
		try {
			// Creating stream to read the object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/javaFile.txt"));
			Student s = (Student) in.readObject();
			Address a1 = (Address) in.readObject();
			// printing the data of the serialized object
			System.out.println(s.id + " " + s.name+""+s.address);
			// closing the stream
			in.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
