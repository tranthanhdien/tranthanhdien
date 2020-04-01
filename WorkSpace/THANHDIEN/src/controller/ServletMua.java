package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GioHangDAO;
import model.Customer;

@WebServlet("/ServletMua")
public class ServletMua extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMua() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		Customer cus = (Customer) session.getAttribute("Customer");
		if (cus != null) {
			new GioHangDAO().addProduct(id);
			response.sendRedirect("lab5_cart.jsp");

		} else {
			response.sendRedirect("lab5_login.jsp");
		}
	}

}
