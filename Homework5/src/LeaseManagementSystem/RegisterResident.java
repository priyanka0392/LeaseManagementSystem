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
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LeaseManagementSystem/RegisterResident")
public class RegisterResident extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterResident() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	
		request.getRequestDispatcher("RegisterResident.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		List<UserDetails> entries = (ArrayList<UserDetails>) getServletContext().getAttribute("entries");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String Email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		int contact_num = Integer.parseInt(request.getParameter("contact_num"));
		int people_num = Integer.parseInt(request.getParameter("people_num"));
		String occupation = request.getParameter("occupation");
		String type = request.getParameter("type");
		String preference = request.getParameter("preference");
		String nfd = request.getParameter("nfd");
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 ResultSet rs = null;
		 Connection c=null;
		try {

			String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
	        String usernameDB = "cs320stu123";
	        String passwordDB = "K06uWNwy";
	        c = DriverManager.getConnection(url, usernameDB, passwordDB);
			Date hfd= dateFormat.parse(nfd);
			
			SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
			if (pwd.equals(cpwd)) {
				
				PreparedStatement stmt = c.prepareStatement("insert into userDetails(username,password,email,contactNo,maxPeople,roles,preference,nfd,type,occupation) "
						+ "values('" + name + "','" + pwd + "','" + Email + "'," + contact_num + ","
						+ people_num + ",'prospect','" + preference + "','" + date1.format(hfd) + "','" + type + "','" + occupation
						+ "')");
				
					stmt.executeUpdate();
					
					
					
			
					//entries.add(users);
				}
			
			response.sendRedirect("login");
			
			c.close();

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
	}

}
