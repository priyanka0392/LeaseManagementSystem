package LeaseManagementSystem;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LeaseManagementSystem/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
		List<UserDetails> entries = new ArrayList<UserDetails>();
		ArrayList<Add> ap= new ArrayList<Add>();
		ArrayList<appointment> apot=new ArrayList<appointment>();
		
		config.getServletContext().setAttribute("entries", entries);
		config.getServletContext().setAttribute("Apartments",ap);
		config.getServletContext().setAttribute("apot", apot);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	
		request.getRequestDispatcher("../LeaseManagementSystem/login.jsp").forward(request, response);
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		

		List<UserDetails> entries = (ArrayList<UserDetails>) getServletContext().getAttribute("entries");
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		Connection c = null;
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager
	            .getConnection( url, usernameDB, passwordDB );
	        Statement stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from userdetails" );			
			while(rs.next())
			{
				session.setAttribute("email", rs.getString("email"));
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("userID", rs.getInt("userID"));
				
				if(rs.getString("email").equals(email) && rs.getString("password").equals(password) && rs.getString("roles").equals("manager")){
					response.sendRedirect("ManagerHome");
					return;
				}
				if(rs.getString("email").equals(email) && rs.getString("password").equals(password) && rs.getString("roles").equals("prospect")){
					response.sendRedirect("LookUpApartment");
					return;
				}
			}
			//rs.close();
			//stmt.close();
		//	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
            {
                if( c != null ) 
                {
                	c.close();
                }
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
		}

	}
	
}
