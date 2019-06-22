package com.AllUsers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllUsers1
 */
@WebServlet("/AllUsers1")
public class AllUsers1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
        out.println("<html><body bgcolor=\"gray\">");
        try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship", "root", "my678sqlA!0M");
             
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from dummy");
             out.println("<table border=1 width=50% height=50% >");
             out.println("<tr><th>numbers</th><th>fname</th><th>email</th><th>current_credit</th><th> </th><tr>");
             while (rs.next()) {
                 int n = rs.getInt("numbers");
                 String fname = rs.getString("fname");
                 String email=rs.getString("email");
                 int cc = rs.getInt("current_credit"); 
                 out.println("<tr><td>" + n + "</td><td>" + fname + "</td><td>" + email + "</td><td>"+cc +"</td><td>"+"<a href=\"SelectViewOneUser.jsp\">Select</a>"+ "</td></tr>"); 
             }
             out.println("</table>");
             out.println("</html></body>");
             
             con.close();
            
        }
        catch (Exception e) {
            out.println("error");
        }
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
