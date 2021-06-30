package com.intellect.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProductDetailsServlet extends GenericServlet {
	Connection con;
	Statement st;
	ResultSet rs;
	String query;
	int count = 0;

	public ProductDetailsServlet() {
		super();
		System.out.println("ProductDetailsServlet.ProductDetailsServlet()");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("ProductDetailsServlet.init()");
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/karthik", "root", "root");
			System.out.println("connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("ProductDetailsServlet.service()");
		PrintWriter pw = response.getWriter();
		try {
			st = con.createStatement();
			String submit = request.getParameter("submit");
			String prodId = request.getParameter("pid");

			if (submit.equals("Find Product")) {
				int pId = Integer.parseInt(prodId);
				rs = st.executeQuery("SELECT * FROM PRODTAB WHERE PID=" + pId);
				if (rs.next()) {
					int pid = rs.getInt(1);
					String pcode = rs.getString(2);
					double pcost = rs.getDouble(3);
					double pdisc = rs.getDouble(4);
					double pgst = rs.getDouble(5);
					String pnote = rs.getString(6);
					String pven = rs.getString(7);

					pw.println("<html>");
					pw.println("<title>Product Data !!</title>");
					pw.println("<body>");
					pw.println("<h1 align=center> Product Data..!</h1>");

					pw.println("</body>");
					pw.println("<table border=5 cellspacing=10 cellpadding=10>");
					pw.println("<tr>");
					pw.println("<td> PID </td>");
					pw.println("<td>" + pid + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> PCODE </td>");
					pw.println("<td>" + pcode + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> JOB </td>");
					pw.println("<td>" + pcost + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> PDSCI </td>");
					pw.println("<td>" + pdisc + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> PGST </td>");
					pw.println("<td>" + pgst + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> PNOTE </td>");
					pw.println("<td>" + pnote + "</td>");
					pw.println("</tr>");

					pw.println("<tr>");
					pw.println("<td> PVEN </td>");
					pw.println("<td>" + pven + "</td>");
					pw.println("</tr>");

				} else {
					pw.println("<tr>");
					pw.println("<td> Product Data Not Found in our Data Base : " + pId + "</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("<a href='http://localhost:8080/ProductDetailsCrudApp/'>Home</a>");
				pw.println("</html>");
			} else if (submit.equals("Fetch Product")) {
				// st = con.createStatement();
				rs = st.executeQuery("select * from prodtab");

				pw.println("<html>");
				pw.println("<title>Product Data  !!</title>");
				pw.println("<body>");
				pw.println("<h1 align=center> Product Details Servlet</h1>");
				pw.println("<table align=center  border=5 cellspacing=10 cellpadding=10>");
				pw.println("<th> PID </th>");
				pw.println("<th> PCODE </th>");
				pw.println("<th> PCOST </th>");
				pw.println("<th> PDISC </th>");
				pw.println("<th> PGST </th>");
				pw.println("<th> PNOTE </th>");
				pw.println("<th> PVEN </th>");

				while (rs.next()) {
					int pid = rs.getInt(1);
					String pcode = rs.getString(2);
					double pcost = rs.getDouble(3);
					double pdisc = rs.getDouble(4);
					double pgst = rs.getDouble(5);
					String pnote = rs.getString(6);
					String pven = rs.getString(7);

					pw.println("<tr>");
					pw.println("<td>" + pid + "</td>");
					pw.println("<td>" + pcode + "</td>");
					pw.println("<td>" + pcost + "</td>");
					pw.println("<td>" + pdisc + "</td>");
					pw.println("<td>" + pgst + "</td>");
					pw.println("<td>" + pnote + "</td>");
					pw.println("<td>" + pven + "</td>");
					pw.println("</tr>");
				}

				pw.println("</table>");
				pw.println("<a href='http://localhost:8080/ProductCrudApp/'>Home</a>");
				pw.println("</body>");
				pw.println("</html>");
			} else if (submit.equals("Delete Product")) {
				String prodcode = request.getParameter("pCode");
				count = st.executeUpdate("DELETE FROM PRODTAB WHERE PCODE=" + prodcode);
				if (count == 0) {
					pw.println("<h1>no records are found to delete</h1>");
				} else {
					pw.println(count + "<h1>no.of records are deleted</h1>");
				}

				pw.println("<a href='http://localhost:8080/ProductCrudApp/'>Home</a>");
			} else if (submit.equals("Update Product")) {
				String prodid = request.getParameter("pid");
				String prodcode = request.getParameter("pcode");
				String prodnote = request.getParameter("pnote");

				query = "UPDATE  PRODTAB SET PCODE=" + prodcode + ",PNOTE=" + prodnote + " WHERE PID=" + prodid;
				count = st.executeUpdate(query);

				if (count == 0) {
					pw.println("<h1>No records Updated</h1>");
				} else {
					pw.println(count + "<h1>no.of records are update</h1>");
				}

				pw.println("<a href='http://localhost:8080/ProductCrudApp/'>Home</a>");
			}

			else if (submit.equals("Update Product")) {
				String proid = request.getParameter("pid");
				String procode = request.getParameter("pcode");
				String procost = request.getParameter("pcost");
				String prodisc = request.getParameter("pdisc");
				String progst = request.getParameter("pgst");
				String pronote = request.getParameter("pnote");
				String proven = request.getParameter("pven");

				query = "INSERT INTO PRODTAB VALUES(" + proid + "," + procode + "," + procost + "," + prodisc + ","
						+ progst + "," + pronote + "," + proven + ")";
				count = st.executeUpdate(query);

				if (count == 0) {
					pw.println("<h1>Records Inserted</h1>");
				} else {
					pw.println(count + "<h1>no.of record is inserted</h1>");
				}

				pw.println("<a href='http://localhost:8080/ProductCrudApp/'>Home</a>");
			}

		} // try
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		System.out.println("ProductDetailsServlet.destroy()");
		try {
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
