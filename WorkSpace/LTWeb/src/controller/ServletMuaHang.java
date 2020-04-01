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

@WebServlet("/ServletMuaHang")
public class ServletMuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("customer") == null) {
				// chuyển đến trang đăng nhập
			} else {
				int index = Integer.parseInt(request.getParameter("index"));
				Customer customer = (Customer) session.getAttribute("customer");
				Product product = DAO.getListProduct().get(index);
				customer.addShoppingCart(product);
				// chuyển đến trang giỏ hàng của KH
			}
		} catch (Exception e) {
			// chuyển đến trang thông báo lỗi
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
