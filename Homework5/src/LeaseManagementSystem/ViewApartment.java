package LeaseManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LeaseManagementSystem/ViewApartment")
public class ViewApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewApartment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
Connection c=null;
		
		try{
			response.sendRedirect("ViewApartment.jsp");
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
			c = DriverManager.getConnection(url, usernameDB, passwordDB);
			Statement stmt = c.createStatement();
			if(!(request.getParameter("ApartmentID")==null))
			{
				int apartmentId= Integer.parseInt(request.getParameter("ApartmentID"));
			stmt.executeUpdate("update apartment set apartmentVacancy=1 where apartmentID="+apartmentId);
			}
			
	}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			try {
				if(c!=null)
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
	//	response.sendRedirect("Login");
	/*	Connection c=null;
		
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
			c = DriverManager.getConnection(url, usernameDB, passwordDB);
			Statement stmt = c.createStatement();
			int apartmentId=Integer.parseInt(request.getParameter("ApartmentID"));
			String apatID=request.getParameter("ApartmentID");
			System.out.println("hey "+apatID);
			//stmt.executeUpdate("update apartment set apartmentVacancy=1 where apartmentVacancy=0");
			stmt.executeUpdate("update apartment set apartmentVacancy=1 where apartmentID="+apartmentId);
		
			request.getRequestDispatcher("ViewApartment.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			try {
				if(c!=null)
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
}
	}




