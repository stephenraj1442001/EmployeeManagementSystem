import java.io.*;
import java.util.*;
import javax.sql.*;

import edu.ksr.iet.util.DBUtil;
import edu.ksr.iet.util.EmpDetails;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/service")
public class DBConnection extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
			String paramUId = request.getParameter("paramUserID");
			String paramPassword = request.getParameter("paramPassWord");
		
			EmpDetails empDetail = new EmpDetails();
			if(empDetail.isCorrectUser(paramUId,paramPassword)) {
				RequestDispatcher dis = request.getRequestDispatcher("emp_details.html");
				dis.forward(request, response);
			}
			else {
				out.println("<center>");
				RequestDispatcher dis = request.getRequestDispatcher("home.html");
			        dis.include(request, response);
				out.println("<h1 style=\"font-family:Comic Sans MS;\">You Entered Wrong UserId Or Password</h1>");
				 out.println("</center>");
			}
		} 
	}
