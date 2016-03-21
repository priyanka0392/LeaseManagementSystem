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

@WebServlet("/LeaseManagementSystem/LookUpApartment")
public class LookUpApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookUpApartment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		Connection c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}

		try {

			if (request.getParameter("appointmentId") != null) {
				int apotID = Integer.parseInt(request.getParameter("appointmentId"));
				String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
		        String usernameDB = "cs320stu123";
		        String passwordDB = "K06uWNwy";
		        c = DriverManager.getConnection(url, usernameDB, passwordDB);
				Statement stmt = c.createStatement();
				int query = stmt
						.executeUpdate("update appointment set statusAppointment='Accepted' where appointID="+apotID);
			}
		}

		catch (Exception e) {
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

		response.sendRedirect("LookUpApartment.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

	}

}
