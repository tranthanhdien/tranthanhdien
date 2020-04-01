package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model_dao.ReportDB;
import model_product.Product;
import model_product.ProductDAO;

/**
 * Servlet implementation class ControllerProduct
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 100)
@WebServlet("/ControllerProduct")
public class ControllerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "images";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action");
		// *****************************************************Quan li Sản phẩm
		if (action.equals("truyXuatSanPham")) {
			ArrayList<Product> listProduct = new ProductDAO().getListProduct();
			request.setAttribute("listProductAdmin", listProduct);
			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("makeSureRemove")) {
//					int id = Integer.parseInt(request.getParameter("id"));
			PrintWriter pw = response.getWriter();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"Thông báo\" ,  \"Đã xóa thành công sản phẩm!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}

		if (action.equals("remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean remove = new ProductDAO().removeProduct(id);

			if (remove == true) {
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"Thông báo\" ,  \"Đã xóa thành công sản phẩm!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");
				String url = "/admin/product/quanlisanpham.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);
			} else {
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"Error\" ,  \"Không xóa được!\" ,  \"error\" )");
				pw.println(".then(function(){ ");
				pw.println("location.reload(); ");
				pw.println(" } ");
				pw.println("});");
				pw.println("</script>");
				String url = "/admin/product/quanlisanpham.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);
			}
		}
		// tim 1 san pham dua vao ID
		if (action.equals("find")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = new ProductDAO().lookUp(id);
			request.setAttribute("p", p);
			String url = "/admin/product/editProduct.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("updatePproduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("moTa");
			double price = Double.parseDouble(request.getParameter("price"));
			new hethongthongtin.ProductDAO().updateProduct(id, name, description, price);
			String url = "/ControllerAdmin?action=truyXuatSanPham";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("add")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			double discpunt = Double.parseDouble(request.getParameter("discount"));
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			double congSuat = Double.parseDouble(request.getParameter("congSuat"));
			String dienAp = request.getParameter("dienAp");
			int baoHanh = Integer.parseInt(request.getParameter("baoHanh"));
			String loai = request.getParameter("loai");
			String nhom = request.getParameter("nhom");
			String fileName1 = uploadFile(request);
			// luu xuong DB
			new ProductDAO().addProduct(id, name, description, price, discpunt, soLuong, loai, nhom, fileName1, "", "",
					congSuat, dienAp, baoHanh);
			// hien thong bao
			PrintWriter pw = response.getWriter();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"Thông báo\" ,  \"Thêm thành cônng!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			// chuyen trang
			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}
		if (action.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			double price = Double.parseDouble(request.getParameter("price"));
			double discpunt = Double.parseDouble(request.getParameter("discount"));
			int soLuong = Integer.parseInt(request.getParameter("soLuong"));
			double congSuat = Double.parseDouble(request.getParameter("congSuat"));
			String dienAp = request.getParameter("dienAp");
			int baoHanh = Integer.parseInt(request.getParameter("baoHanh"));
			String loai = request.getParameter("loai");
			String nhom = request.getParameter("nhom");
			String image = request.getParameter("image");
			String fileName1 = uploadFile(request);
			PrintWriter pw = response.getWriter();
			// cap nhat Db
			if (fileName1.equals("images/")) {
				fileName1 = image;
			}
			boolean edit = new ProductDAO().editProduct(id, name, description, price, discpunt, soLuong, loai, nhom,
					fileName1, fileName1, fileName1, congSuat, dienAp, baoHanh);
			if (edit == true) {
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"Thông báo\" ,  \"Sửa thành cônng!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");

			} else {
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"Thông báo\" ,  \"Không thê cập nhật!\" ,  \"error\" )");
				pw.println("});");
				pw.println("</script>");
			}
			// chuyen trang
			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}
		// xu li SEARCH
		if (action.equals("lookUp")) {
			// b1: lay cai chuoi tim kiem len
			String text = request.getParameter("search");
			// b2: bat dau tim kiem tren truong ID
			ArrayList<Product> listSearch = null;
			listSearch = new ProductDAO().search(text);
			// b3: luu danh sach do xuong request
			request.setAttribute("listSearchID", listSearch);
			request.setAttribute("tk", text);
			request.setAttribute("numberSearch", "Tìm được " + listSearch.size() + " sản phẩm liên quan");
			// b4: chuyen toi trang truoc (index.jsp)
			request.getRequestDispatcher("/admin/product/quanlisanpham.jsp").forward(request, response);
		}
		// xuat file excel
		// xuat report ra file excel
		if (action.equals("displayReport")) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=report.xls");
			String reportString = null;
			reportString = ReportDB.reportProduct();
			PrintWriter out = response.getWriter();
			out.println(reportString);

		}
		//import excel

	}

	private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
		String fileName = "";
		try {
			Part filePart = request.getPart("photo");
			fileName = (String) getFileName(filePart);
			String applicationPath = request.getServletContext().getRealPath("");
			String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				File outputFilePath = new File(basePath + fileName);
				inputStream = filePart.getInputStream();
				outputStream = new FileOutputStream(outputFilePath);
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
			} catch (Exception e) {
				e.printStackTrace();
				fileName = "";
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
			}

		} catch (Exception e) {
			fileName = "";
		}
		return UPLOAD_DIR + "/" + fileName;
	}

	private String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("*****partHeader :" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		return null;
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
