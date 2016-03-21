package LeaseManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LeaseManagementSystem/RescheduleApplication")
public class RescheduleApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RescheduleApplication() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("RescheduleApplication.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	ArrayList<appointment> app1 = (ArrayList<appointment>) getServletContext().getAttribute("apot");
		
		int appointId1= Integer.parseInt(request.getParameter("txtappointID"));
		String apotDate = request.getParameter("apotdate");
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			}
		 
		  try{
			  String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
		        String usernameDB = "cs320stu123";
		        String passwordDB = "K06uWNwy";
		        
		       c = DriverManager
		            .getConnection( url, usernameDB, passwordDB );
		        stmt = c.createStatement();
		        Date appointDate= dateFormat.parse(apotDate);
		        int appointId= Integer.parseInt(request.getParameter("txtappointID"));
		       
		        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

			PreparedStatement ps = c.prepareStatement("update appointment set appointDate='"+dateFormat1.format(appointDate)+"', statusAppointment='Scheduled' where appointID="+appointId1);
		    
			ps.executeUpdate();
			/*PreparedStatement psmt= c.prepareStatement("insert into ruleddate(ruledDates,application_id) values (STR_TO_DATE("+apotDate+",'%m/%d/%Y'),"+appointId1+") where application_id="+appointId1);
			psmt.executeUpdate();*/
			
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
		
			request.getRequestDispatcher("RescheduleApplication.jsp").forward(request, response);
		
	
}

	}
	

