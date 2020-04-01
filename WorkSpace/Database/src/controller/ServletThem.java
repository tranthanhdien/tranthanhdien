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


/**
 * Servlet implementation class ServletThem
 */
@WebServlet("/ServletThem")
public class ServletThem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletThem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");

		boolean result = EmployeeDAO.addEmployee(no, id, name, dob, address);
		if (result == true) {
			ArrayList<Employee> list = EmployeeDAO.getListEmployee();
			list.add(new Employee(no, id, name, dob, address));
			response.sendRedirect("index.jsp");

		} else if (result == false) {
			PrintWriter out = response.getWriter();
			out.println("Thêm ko thành công");
		}

	}

}
