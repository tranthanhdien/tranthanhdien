package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;

@WebServlet("/ServletLab5")
public class ServletLab5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLab5() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		toDo(request, response);
	}

	private void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (userName.equals("ttdien") && password.equals("dien1998")) {
			HttpSession session = request.getSession();
			session.setAttribute("Customer", new Customer(userName, password, "Điền"));
			response.sendRedirect("lab5_cart.jsp");
		} else {
			ServletContext context = getServletContext();
			context.setAttribute("error", "Thông tin đăng nhập không chính xác");
			response.sendRedirect("lab5_login.jsp");
		}
	}

}
