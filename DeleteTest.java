package com.intellect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String city=null;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter student city(address)");
				city=sc.next(); 
			}
			city="'"+city+"'";  
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system","oracle");
			   if(con!=null)
				   st=con.createStatement();
			     query="DELETE FROM STUDENT WHERE ADDRS="+city;
			     System.out.println(query);
			     if(st!=null)
			    	 count=st.executeUpdate(query);
			     if(count==0)
			    	   System.out.println("no records are found to delete");
			     else
			    	 System.out.println(count+" no.of records are deleted");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
			    se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}//main
}//class
