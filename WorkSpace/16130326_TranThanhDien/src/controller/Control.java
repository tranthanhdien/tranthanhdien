package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Product;
import model.ProductDAO;

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
		if (action.equals("remove")) {
			// 1: lay ID SP
			int id = Integer.parseInt(request.getParameter("id"));
			// 2: thuc hien xoa trong danh sach san phan dua vao ID
			boolean remove = new ProductDAO().remove(id);
			if (remove == true) {
				// chuyen truc tiep ve trang index
				response.sendRedirect("index.jsp");

			} else {
				// chua xoa duoc thi loi
				PrintWriter out = response.getWriter();
				out.println("stupid!!");
			}
		}
		if (action.equals("edit")) {
			// lay thong tin san pham sau khi nhap lai sp
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			double cost = Double.parseDouble(request.getParameter("cost"));
			String linkImage = (request.getParameter("link"));

			boolean edit = new ProductDAO().edit(id, name, price, cost, linkImage);
			if (edit == true) {
				// chuyen ve trang index
				response.sendRedirect("index.jsp");

			} else {
				PrintWriter out = response.getWriter();
				out.println("stupid!!");
			}

		}
		if (action.equals("findProduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = new ProductDAO().lookUp(id, new ProductDAO().getListProduct());
			if (p != null) {
				// co san pham
				// 1: luu xuong request
				request.setAttribute("sp", p);
				// chuyen sang trang edit
				getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("stupid!!");
			}
		}
		if (action.equals("add")) {
			//b1:lay cac gia tris
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			Double Price = Double.parseDouble(request.getParameter("price"));
			Double cost = Double.parseDouble(request.getParameter("cost"));
			String image = request.getParameter("image");
			
			//thuc hien them vao CSDL
			new ProductDAO().add(id, name, Price, cost, image);
			//chuyen truc tiep ve trang index
			response.sendRedirect("index.jsp");

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
