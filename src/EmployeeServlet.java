

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ksr.iet.util.EmpDetails;
import edu.ksr.iet.util.Employee;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int age= Integer.parseInt(req.getParameter("inputAge"));
		EmpDetails detailsOfEmp = new EmpDetails();
		List<Employee> employeeList = detailsOfEmp.AgeEmployess(age);
		req.setAttribute("emplist", employeeList);
		
		 
		
	     RequestDispatcher dispatcher = req.getRequestDispatcher("/listofemployee.jsp");
		dispatcher.forward(req, resp);
	}

}
