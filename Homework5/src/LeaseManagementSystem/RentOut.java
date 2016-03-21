package LeaseManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeaseManagementSystem/RentOut")
public class RentOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RentOut() {
		super();
	}

	@SuppressWarnings({ "unchecked", "null" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection c = null;
		Statement stmt = null;
		int appointId= Integer.parseInt(request.getParameter("AppointmentID"));
		request.setAttribute("appointmentID", appointId);
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager.getConnection(url, usernameDB, passwordDB);
			stmt = c.createStatement();
			
			PreparedStatement ps= c.prepareStatement("update appointment set statusAppointment='Rented' where appointID="+appointId);
			PreparedStatement stmt1 = c.prepareStatement("update apartment set apartmentVacancy=0 where apartmentNo=(SELECT apartmentID from appointment WHERE appointID = "+appointId+")");
			
			stmt1.executeUpdate();
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
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
		request.getRequestDispatcher("RentOut.jsp").forward(request, response);
		
		
		
		}
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		 Connection c = null;
		 ResultSet rs=null;
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        int apartmentID, userID;
	       int appointmentID= Integer.parseInt(request.getParameter("AppointmentID"));
	        c = DriverManager.getConnection(url, usernameDB, passwordDB);
			Statement stmt = c.createStatement();
			Statement stmt1 = c.createStatement();
	        rs=stmt.executeQuery("select appointID,userID,apartmentID from appointment where appointID="+appointmentID);
	        while(rs.next())
	        {
	        	if(rs.getInt("appointID")==appointmentID)
		        {
	        		apartmentID = rs.getInt("apartmentID");
	        		userID = rs.getInt("userID");
	        		
	        		stmt1.executeUpdate("INSERT into rent(apartmentID,userID) values("+apartmentID+","+userID+")");
		        }
	        }
	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
finally{
			
			try {
				if(c!=null)
				c.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("ManagerHome");

	}

}
