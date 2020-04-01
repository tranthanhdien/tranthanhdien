package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import model.Cart;
import model.Item;
import model.Product;

@WebServlet("/ServletCart")
public class ServletCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO = new ProductDAO();

	public ServletCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String command = request.getParameter("command");
		String product_ID = request.getParameter("productID");
		Cart cart = (Cart) session.getAttribute("cart");

		try {
			long id_Product = Long.parseLong(product_ID);
			Product product = ProductDAO.getProduct(id_Product);
			switch (command) {
			case "plus":
				if (cart.getCartItems().containsKey(id_Product)) {
					cart.plusToCart(id_Product, new Item(product, cart.getCartItems().get(id_Product).getQuantity()));
				} else {
					cart.plusToCart(id_Product, new Item(product, 1));
				}
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp");
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("index.jsp");
	}

}
