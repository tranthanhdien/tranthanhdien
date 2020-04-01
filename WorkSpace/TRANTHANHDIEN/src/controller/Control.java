package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jndi.toolkit.url.Uri;

import model.Customer;
import model.ItemCart;
import model.Product;
import model.ShoppingCart;
import model_dao.ProductDAO;

/**
 * Servlet implementation class Control
 */
@WebServlet("/Control")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Control() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("addCart")) {
			// b1. kiem tra dang nhap
			HttpSession session = request.getSession();

			if (session.getAttribute("shopping") == null) {
				// chua dang nhap => login
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

			} else {
				// bat dau xu li add gio hang
				// b1: lay ID tu jsp
				int id = Integer.parseInt(request.getParameter("id"));
				// b2: lay gio hang cua khach hang, gia su session luu la shopping
				ShoppingCart shop = (ShoppingCart) session.getAttribute("shopping");
				shop.addCart(new ProductDAO().lookUp(id, new ProductDAO().getListProduct()));
				// luu shop xuong
//				request.setAttribute("shop", shop);
				// chuyen truc tiep ve trang giohang

				response.sendRedirect("giohang.jsp");
			}
		}
		if (action.equals("login")) {
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			String url = "";
			if (name != null && pass != null) {
				// luu session
				HttpSession session = request.getSession();
				session.setAttribute("shopping", new ShoppingCart(new Customer(1, name, pass)));
				url = "/index.jsp";
			}
			if (name == null || pass == null || name.equals("") || pass.equals("")) {
				// phat sinh ve loi
				if (name == null || name.equals("")) {
					url = "/login.jsp";
					request.setAttribute("nameErr", "Truong khong duoc trong");
				}
				if (pass == null || pass.equals("")) {
					url = "/login.jsp";
					request.setAttribute("passErr", "Truong khong duoc trong");
				}

			}
			// chuyen trang
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		if (action.equals("deleteCart")) {
			// b1: lay vi tri index
			// b2: xoa cart o vi tri index
			int index = Integer.parseInt(request.getParameter("index"));
			// lay gio hang khch hang len
			HttpSession session = request.getSession();
			ShoppingCart shop = (ShoppingCart) session.getAttribute("shopping");
			// lay DSSP ra
			ArrayList<ItemCart> listCart = shop.getListCart();
			listCart.remove(index);
			// chuyen truc itep ve trang gio hang
			response.sendRedirect("giohang.jsp");

		}
		if (action.equals("tang")) {
			int index = Integer.parseInt(request.getParameter("index"));
			//lay gio hang khach hang len
			HttpSession session = request.getSession();
			ShoppingCart shop = (ShoppingCart)session.getAttribute("shopping");
			shop.tang(index);
			response.sendRedirect("giohang.jsp");
		}
		if (action.equals("giam")) {
			int index = Integer.parseInt(request.getParameter("index"));
			//lay gio hang khach hang len
			HttpSession session = request.getSession();
			ShoppingCart shop = (ShoppingCart)session.getAttribute("shopping");
			shop.giam(index);
			response.sendRedirect("giohang.jsp");
		}
		if(action.equals("logout")) {
			//lay session khach hang len
			HttpSession session = request.getSession();
			session.invalidate();
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
