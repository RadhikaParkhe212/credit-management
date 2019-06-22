package com.Transfer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Transfer
 */
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	String dbDriver="com.mysql.cj.jdbc.Driver";
	private String dbUrl="jdbc:mysql://localhost:3306/internship";
	private String dbUser="root";
	private String dbPass="my678sqlA!0M";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int am=Integer.parseInt(request.getParameter("amount"));
		String u=request.getParameter("users");
		Connection con=null;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><body bgcolor=\"gray\">");
		
		
        try
		{
        	
			Class.forName(dbDriver);
			con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql="insert into transfers values(?,?)";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			stmt.setString(1, u);
			stmt.setInt(2, am);
			
			int i=stmt.executeUpdate();
			String msg="";
			if(i!=0)
			{
				msg="Transfer has been recorded";
				pw.println("<br/>"+msg);
				
			}
			else {
				msg="Failed to insert data";
				pw.println("<br/>"+msg);
				
			}
			pw.println("<table>");
			pw.println("<tr><td>"+"<a href=\"AllUsersView.jsp\">view all users</a>"+"</td></tr>");
			pw.println("</table>");
			pw.println("</html></body>");
			con.close();
			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
