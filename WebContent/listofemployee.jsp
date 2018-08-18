<%@ page language="java" import="edu.ksr.iet.util.*,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>details</title>
<style> h3{ color: grey; font-family: courier;
font-size: 200% }


</style>
</head>
<body>
<center>
	<table cellspacing="10" cellpadding="10" border="3" >
		
			<%
			out.print("<h3>Employee Details Given Below</h3>");
			out.println("<tr bgcolor=lightbrown style=color:white style=font-family:Comic Sans MS> <td  > " + "EMP_ID" + " </td> <td  > " + "NAME" + " </td> <td> " + "AGE" + "</td> <td>"
					+ "SALARY" + "</td><td> " + "PHONE NO" + "</td> <td>" + "EMAIL"
					+ "</td></tr>");
				List<Employee> list = (List<Employee>) request.getAttribute("emplist");
				
				for (Employee employee : list) {
					out.println("<tr> <td bgcolor=#ffa366 > " + employee.getEmpId() + " </td> <td > " + employee.getName() + "</td> <td> " + employee.getAge() + "</td> <td>"
							+ employee.getSalary() + "</td><td > " + employee.getPhone() + "</td> <td >" + employee.getEmail()
							+ "</td></tr>");
				}
			%>
		
	</table>

</center>
</body>
</html>