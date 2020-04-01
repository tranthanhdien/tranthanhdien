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

@WebServlet("/ServletSua")
public class ServletSua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSua() {
		super();
		// TODO Auto-generated constructor stub
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

//		request.setAttribute("e", "Employee");
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");

		Employee e = new Employee(no, id, name, dob, address);
		boolean edit = EmployeeDAO.editEmployee(e);
		if (edit == true) {
			ArrayList<Employee> list = EmployeeDAO.getListEmployee();
			EmployeeDAO.edit(no, e);
			// chuyen ve trang index
			response.sendRedirect("index.jsp");

		} else {
			PrintWriter out = response.getWriter();
			out.println("Cập nhật thất bại");
		}

	}

}
