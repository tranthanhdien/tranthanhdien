package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDAO;

@WebServlet("/ServletXoaEmp")
public class ServletXoaEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletXoaEmp() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		boolean result = EmployeeDAO.deleteEmployee(no);
		if (result == true) {
			ArrayList<Employee> list = EmployeeDAO.getListEmployee();
			list.remove(no);
			response.sendRedirect("index.jsp");
		} else if (result == false) {
			PrintWriter out = response.getWriter();
			out.println("Thất bại");
		}

	}

}
