package com.intellect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {

	public static void main(String[] args) {
		int no = 0;
		String newName = null, newAddrs = null;
		float newAvg = 0.0f;
		int count = 0;
		try {
			Scanner sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter exisiting  student number::");
				no = sc.nextInt();
				System.out.println("Enter new Name for  student ::");
				newName = sc.next();
				System.out.println("Enter new Address for  student ::");
				newAddrs = sc.next();
				System.out.println("Enter new  avg for   student ::");
				newAvg = sc.nextFloat();
			}
			newName = "'" + newName + "'";
			newAddrs = "'" + newAddrs + "'";
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
			Statement st = con.createStatement();
			String query = "UPDATE  STUDENT SET NAME=" + newName + ",ADDRS=" + newAddrs + ",AVG=" + newAvg
					+ " WHERE SNO=" + no;
			System.out.println(query);
			count = st.executeUpdate(query);
			if (count == 0)
				System.out.println("No Record is updated");
			else
				System.out.println(count + " no.of record(s) are updated");

			st.close();
			con.close();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// main
}// class
