package in.ac.adit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ac.adit.dao.EmployeeDAOImpl;

/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
		request.setAttribute("employeeList", employeeDAOImpl.getAllEmployee());
		request.getRequestDispatcher("getAllEmployee.jsp").forward(request, response);
	}
}
