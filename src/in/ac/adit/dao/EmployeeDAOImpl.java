package in.ac.adit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ac.adit.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	List<Employee> employees =  new ArrayList<Employee>();;
	Connection connection = null;
	PreparedStatement pstm = null;
	ResultSet resultSet = null;

	public EmployeeDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db?serverTimezone=UTC",
					"root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Employee> getAllEmployee() {
		
		try {
			pstm = connection.prepareStatement("select * from employee_tbl");
			resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setEmail(resultSet.getString(3));
				employees.add(employee);
			}
			System.out.println(employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}


	@Override
	public boolean addEmployee(Employee employee) {
		employees.add(employee);
		return true;
	}

}
