package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model_product.Product;
import model_product.ProductDAO;
import model_shoppingcart.Invoice;
import model_shoppingcart.InvoiceDB;
import model_shoppingcart.ItemCart;
import model_shoppingcart.ItemCartDB;
import model_shoppingcart.ShoppingCart;
import model_user.Customer;

/**
 * Servlet implementation class ControllerInvoice
 */
@WebServlet("/ControllerInvoice")
public class ControllerInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerInvoice() {
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

		// truy suat danh sach hoa don
		if (action.equals("quanlihoadon")) {
			// lay danh sach
			ArrayList<Invoice> list = new InvoiceDB().getListInvoice();
			request.setAttribute("listInvoice", list);
			String url = "/admin/invoice/quanlihoadon.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);
		}
		// hien thi chi tiet 1 hoa don
		if (action.equals("displayInvoice1")) {
			// b1: lay Id gui tu jsp
			int idInvoice = Integer.parseInt(request.getParameter("id"));
			ArrayList<Invoice> listInvoice = new InvoiceDB().getListInvoice();
			// b2: tim hoa don can tim dua vao ID
			Invoice invoice = null;
			for (int i = 0; i < listInvoice.size(); i++) {
				invoice = listInvoice.get(i);
				if (invoice.getNumberInvoice() == idInvoice) {
					break;
				}
			}
			// b3: luu xuong
			Customer user = invoice.getUser();
			ShoppingCart shop = invoice.getShop();
			request.setAttribute("invoiceInvoice1", invoice);
			request.setAttribute("userInvoice1", user);
			request.setAttribute("shopInvoice1", shop);
			// b4: chuyen trang
			String url = "/admin/invoice/view_invoice.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		// xoa 1 hoa don
		if (action.equals("removeInvoice")) {
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));
			// xoa ItemCart truoc
			// xoa Invoice sau
			new InvoiceDB().removeItemCart(idInvoice);
			new InvoiceDB().removeInvoice(idInvoice);
			// hien thong bao
			PrintWriter out = response.getWriter();
			out.print("Xóa thành công hóa đơn có mã: " + idInvoice);
		}
		if (action.equals("removeview")) {
			PrintWriter pw = response.getWriter();
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));
			// xoa ItemCart truoc
			// xoa Invoice sau
			new InvoiceDB().removeItemCart(idInvoice);
			new InvoiceDB().removeInvoice(idInvoice);
			// hien thong bao
			Invoice invoice = new Invoice();
			Customer user = invoice.getUser();
			ShoppingCart shop = invoice.getShop();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"Thông báo\" ,  \"Xóa thành công hóa đơn!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			request.setAttribute("invoiceInvoice1", invoice);
			request.setAttribute("userInvoice1", user);
			request.setAttribute("shopInvoice1", shop);
			String url = "/admin/invoice/view_invoice.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}
		if (action.equals("findInvoice")) {
			// 1. lay id
			HttpSession sesion = request.getSession();
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));
			// 2. tim Invoice dua vao idInvoice
			Invoice invoice = new InvoiceDB().lookInvoice(idInvoice);
			if (invoice != null) {
				// luu vao sesion: user, invoice, shoppingcart: de them xoa sua
				ShoppingCart shop = invoice.getShop();
				Customer user = invoice.getUser();
				sesion.setAttribute("cartInvoice", shop);
				sesion.setAttribute("userInvoice", user);
				sesion.setAttribute("findInvoice", invoice);
				// chuyen ve trang edit
				String url = "/admin/invoice/edit.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.forward(request, response);
			} else {
				// bao loi
			}
		}
		if (action.equals("removeCartInvoice")) {
			HttpSession session = request.getSession();
			int index = Integer.parseInt(request.getParameter("index"));
			// lay hoa don len
			Invoice cart = (Invoice) session.getAttribute("findInvoice");
			// lay gio hang len
			ShoppingCart shop = cart.getShop();
			ItemCart item = shop.getListItemcart().get(index);
			// xoa gio hang tai vi tri index
			boolean remove = new InvoiceDB().removeItemCart_Invoice(cart.getNumberInvoice(), item.getP().getId());

			// xoa ItemCart trong DB dua vao idInvoice + idProduct

			// chuyen trang => servlet findInvoice
			String url = "/ControllerAdmin?action=findInvoice&idInvoice=" + cart.getNumberInvoice();
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		// cap nhat hoa don
		if (action.equals("edit")) {
			// lay du lieu
			String date = request.getParameter("date");
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));

			// chi cap nhat lai ngay
			boolean edit = new InvoiceDB().edit(date, idInvoice);
			if (edit == true) {
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Cập nhật ngày thành công!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");
				Invoice in = new InvoiceDB().lookInvoice(idInvoice);
				HttpSession sesion = request.getSession();
				sesion.setAttribute("findInvoice", in);
				getServletContext().getRequestDispatcher("/admin/invoice/edit.jsp").include(request, response);
			} else {
				// bao loi
			}

		}
		// them 1 san pham trong hoa don: => edit
		if (action.equals("addProductOfEdit")) {
			int idInvoice = Integer.parseInt(request.getParameter("idHD"));
			int idProduct = Integer.parseInt(request.getParameter("nameSP1"));
			int quantity = Integer.parseInt(request.getParameter("soLuong1"));
			new ItemCartDB().insert(idInvoice, new ItemCart(new ProductDAO().lookUp(idProduct), quantity));

			// luu lai request
			HttpSession sesion = request.getSession();
			Invoice invoice = new InvoiceDB().lookInvoice(idInvoice);
			// luu vao sesion: user, invoice, shoppingcart: de them xoa sua
			ShoppingCart shop = invoice.getShop();
			Customer user = invoice.getUser();
			sesion.setAttribute("cartInvoice", shop);
			sesion.setAttribute("userInvoice", user);
			sesion.setAttribute("findInvoice", invoice);
			// chuyen ve trang edit
			String url = "/admin/invoice/edit.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		// them hhoa don moi:
		if (action.equals("add")) {
			// lay du lieu
			int id = Integer.parseInt(request.getParameter("id"));
			String date = request.getParameter("date");

			int idCustomer = Integer.parseInt(request.getParameter("khachhang"));
			int idProduct1 = Integer.parseInt(request.getParameter("nameSP1"));
			int soLuong1 = Integer.parseInt(request.getParameter("soLuong1"));
			int idProduct2 = Integer.parseInt(request.getParameter("nameSP2"));
			String testsoLuong2 = request.getParameter("soLuong2");

			int idProduct3 = Integer.parseInt(request.getParameter("nameSP3"));
			String testsoLuong3 = request.getParameter("soLuong3");

			ShoppingCart shop = new ShoppingCart();
			shop.addProduct(new ItemCart(new ProductDAO().lookUp(idProduct1), soLuong1));
			if (idProduct2 != 0 && !testsoLuong2.equals("")) {
				int soLuong2 = Integer.parseInt(request.getParameter("soLuong2"));
				shop.addProduct(new ItemCart(new ProductDAO().lookUp(idProduct2), soLuong2));
			}
			if (idProduct3 != 0 && !testsoLuong3.equals("")) {
				int soLuong3 = Integer.parseInt(request.getParameter("soLuong3"));
				shop.addProduct(new ItemCart(new ProductDAO().lookUp(idProduct3), soLuong3));
			}
			// luu xuong DB: luu hoa don truoc + luu ItemCart sau
			new InvoiceDB().addStringDate(id, idCustomer, date, shop.totalPrice(), true);
			List<ItemCart> listItem = shop.getListCart();
			for (ItemCart item : listItem) {
				new ItemCartDB().insert(id, item);
			}
			// cap nhat lai request
			ArrayList<Invoice> list = new InvoiceDB().getListInvoice();
			request.setAttribute("listInvoice", list);
			// tro ve trang chu quan li hoa don
			getServletContext().getRequestDispatcher("/admin/invoice/quanlihoadon.jsp").include(request, response);
			// ket thuc
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
