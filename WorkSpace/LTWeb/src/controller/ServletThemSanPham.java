package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.Product;

@WebServlet("/ServletThemSanPham")
public class ServletThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletThemSanPham() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("lab5.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String a = request.getParameter("nameProduct");
			String b = request.getParameter("price");
			String c = request.getParameter("nsx");
			String d = request.getParameter("mau");
			String e = request.getParameter("chatlieu");
			PrintWriter out = response.getWriter();
			out.println(a);
			DAO.getListProduct().add(new Product(1, a, b, 1, 3.0));
			response.sendRedirect("lab5.jsp");

		} catch (Exception e) {

		}
	}

}
