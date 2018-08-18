
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.util.DBUtil;
import edu.ksr.iet.util.EmpDetails;

/**
 * Servlet implementation class DetailsDeo
 */
@WebServlet("/DetailsDeo")
public class DetailsDeo extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("paramName");
		int age = Integer.parseInt(request.getParameter("paramAge"));
		int salary = Integer.parseInt(request.getParameter("paramSalary"));
		int phone = Integer.parseInt(request.getParameter("paramPhone"));
		String email = request.getParameter("paramEmail");
		
		EmpDetails empDetail = new EmpDetails();
		empDetail.insertDetails(name, age, salary, phone, email);
		RequestDispatcher dis = request.getRequestDispatcher("report.html");
		dis.forward(request, response);

	}

}
