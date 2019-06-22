package com.OneUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class OneUser
 */
@WebServlet("/OneUser")
public class OneUser extends HttpServlet {
	
	String dbDriver="com.mysql.cj.jdbc.Driver";
	private String dbUrl="jdbc:mysql://localhost:3306/internship";
	private String dbUser="root";
	private String dbPass="my678sqlA!0M";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String un=request.getParameter("number");
		Connection con=null;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
        out.println("<html><body bgcolor=\"gray\">");
		try
		{
			Class.forName(dbDriver);
			con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql="select * from dummy where numbers=?";
			//String sq="Select current_credit from dummy where numbers=?";
			PreparedStatement stmt=con.prepareStatement(sql);
			//PreparedStatement stmt1=con.prepareStatement(sq);
			stmt.setString(1, un);
			
			ResultSet rs=stmt.executeQuery();
			//ResultSet rs1=stmt1.executeQuery();
			 out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>number</th><th>fname</th><th>email</th><th>current_credit</th><tr>");
			if(rs.next())
			{
				int n=rs.getInt("numbers");
				String fn=rs.getString("fname");
				String em=rs.getString("email");
				int cc=rs.getInt("current_credit");
				out.println("<tr><td>"+n+"</td><td>"+fn+"</td><td>"+em+"</td><td>"+cc+"</td><td>"+"<a href=\"TransferCredit.jsp\">Transfer_Credit</a>"+"</td></tr>");
				
	             
			}
			
			
			else {
				response.sendRedirect("SelectViewOneUser.jsp");
				return;
			}
		
			out.println("</table>");
			out.println("</html></body>");
			
			con.close();
			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			out.println(e);
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
