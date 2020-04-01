package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

@WebServlet("/ServletXoa")
public class ServletXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletXoa() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maSP = Integer.parseInt(request.getParameter("id"));
		
		boolean result = ProductDAO.deleteProductData(maSP);
		if (result==true) {
			ArrayList<Product> list = ProductDAO.getListProduct();
		//	ProductDAO.deleteInList(maSP);
			list.remove(maSP);
			response.sendRedirect("lab6.jsp");
		
		} else if (result==false) {
			PrintWriter out = response.getWriter();
			out.println("Xoá ko thành công");
		}
	}

}
