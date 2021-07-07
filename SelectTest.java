package com.intellect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM EMP");
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				java.sql.Date date = rs.getDate(5);
				float salary = rs.getFloat(6);
				float comm = rs.getFloat(7);
				int deptno = rs.getInt(8);

				System.out.println("EMPNO  : " + empno);
				System.out.println("NAME   : " + ename);
				System.out.println("JOB    : " + job);
				System.out.println("MGR    : " + mgr);
				System.out.println("DOJ    : " + date);
				System.out.println("SAL    : " + salary);
				System.out.println("COMM   : " + comm);
				System.out.println("DEPTNO : " + deptno);
			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
