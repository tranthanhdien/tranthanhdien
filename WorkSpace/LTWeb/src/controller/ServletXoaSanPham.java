package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import model.DAO;
import model.Product;

@WebServlet("/ServletXoaSanPham")
public class ServletXoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletXoaSanPham() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int index = Integer.parseInt(request.getParameter("index"));
			DAO.getListProduct().remove(index);
		//	String path = request.getContextPath() + "/products/lab5.jsp";
			response.sendRedirect("lab5.jsp");

		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
