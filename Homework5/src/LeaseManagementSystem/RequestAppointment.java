package LeaseManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LeaseManagementSystem/RequestAppointment")
public class RequestAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestAppointment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("email");
		int apartment_id = Integer.parseInt(request.getParameter("aptID"));
		ArrayList<appointment> Appointments = (ArrayList<appointment>) getServletContext().getAttribute("apot");
		ArrayList<UserDetails> Users = (ArrayList<UserDetails>)getServletContext().getAttribute("entries");
		ArrayList<Add> Apartments = (ArrayList<Add>)getServletContext().getAttribute("Apartments");
		Connection c = null;
		
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager
	            .getConnection( url, usernameDB, passwordDB );
	        Statement stmt = c.createStatement();
	        PreparedStatement ps= c.prepareStatement("insert into appointment (statusAppointment,userID,apartmentID) values('Requested',(SELECT userID from userdetails WHERE email='"+user_id+"'),'"+apartment_id+"')");
	        ps.executeUpdate();
	        
	       response.sendRedirect("LookUpApartment");
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
		
		finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

	}

}
