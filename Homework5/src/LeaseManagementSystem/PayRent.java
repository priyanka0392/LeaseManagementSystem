package LeaseManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeaseManagementSystem/PayRent")
public class PayRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayRent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	        request.getRequestDispatcher("../LeaseManagementSystem/PayRent.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		int rentPaid= Integer.parseInt(request.getParameter("rentPaid"));
		String rentMonth= request.getParameter("rentMonth");
		String rentYear=request.getParameter("rentYear");
		int rentID=Integer.parseInt(request.getParameter("rentID"));
		Connection c=null;
		Statement stmt = null;
		PreparedStatement ps;
		try {
		
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
		        c = DriverManager
		            .getConnection( url, usernameDB, passwordDB );
		      
			ps = c.prepareStatement("insert into payrent(rent_paid,rent_month,rent_year,rent_id) values("+rentPaid+",'"+rentMonth+"','"+rentYear+"',"+rentID+")");
			ps.executeUpdate();
			response.sendRedirect("RentHistory");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

}
