package in.ac.adit.dao;

import java.util.List;

import in.ac.adit.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getAllEmployee();
	public boolean addEmployee(Employee employee);
}
