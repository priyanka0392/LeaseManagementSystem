package LeaseManagementSystem;

import java.io.IOException;
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

@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Status() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection c = null;
		Statement stmt = null;
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager
	            .getConnection( url, usernameDB, passwordDB );
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from userDetails" );
	        ArrayList<Add> a1 = (ArrayList<Add>) getServletContext().getAttribute("Apartments");
			ArrayList<appointment> apot1=(ArrayList<appointment>) getServletContext().getAttribute("apot");
			if(request.getParameter("apartment_num")!=null)
			{
			while(rs.next())
			{
				if(rs.getInt("apartmentNo")==Integer.parseInt(request.getParameter("apartment_num")))
{
	if(rs.getString("status").equals("Accepted"))
	{
		int query= stmt.executeUpdate("update appointment status='Accepted' where apartmentNo='apartment_num'");
	}
	else 
	{
		int query1= stmt.executeUpdate("update appointment status='deny' where apartmentNo='apartment_num'");
	}
}
			}
		}
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
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.getRequestDispatcher("LookUpApartment.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
	}

}
