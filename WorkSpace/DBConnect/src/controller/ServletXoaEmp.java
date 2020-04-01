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
import model.Product;
import model.ProductDAO;

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
		int id = Integer.parseInt(request.getParameter("id"));

		boolean result = EmployeeDAO.deleteEmpData(id);
		if (result == true) {
			ArrayList<Employee> list = EmployeeDAO.getListEmployee();
			list.remove(id);
			response.sendRedirect("lab6_qlnv.jsp");

		} else if (result == false) {
			PrintWriter out = response.getWriter();
			out.println("Xoá ko thành công");
		}
	}

}
