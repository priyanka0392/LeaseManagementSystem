package LeaseManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeaseManagementSystem/Deny")
public class Deny extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deny() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		Connection c = null;
		Statement stmt = null;
		ResultSet rs=null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager.getConnection(url, usernameDB, passwordDB);
			stmt = c.createStatement();
		
			int appointId= Integer.parseInt(request.getParameter("appointmentId"));
			String apotDate= request.getParameter("apotdate");
			
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			 rs=stmt.executeQuery("Select * from appointment where appointID="+appointId);
			PreparedStatement ps = c
					.prepareStatement("update appointment set statusAppointment='Deny' where appointID=" + appointId);
			ps.executeUpdate();
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next())
			{
				//String sql="insert into ruleddate(ruled_dates,application_id) values(STR_TO_DATE("+apotDate+",'%m/%d/%Y'),"+appointId+")";
				//System.out.println(sql);
			PreparedStatement psmt= c.prepareStatement("insert into ruleddate(ruled_dates,application_id) values(STR_TO_DATE('"+apotDate+"','%Y-%m-%d'),"+appointId+")");	
			psmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (c!=null)
				c.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		response.sendRedirect("LookUpApartment");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
	}

}
