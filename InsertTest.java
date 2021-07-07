package com.intellect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter student number::");
			int sno = sc.nextInt();
			System.out.println("Enter student name::");
			String name = sc.next();
			System.out.println("Enter student address::");
			String addrs = sc.next();
			System.out.println("Enter student avg::");
			float avg = sc.nextFloat();
			name = "'" + name + "'";
			addrs = "'" + addrs + "'";

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
			Statement st = con.createStatement();
			String query = "INSERT INTO STUDENT VALUES(" + sno + "," + name + "," + addrs + "," + avg + ")";
			System.out.println(query);
			int count = st.executeUpdate(query);

			System.out.println("Record not inserted");
			System.out.println("Record inserted ::" + count);

			st.close();
			con.close();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// main
}// class
