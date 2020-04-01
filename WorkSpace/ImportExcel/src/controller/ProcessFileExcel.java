package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDAO;
import dao.KhachHangDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import javafx.print.Printer;
import model.KhachHang;
import model.Order;
import model.Product;

@WebServlet("/Excel")
public class ProcessFileExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProcessFileExcel() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html ; charset=utf-8");

		String text = request.getParameter("data");
		String chucNang = request.getParameter("chucNang");
		// String[] s = text.split(",");

		if (chucNang == null || chucNang.equals("")) {

		} else
		// chức năng import khách hàng từ excel
		if (chucNang.equals("Customer")) {
			Map<String, KhachHang> mapCustomer = new FileDAO(text).getCustomer(new FileDAO(text).getStringArray());
			if(!mapCustomer.isEmpty()){
				for (KhachHang customer : mapCustomer.values()) {
					new KhachHangDAO().add(customer);
				}
			}
			response.sendRedirect("showcustomer.jsp");
		} else
		// chức năng import sản phẩm từ excel
		if (chucNang.equals("Product")) {
			Map<String, Product> mapProduct = new FileDAO(text).getProduct(new FileDAO(text).getStringArray());
			if(!mapProduct.isEmpty()){
				for (Product sp : mapProduct.values()) {
					new ProductDAO().add(sp);
				}
			}
			response.sendRedirect("showproduct.jsp");

		} else
		// chức năng import đơn hàng từ excel
		if (chucNang.equals("Order")) {
			Map<String, Order> mapOrder = new FileDAO(text).getOrder(new FileDAO(text).getStringArray());
			if(!mapOrder.isEmpty()){
				for (Order o : mapOrder.values()) {
					new OrderDAO().add(o);
				}
			}
			response.sendRedirect("showorder.jsp");

		} else {
			System.out.println("Rỗng");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
