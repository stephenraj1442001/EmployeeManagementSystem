package edu.ksr.iet.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.ksr.iet.util.EmpDetails;
import javax.servlet.RequestDispatcher;

public class EmpDetails {

	public List<Employee> AgeEmployess(int inputAge) {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String data = "select * from emp_details";
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(data);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				if (resultSet.getInt("age") < inputAge && resultSet.getInt("age") != 0) {
					employee.setEmpId(resultSet.getInt("EmpId"));
					employee.setName(resultSet.getString("name"));
					employee.setAge(resultSet.getInt("age"));
					employee.setEmail(resultSet.getString("email"));
					employee.setSalary(resultSet.getInt("salary"));
					employee.setPhone(resultSet.getInt("phone"));
					employeeList.add(employee);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}

		return employeeList;
	}
	
	 public boolean isCorrectUser(String userId, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String data = "select * from login";
		int flag = 0;
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(data);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				if (resultSet.getString("userid").equals(userId) && resultSet.getString("password").equals(password)) {
					flag = 1;
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(connection, preparedStatement, resultSet);
		}

		if (flag == 1)
			return true;
		else
			return false;
	}
	 
	 public void insertDetails(String name,int age,int salary,int phone,String email) {
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			Statement stmt = null;

			try {
				connection = DBUtil.getConnection();
				connection.setAutoCommit(false);
				String sql = "insert into emp_details(name,age,salary,phone,email) values(?,?,?,?,?)";
				prepareStatement = connection.prepareStatement(sql);
				prepareStatement.setString(1, name);
				prepareStatement.setInt(2, age);
				prepareStatement.setInt(3, salary);
				prepareStatement.setInt(4, phone);
				prepareStatement.setString(5, email);
				prepareStatement.executeUpdate();
				connection.commit();
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(connection, stmt, null);
			}
			
	 }

}
