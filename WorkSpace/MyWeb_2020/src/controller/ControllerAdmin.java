package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model_dao.ReportDB;
import model_mail.MailUtil;
import model_product.Product;
import model_product.ProductDAO;
import model_shoppingcart.Invoice;
import model_shoppingcart.InvoiceDB;
import model_shoppingcart.ItemCart;
import model_shoppingcart.ShoppingCart;
import model_user.Customer;
import model_user.CustomerDAO;
import model_user.Login;
import model_user.LoginDAO;

/**
 * Servlet implementation class ControllerAdmin
 */
@WebServlet("/ControllerAdmin")
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdmin() {
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

		// kiem tra admin
		if (action.equals("hasAdmin")) {
			HttpSession session = request.getSession();
			Login customer = (Login) session.getAttribute("user");
			// neu chua dang nhap
			if (customer == null) {
				// kiem tra cookie
				// chuyen toi trang login
				getServletContext().getRequestDispatcher("/admin/login/login.jsp").forward(request, response);
			} else {
				// da dang nhap thi bat dau kiem tra co phai la admin?
				String email = customer.getEmail();
				Login c = new LoginDAO().findAdmin(email);
				if (c == null) {
					// khong tim thay, thong bao len man hinh
					PrintWriter pw = response.getWriter();
					pw.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					pw.println(
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
					pw.println("<script type=\"text/javascript\">");
					pw.println("	$(document).ready(function(){");
					pw.println("swal ( \"Thông báo\" ,  \"Khong phai admin!\" ,  \"error\" )");
					pw.println("});");
					pw.println("</script>");
					getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
				} else {
					// dung chi vao index admin
					getServletContext().getRequestDispatcher("/admin/index.jsp").forward(request, response);
				}

			}
		}
		// login voi admin
		if (action.equals("login")) {
			// lay cac gia tri trong form
			String email = request.getParameter("Name");
			String pass = request.getParameter("Password");
			String url = "";
			// kiem tra user co la admin
			Login user = new LoginDAO().findAdmin(email);
			// TH1: neu email da la admin
			// k1: 1. Mat khau dung hay chua thoi
			if (user != null) {
				if (pass.equals(user.getPass())) {// mhap dung pass
					// 1. luu session hoa don
					// 2. chuyen toi trang can chuyen toi
					HttpSession session = request.getSession();
					// anh xa userInfo
					Customer cu = new CustomerDAO().mappingUserInfo(user.getIdUser());
					session.setAttribute("user", user);
					session.setAttribute("adminInfo", cu);
					getServletContext().getRequestDispatcher("/admin/index.jsp").forward(request, response);

				} else {
					// nhap sai pass
					request.setAttribute("emailRe", email);
					request.setAttribute("pass_err", "Password không đúng, nhập lại");
					getServletContext().getRequestDispatcher("/admin/login/login.jsp").forward(request, response);
				}

			} else {
				// khong tim thay
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Khong phai admin!\" ,  \"error\" )");
				pw.println("});");
				pw.println("</script>");
				request.setAttribute("NotAdmin", "Khong la admin");
				getServletContext().getRequestDispatcher("/admin/login/login.jsp").include(request, response);
			}

		}
		if (action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		// ************************************************************ xu li hoa don
		// hien thi cac hoa don CHUA duoc xu li
		if (action.equals("displayInvoiceProcess")) {
			// danh sach hoa don chua xu li: rat phuc tap trong truy van sql
			HttpSession session = request.getSession();
			ArrayList<Invoice> unprocessedInvoices = new InvoiceDB().unprocessInvoices();
			if (unprocessedInvoices == null || unprocessedInvoices.size() <= 0) {
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"\" ,  \"Không có hóa đơn chờ xử lí!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/index.jsp");
				dispatcher.include(request, response);

			} else {
				session.setAttribute("unprocessInvoices", unprocessedInvoices);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/admin/unprocess_invoice/invoices.jsp");
				dispatcher.forward(request, response);
			}
			// chuyen trang

		}
		// hien thi chi tiet 1 hoa don
		if (action.equals("displayInvoice")) {
			// b1: lay Id gui tu jsp
			HttpSession session = request.getSession();
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));
			ArrayList<Invoice> listInvoiceUnprocess = new InvoiceDB().unprocessInvoices();
			// b2: tim hoa don can tim dua vao ID
			Invoice invoice = null;
			for (int i = 0; i < listInvoiceUnprocess.size(); i++) {
				invoice = listInvoiceUnprocess.get(i);
				if (invoice.getNumberInvoice() == idInvoice) {
					break;
				}
			}
			// b3: luu xuong
			Customer user = invoice.getUser();
			ShoppingCart shop = invoice.getShop();
			session.setAttribute("invoiceInvoice", invoice);
			session.setAttribute("userInvoice", user);
			session.setAttribute("shopInvoice", shop);

			// b4: chuyen trang
			String url = "/admin/unprocess_invoice/invoice.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		// xu li hoa don
		if (action.equals("processInvoice")) {
			// b1: cáº­p nháº­t láº¡i muc isProcess trong bang Invoice DB
			// b2: chuyen trang
			HttpSession session = request.getSession();
			Invoice invoice = (Invoice) session.getAttribute("invoiceInvoice");
			int idInvoice = invoice.getNumberInvoice();
			boolean update = new InvoiceDB().updateProcess(idInvoice);
			if (update) {

				// chuyen trang
				String url = "/ControllerAdmin?action=displayInvoiceProcess";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("Khong co truong processInvoice nao thay doi ca");
			}

		}
		// xu li tat ca hoa don
		if (action.equals("allInvoice")) {
			// 1. lay danh sach hoa don chua xu li trong DB

			ArrayList<Invoice> unprocessedInvoices = new InvoiceDB().unprocessInvoices();
			// 2. chay for xu li tung cai hoa don
			for (int i = 0; i < unprocessedInvoices.size(); i++) {
				Invoice invoice = unprocessedInvoices.get(i);
				new InvoiceDB().updateProcess(invoice.getNumberInvoice());
			}
			// cap nhat lai session
			HttpSession session = request.getSession();
			session.setAttribute("unprocessInvoices", new ArrayList<Invoice>());

			// 3. tra ve trang invoices.jsp hien len thong bao
			PrintWriter pw = response.getWriter();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Xá»­ lÃ­ thÃ nh cÃ´ng!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			String url = "/admin/unprocess_invoice/invoices.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}
		// tu choi tat ca hoa don
		if (action.equals("removeAllInvoice")) {
			// 1. lay dnah sach
			ArrayList<Invoice> unprocessedInvoices = new InvoiceDB().unprocessInvoices();
			// 2.
			for (int i = 0; i < unprocessedInvoices.size(); i++) {
				Invoice invoice = unprocessedInvoices.get(i);
				new InvoiceDB().removeItemCart(invoice.getNumberInvoice());
				new InvoiceDB().removeInvoice(invoice.getNumberInvoice());
			}
			// cap nhat lai session
			HttpSession session = request.getSession();
			session.setAttribute("unprocessInvoices", new ArrayList<Invoice>());
			// tr ve trang
			PrintWriter pw = response.getWriter();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"XÃ³a thÃ nh cÃ´ng!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			String url = "/admin/unprocess_invoice/invoices.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);

		}
		// tu choi hoa don
		if (action.equals("refuseAInvoiceUnprocess")) {
			int id = Integer.parseInt(request.getParameter("id"));
			// thuc hien xoa
			boolean a = new InvoiceDB().removeItemCart(id);
			boolean b = new InvoiceDB().removeInvoice(id);
			// cap nhat lai danh sach
			ArrayList<Invoice> unprocessedInvoices = new InvoiceDB().unprocessInvoices();
			HttpSession session = request.getSession();
			session.setAttribute("unprocessInvoices", unprocessedInvoices);
			PrintWriter pw = response.getWriter();
			if (a == true && b == true) {
				// bao thanh cong, tra ve invoices
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Ä�Ã£ loáº¡i hÃ³a Ä‘Æ¡n khá»�i danh sÃ¡ch chá»� xá»­ lÃ­!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");
				String url = "/admin/unprocess_invoice/invoices.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);

			} else {
				// khong thanh cong
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"KhÃ´ng thá»ƒ tá»« chá»‘i hÃ³a Ä‘Æ¡n nÃ y!\" ,  \"error\" )");
				pw.println("});");
				pw.println("</script>");
				String url = "/admin/unprocess_invoice/invoices.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);
			}
		}
		// xuat report ra file excel
		if (action.equals("displayReport")) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=report.xls");

			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String reportString = null;
			if (name.equalsIgnoreCase("DanhSachHoaDon")) {
				String startDate = request.getParameter("startDate");
				String endDate = request.getParameter("endDate");
				reportString = ReportDB.getInvoiceSumary(title, startDate, endDate);
			}
			if (name.equalsIgnoreCase("userReport")) {
				reportString = ReportDB.reportCustomer(title);
			}
			if (name.equals("product")) {

			}
			if (name.equals("unprocessInvoice")) {
				reportString = ReportDB.reportUnprocessInvoice();
			}
			if(name.equals("reportProcessInvoice")) {
				reportString = ReportDB.reportProcessInvoice();
			}
			PrintWriter out = response.getWriter();
			out.println(reportString);
		}
		// ************************************************** Quan li nguoi dung
		if (action.equals("quanlikhachhang")) {
			ArrayList<Customer> list = new CustomerDAO().getListCustomer();
			request.setAttribute("listCustomer", list);
			String url = "/admin/customer/quanlikhachhang.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);
		}
		// Xoa 1 Khach hang khoi database
		if (action.equals("removeCustomer")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean remove = true;
			if (remove) {

				// lay danh sach
				String url = "/ControllerAdmin?action=quanlikhachhang";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.print("Error Remove Customer in Database");
			}
		}

		// *****************************************************Quan li Sáº£n pháº©m
		if (action.equals("truyXuatSanPham")) {
			ArrayList<Product> listProduct = new ProductDAO().getListProduct();
			request.setAttribute("listProductAdmin", listProduct);
			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("makeSureRemoveProduct")) {
//			int id = Integer.parseInt(request.getParameter("id"));
			PrintWriter pw = response.getWriter();
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Ä�Ã£ xÃ³a thÃ nh cÃ´ng sáº£n pháº©m!\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");

			String url = "/admin/product/quanlisanpham.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);

		}
		if (action.equals("removeProduct")) {
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
				pw.println("swal ( \"ThÃ´ng bÃ¡o\" ,  \"Ä�Ã£ xÃ³a thÃ nh cÃ´ng sáº£n pháº©m!\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");

				String url = "/admin/product/quanlisanpham.jsp";

				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);
			} else {

			}
		}
		if (action.equals("findProduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			hethongthongtin.Product p = new hethongthongtin.ProductDAO().lookProduct(id);
			request.setAttribute("p", p);
			String url = "/admin/editProduct.jsp";
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
		if (action.equals("addProduct")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String description = request.getParameter("moTa");
			double price = Double.parseDouble(request.getParameter("price"));
			new hethongthongtin.ProductDAO().addProduct(id, name, description, price);
			String url = "/ControllerAdmin?action=truyXuatSanPham";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);
		}

		// **************************************************** Quan li hoa don
		// hien thi chi tiet 1 hoa don
		if (action.equals("displayInvoice1")) {
			// b1: lay Id gui tu jsp
			HttpSession session = request.getSession();
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
			session.setAttribute("invoiceInvoice1", invoice);
			session.setAttribute("userInvoice1", user);
			session.setAttribute("shopInvoice1", shop);
			// b4: chuyen trang
			String url = "/admin/invoice/view_invoice.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("removeInvoice")) {
			int idInvoice = Integer.parseInt(request.getParameter("idInvoice"));
			// xoa ItemCart truoc
			// xoa Invoice
			new InvoiceDB().removeItemCart(idInvoice);
			new InvoiceDB().removeInvoice(idInvoice);
			// hien thong bao
			request.setAttribute("removeInvoiceDone", "XÃ³a thanh cÃ´ng hÃ³a Ä‘Æ¡n" + idInvoice);
			String url = "/admin/invoice/quanlihoadon.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

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
		//cap nhat hoa don
		
		
		// gửi mail nhân viên
		if (action.equals("sendMail")) {
			HttpSession session = request.getSession();
			Customer cus = (Customer) session.getAttribute("infoUser");
			Login user = (Login) session.getAttribute("user");
			String to = user.getEmail();
			String form = "thanhdien25598@gmail.com";
			String subject = "[Thông báo]";
			String body = "Thân chào " + cus.getUsername() + " ,\n"
					+ "Đơn hàng sẽ được giao từ 3-5 ngày. Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.";
			boolean isbodyHTML = false;

			MailUtil.sendMail(to, subject, body);

			// chuyen toi trang complete
			PrintWriter pw = response.getWriter();
			pw.println(
					"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"Thông báo\" ,  \"Đặt hàng thành công. Cảm ơn quý khách\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			String url = "/complete.jsp";
			// set lai cai so la 0
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
