package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_dao.FileDAO;
import model_product.Product;
import model_product.ProductDAO;

@WebServlet("/ProcessFileExcel")
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

		// import file excel vào csdl
		if (chucNang.equals("Product")) {
			Map<String, Product> mapProduct = new FileDAO(text).getProduct(new FileDAO(text).getStringArray());
			if (!mapProduct.isEmpty()) {
				for (Product sp : mapProduct.values()) {
					new ProductDAO().addProduct(sp.getId(), sp.getName(), sp.getDescription(), sp.getPrice(),
							sp.getDiscount(), sp.getSoLuongTrongKho(), sp.getType(), sp.getNhom(), sp.getLinkHA1(),
							sp.getLinkHA2(), sp.getLinkHA3(), sp.getCongSuat(), sp.getDienAp(), sp.getBaoHanh());
				}
			}
			response.sendRedirect("/admin/product/quanlisanpham.jsp");

		} else {
			System.out.println("Rá»—ng");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
