package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseConnection;
import model.EmployeeDAO;
import model.Product;
import model.ProductDAO;

@WebServlet("/ServletThemSP")
public class ServletThemSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletThemSP() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int maSP = Integer.parseInt(request.getParameter("id"));
		String tenSP = request.getParameter("name");
		String dvt = request.getParameter("dvt");
		String nuocSX = request.getParameter("nsx");
		double gia = Double.parseDouble(request.getParameter("gia"));
		
		boolean result = ProductDAO.addProductData(maSP, tenSP, dvt, nuocSX, gia);
		if (result==true) {
			ArrayList<Product> list = ProductDAO.getListProduct();
			list.add(new Product(maSP, tenSP, dvt, nuocSX, gia));
			response.sendRedirect("lab6.jsp");
		
		} else if (result==false) {
			PrintWriter out = response.getWriter();
			out.println("Thêm ko thành công");
		}
			
		
		
		

	}

}
