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

import LeaseManagementSystem.appointment;

@WebServlet("/LeaseManagementSystem/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddApartment() {
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
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());final String JDBC_DRIVER =
		// "com.mysql.jdbc.Driver";
		/*final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
        String usernameDB = "cs320stu123";
        String passwordDB = "K06uWNwy";

		Connection connection = null;

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(url, usernameDB, passwordDB);
		}

		catch (Exception e) {
			e.printStackTrace();
		}*/
		response.sendRedirect("AddApartment.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		// response.sendRedirect("logout");
		ArrayList<Add> addApartment = (ArrayList<Add>) getServletContext().getAttribute("Apartments");
		Connection c = null;
		
		if (request.getParameter("clear") == null) {
			try {
				String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu123";
		        String usernameDB = "cs320stu123";
		        String passwordDB = "K06uWNwy";
				c = DriverManager.getConnection(url, usernameDB, passwordDB);
				Statement stmt = c.createStatement();
				ResultSet rs = stmt.executeQuery("select * from apartment");
				int apartmentNum = Integer.parseInt(request.getParameter("apartment_num"));
				int maxPeople = Integer.parseInt(request.getParameter("max_people"));
				int rent = Integer.parseInt(request.getParameter("rent"));
				int deposit = Integer.parseInt(request.getParameter("deposit"));
				String type = request.getParameter("type");
				String facility = request.getParameter("facility");
				boolean vacancy = Boolean.parseBoolean(request.getParameter("vacant"));
				while (rs.next()) {
					int query = stmt.executeUpdate(
							"insert into apartment(apartmentNo,apartmentMaxPeople,rent,deposit,typePeople,apartmentFacility,apartmentVacancy) "
									+ "values(" + apartmentNum + "," + maxPeople + "," + rent + "," + deposit + ",'" + type + "','" + facility + "'," + vacancy + ")");
					int maxpeople=Integer.parseInt(rs.getString("max_people"));
					int renthouse=Integer.parseInt(rs.getString("rent"));
					int deposithouse=Integer.parseInt(rs.getString("deposit"));
					boolean vacancy1=Boolean.parseBoolean(rs.getString("vacant"));
					Add apartmentAdd=new Add(rs.getString("apartment_num"), maxpeople, renthouse, deposithouse,rs.getString("type"),rs.getString("facility"), vacancy1);
					addApartment.add(apartmentAdd);
					rs.close();
					stmt.close();
					c.close();
					
					
				}
			} catch (Exception e) {
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

			
			 getServletContext().setAttribute("Apartments",addApartment);
			response.sendRedirect("ManagerHome");
		} else {
			doGet(request, response);
		}
	}

}
