package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDAO;
import model.Product;
import model.ProductDAO;

@WebServlet("/ServletThem")
public class ServletThem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletThem() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stt = Integer.parseInt(request.getParameter("stt"));
		String id = request.getParameter("id");
		String name = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");

		boolean result = EmployeeDAO.addEmployeeData(stt, id, name, dob, address);
		if (result == true) {
			ArrayList<Employee> list = EmployeeDAO.getListEmployee();
			list.add(new Employee(stt, id, name, dob, address));
			response.sendRedirect("lab6_qlnv.jsp");

		} else if (result == false) {
			PrintWriter out = response.getWriter();
			out.println("Thêm ko thành công");
		}
	}

}
