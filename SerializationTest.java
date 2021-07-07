package com.intellect.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable {
	String addressLine, city, state;

	public Address(String addressLine, String city, String state) {
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
	}
}

class Student implements Serializable {
	int id;
	String name;
	Address address;

	public Student(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

}

public class SerializationTest {

	public static void main(String[] args) {

		try {
			// Creating the object
			Address a1 = new Address("abc colony", "kurnool", "AP");
			Student s1 = new Student(101, "karthik", a1);
			// Creating stream and writing the object
			FileOutputStream fout = new FileOutputStream("D:/javaFile.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(s1);
			// out.flush();
			// closing the stream
			fout.close();
			out.close();
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
