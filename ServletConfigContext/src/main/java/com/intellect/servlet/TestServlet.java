package com.intellect.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig cg = getServletConfig();
		ServletContext sc = cg.getServletContext();
		PrintWriter pw = response.getWriter();
		
		pw.println("<br> Driver context param value ::" + sc.getInitParameter("driver"));
		pw.println("<br> url context param value ::" + sc.getInitParameter("url"));
		pw.println("<br> db username context param value ::" + sc.getInitParameter("dbuser"));
		pw.println("<br> db password context param value ::" + sc.getInitParameter("dbpwd"));
		
		pw.println("<br> username init param vlaue ::" + cg.getInitParameter("uname"));

		// close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}