package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import model_product.Product;
import model_product.ProductDAO;
import model_shoppingcart.Invoice;
import model_shoppingcart.InvoiceDB;
import model_shoppingcart.ItemCart;
import model_shoppingcart.ItemCartDB;
import model_shoppingcart.ShoppingCart;
import model_user.Customer;
import model_user.CustomerDAO;
import model_user.Login;
import model_user.LoginDAO;

/**
 * Servlet implementation class ControllerShopping
 */
@WebServlet("/ControllerShopping")
public class ControllerShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerShopping() {
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
		new ProductDAO().getListProduct();
		// ********************************************************************* xu li
		// cho gio hang
		if (action.equals("addCart")) {

			// lay session CART len
			HttpSession ss = request.getSession();
			ShoppingCart cart = (ShoppingCart) ss.getAttribute("cart");
			PrintWriter pw = response.getWriter();
			// neu trong qua khu chua setAtribute Cart tuc la gia tri null
			if (cart == null) {
				cart = new ShoppingCart();// tao va luu
				ss.setAttribute("cart", cart);
			}
			// lay id SP
			int id = Integer.parseInt(request.getParameter("id"));
			// tim SP trong DB
			Product p = new ProductDAO().lookUp(id);
			int soLuongTrongKho = p.getSoLuongTrongKho();
			// 1. tim coi cai san pham co ma la P da ton tai chua
			ItemCart ite = cart.lookup(p.getId());
			// 1.1: neu chu ton tai thi dat san pham do dc them vao gio hanng voi quatity la
			if (ite == null) {
				// kiem tra so luong san pham trong kho co > 1 khong?
				if (soLuongTrongKho >= 1) {
					cart.addProduct(new ItemCart(p, 1));
					// tru so luong trong list xuong 1
					new ProductDAO().updateProductInList(id, soLuongTrongKho - 1, ProductDAO.listProduct);
					response.sendRedirect("GioHang.jsp");
				} else {
					// thong bao het hang tai trang gio hang
					pw.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					pw.println(
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
					pw.println("<script type=\"text/javascript\">");
					pw.println("	$(document).ready(function(){");
					pw.println(
							"swal ( \"Thông báo\" ,  \"Số lượng sản phẩm không đủ để thêm vào giỏ!\" ,  \"error\" )");
					pw.println("});");
					pw.println("</script>");
					getServletContext().getRequestDispatcher("/GioHang.jsp").include(request, response);
				}
			}
			// 1.2: neu da ton tai roi
			if (ite != null) {
				// kiem tra so luong trong kho > quantity khong
				if (soLuongTrongKho >= ite.getQuantity() + 1) {
					ite.setQuantity(ite.getQuantity() + 1);
					new ProductDAO().updateProductInList(id, soLuongTrongKho - 1, ProductDAO.listProduct);
					response.sendRedirect("GioHang.jsp");
				} else {
//					ite.setQuantity(ite.getQuantity());
					pw.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					pw.println(
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
					pw.println("<script type=\"text/javascript\">");
					pw.println("	$(document).ready(function(){");
					pw.println("swal ( \"Thông báo\" ,  \"Số lượng sản phẩm không đủ để chọn tiếp!\" ,  \"error\" )");
					pw.println("});");
					pw.println("</script>");
					getServletContext().getRequestDispatcher("/GioHang.jsp").include(request, response);
				}
			}
			// chuyen toi trang gio hang cua khach hang

		}
		// end: addCart
		if (action.equals("single")) {
			// lay id SP len
			int id = Integer.parseInt(request.getParameter("id"));
			// lay san pham vua add tu danh sach he thong
			Product p = new ProductDAO().lookUp(id);
			// luu cai sp vao request
			request.setAttribute("singleProduct", p);
			// chuyen toi trang single
			getServletContext().getRequestDispatcher("/single.jsp").forward(request, response);
		}
//		// tang so luong
		if (action.equals("increaseQuantity")) {
			try {
				HttpSession session = request.getSession();
				ShoppingCart shop = (ShoppingCart) session.getAttribute("cart");
				PrintWriter pw = response.getWriter();
				// lay vi tri index
				int index = Integer.parseInt(request.getParameter("index"));
				ItemCart p = shop.getListItemcart().get(index);
				boolean increase = shop.tangQuantity(index);
				if (increase == true) {
					new ProductDAO().updateProductInList(p.getP().getId(), p.getP().getSoLuongTrongKho() - 1,
							ProductDAO.listProduct);
					response.sendRedirect("GioHang.jsp");
				} else {
					pw.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					pw.println(
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
					pw.println("<script type=\"text/javascript\">");
					pw.println("	$(document).ready(function(){");
					pw.println(
							"swal ( \"Thông báo\" ,  \"Số lượng sản phẩm không đủ để tăng số lượng!\" ,  \"error\" )");
					pw.println("});");
					pw.println("</script>");
					getServletContext().getRequestDispatcher("/GioHang.jsp").include(request, response);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		// giam so luong
		if (action.equals("decreaseQuantity")) {
			try {
				HttpSession session = request.getSession();
				ShoppingCart shop = (ShoppingCart) session.getAttribute("cart");
				PrintWriter pw = response.getWriter();
				// lay vi tri index trong gio hang
				int index = Integer.parseInt(request.getParameter("index"));
				ItemCart p = shop.getListItemcart().get(index);
				boolean giam = shop.giamQuantity(index);
				if (giam == true) {
					new ProductDAO().updateProductInList(p.getP().getId(), p.getP().getSoLuongTrongKho() + 1,
							ProductDAO.listProduct);
					response.sendRedirect("GioHang.jsp");
				} else {
					pw.println(
							"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
					pw.println(
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
					pw.println("<script type=\"text/javascript\">");
					pw.println("	$(document).ready(function(){");
					pw.println("swal ( \"Thông báo\" ,  \"Số lượng sản phẩm phải tối thiểu là 1!\" ,  \"error\" )");
					pw.println("});");
					pw.println("</script>");
					getServletContext().getRequestDispatcher("/GioHang.jsp").include(request, response);

				}

			} catch (Exception e) {
			}

		}
		if (action.equals("removeItemCart")) {
			// 1. lay session khach hang len
			HttpSession session = request.getSession();
			ShoppingCart shop = (ShoppingCart) session.getAttribute("cart");
			PrintWriter pw = response.getWriter();
			// 2. lay danh sach gio hang len
			ArrayList<ItemCart> list = (ArrayList<ItemCart>) shop.getListItemcart();
			// 3. lay chi so index can xoa

			int index = Integer.parseInt(request.getParameter("index"));
			ItemCart i = list.get(index);
			int quan = i.getQuantity();
			list.remove(index);
			// 4. tang quantityProduct trong List
			new ProductDAO().updateProductInList(i.getP().getId(), quan, ProductDAO.listProduct);
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
			pw.println(
					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
			pw.println("<script type=\"text/javascript\">");
			pw.println("	$(document).ready(function(){");
			pw.println("swal ( \"Thông báo\" ,  \"Xóa thành công SP khỏi giỏ hàng\" ,  \"success\" )");
			pw.println("});");
			pw.println("</script>");
			getServletContext().getRequestDispatcher("/GioHang.jsp").include(request, response);

		}
//		// loc theo type SP
		if (action.equals("filterGroup")) {
			// 1. lay chuoi dk can loc ra
			String type = request.getParameter("group");
			PrintWriter out = response.getWriter();
			// 2. goi phuong thuc filter trong ProductDAO
			ArrayList<Product> filterType = new ProductDAO().queryGroupProduct(type);
			// 3. luu danh sach xuong request + luu cai type de hien len breabcrumb
			request.setAttribute("filter", filterType);
			request.setAttribute("groupProduct", type);
			// 4. chuyent truc tiep toi trang filterProduct.jsp
			request.getRequestDispatcher("/filterProduct.jsp").forward(request, response);
		}

		if (action.equals("checkUser")) {
			// lay session User len
			HttpSession session = request.getSession();
			Login customer = (Login) session.getAttribute("user");

			if (customer == null) {
				// kiem tra cookie

				// neu chua dang nhap chuyen toi trang login
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				// neu da dang nhap roi
				// bat dau xu li hoa don
				Date today = new Date();
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
				Customer cu = new CustomerDAO().mappingUserInfo(customer.getIdUser());
				if (cu == null) {
					// chua co tao profile
					cu = new Customer(customer.getIdUser(), "", "", "", "");
					// ghi xuong Database
					new CustomerDAO().add(customer.getIdUser(), cu.getUsername(), cu.getFullName(), cu.getPhone(),
							cu.getAddress());
				}
				// tao hoa don: business
				Invoice invoice = new Invoice(new InvoiceDB().dynamicID(), cu, today, cart, false);
				// luu xuong seesion
				session.setAttribute("infoUser", cu);
				session.setAttribute("invoice", invoice);
				getServletContext().getRequestDispatcher("/hoadon.jsp").forward(request, response);
			}
		}
		// dang nhap
		if (action.equals("login")) {
			// lay cac gia tri trong form
			String email = request.getParameter("Name");
			String pass = request.getParameter("Password");
			String url = "";
			// kiem tra email da dang ki chua
			Login user = new LoginDAO().lookUpEmail(email);
			// TH1: neu email da ton tai trong he thong
			// k1: 1. Mat khau dung hay chua thoi
			if (user != null) {
				if (pass.equals(user.getPass())) {// mhap dung pass
					// 1. luu session hoa don
					// 2. chuyen toi trang can chuyen toi
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					// lay session cua khach hang
					ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
					// neu trong qua khu chua setAtribute khach hang tuc la gia tri null
					if (cart == null) {
						// chuyen toi trang dang nhap
						cart = new ShoppingCart();
						session.setAttribute("cart", cart);
					}
					getServletContext().getRequestDispatcher("/GioHang.jsp").forward(request, response);
					// neu o trang checkOut thi chuyen toi trang hoa don
					// neu o cac trang khach thi o trang index

				} else {
					// nhap sai pass
					request.setAttribute("emailRe", email);
					request.setAttribute("pass_err", "Password không đúng, nhập lại");
					getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}

			} else {
				// email chua dang ki tai khoan
				// chuyen ve trang register.jsp
				// hien thong bao:"email chua dang ki"
				request.setAttribute("emailChuaDK", "Email chưa đăng kí trong hệ thống! Mời đăng kí");
				request.setAttribute("email", email);
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}

		}

		if (action.equals("logout")) {
			// chi huy session cua User thoi

			HttpSession session = request.getSession();
			session.removeAttribute("user");
			// thong bao dang xuat thanh cong
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

		if (action.equals("register")) {
			String Email = request.getParameter("Email");
			String pass = request.getParameter("Password");
			String repass = request.getParameter("ConfirmPassword");
			// luu de tra ve
			request.setAttribute("email", Email);
			// 1. kiem tra email coi co dk chua
			// 1.1: neu da dk roi thi chuyen toi trang dang nhap
			// 1.2: neu chua dk thi thuc hien thu tuc ghi thong tin user xuong
			Login user = new LoginDAO().lookUpEmail(Email);
			String url = "";
			if (user != null) {
				// da dang ki bang email
				request.setAttribute("daDK", "Email đã được dùng để đăng kí, Mời đăng nhập");
				url = "/login.jsp";
			} else {
				// email chua tung dk: thuc hien dang ki
				// 1. dien het vao form roi

				if (Email != null && pass != null && repass != null) {
					// dien het thi kt pass coi 2 cai giong nhau chua
					if (!pass.equals(repass)) {
						url = "/register.jsp";
						request.setAttribute("dont_register", "Mật khẩu xác nhận không khớp");

					} else {
						// hoan thanh tat ca thu tuc => luu xuong database
						int id = LoginDAO.dynamicID(new LoginDAO().getListLogin());
						boolean add = new LoginDAO().addUser(id, Email, pass);
						if (add == true) {
							request.setAttribute("dkThanhCong", "Đăng kí thành công");
							url = "/login.jsp";
						} else {
							url = "/login.jsp";
						}
					}

				}

				if (Email == null || Email.equals("") || pass == null || pass.equals("") || repass.equals("")
						|| repass == null) {

					if (Email == null || Email.equals("")) {

						request.setAttribute("email_error_register", "Không bỏ trống trường Email");
						url = "/register.jsp";

					}
					if (pass == null || pass.equals("")) {

						request.setAttribute("pass_error_register", "Không bỏ trống trường Password");
						url = "/register.jsp";

					}
					if (repass == null || repass.equals("")) {

						request.setAttribute("repass_error_register", "Không bỏ trống trường Confirm Password");
						url = "/register.jsp";

					}

					if (pass != null && repass != null) {
						if (!pass.equals(repass)) {
							request.setAttribute("dont_register", "Mật khẩu xác nhận không khớp");
							url = "/register.jsp";

						}
					}

				}

			}
			// chuyen trang TH2
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		if (action.equals("completeOrder")) {
			// 1. luu hoa don xuong database
			HttpSession session = request.getSession();
			Customer cus = (Customer) session.getAttribute("infoUser");

			if (cus.getUsername().equals("") || cus.getFullName().equals("") || cus.getPhone().equals("")
					|| cus.getAddress().equals("")) {
				// chuyen ve trang hoa don va thong bao ra loi
				request.setAttribute("thieuInfo", "Thông tin giao hàng chưa đầy đủ. Mời hoan tất form và click update");
				String url = "/hoadon.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.forward(request, response);
			} else {

				Invoice invoice = (Invoice) session.getAttribute("invoice");
				java.sql.Date sDate = new java.sql.Date(invoice.getToday().getTime());
				int i = new InvoiceDB().dynamicID();
				// cap nhat lai soLuongTrongKho cua Product
				invoice.getShop().updateQuantityProduct(invoice.getShop().getListItemcart());
				// ghi hoa don xuong DB
				new InvoiceDB().add(i, invoice.getUser().getId(), sDate, invoice.getShop().totalPrice(), false);
				// ghi DS ItemCart xuong DB
				List<ItemCart> listItem = invoice.getShop().getListCart();
				for (ItemCart item : listItem) {
					new ItemCartDB().insert(i, item);
				}
				// 2. luu email xuong cookie

				// 3. xoa gio hang hien tai
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
				cart.setListCart(new ArrayList<ItemCart>());

				// 4. gui mail cho khach hang

				// chuyen toi trang complete
				String url = "/complete.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.forward(request, response);
			}

		}
		if (action.equals("infoShip")) {
			// b1:lay gia tri cua cac truong trong form len
			String userName = request.getParameter("user");
			String fullName = request.getParameter("fullName");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String url = "";
			// luu cac gia tri gui ve form
			request.setAttribute("info_reUserName", userName);
			request.setAttribute("info_reFullName", fullName);
			request.setAttribute("info_rePhone", phone);
			request.setAttribute("info_reAddress", address);

			// b2: kiem tra cac ngoai le
			if (userName.equals("") || userName == null || fullName.equals("") || fullName == null || phone.equals("")
					|| phone == null || address.equals("") || address == null) {
				// Neu co 1 trong cac truong rong
				if (userName.equals("") || userName == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoName", "Không được để trống UserName");

				}
				if (fullName.equals("") || fullName == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoFullName", "Không được để trống Full Name");

				}
				if (phone.equals("") || phone == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoPhone", "Không được để trống Phone");

				}
				if (address.equals("") || address == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoAddress", "Không được để trống Address");

				}
				if (phone != null) {
					// da dien vao phone roi thi kiem tra coi sdt co hop le khong
					char[] arr = phone.toCharArray();
					java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d*");
					java.util.regex.Matcher matcher = pattern.matcher(phone);
					if (!matcher.matches() || arr.length != 10) {
						// khong hop le
						url = "/hoadon.jsp";
						request.setAttribute("erro_phone_info", "Số điện thoại không hợp lệ");
					}

				}

			} else {
				// cac truong da dien du
				// 1. kiem tra sdt
				char[] arr = phone.toCharArray();
				java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d*");
				java.util.regex.Matcher matcher = pattern.matcher(phone);
				if (!matcher.matches() || arr.length != 10) {
					// khong hop le
					url = "/hoadon.jsp";
					request.setAttribute("erro_phone_info", "Số điện thoại không hợp lệ");

				} else {
					// Neu thoa cac dieu kien thi set cac truong cho Customer + edit lai UserInfo DB
					// + tro lai trang hoa don

					HttpSession session = request.getSession();
					Customer info = (Customer) session.getAttribute("infoUser");
					info.setUsername(userName);
					info.setFullName(fullName);
					info.setAddress(address);
					info.setPhone(phone);
					// cap nhat lai duoi UserInfo DB
					new CustomerDAO().edit(info.getId(), info.getUsername(), info.getFullName(), info.getPhone(),
							info.getAddress());
					url = "/hoadon.jsp";
				}

			}

			// chuyen trang
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);

		}
		if (action.equals("menu")) {
			String value = request.getParameter("value");
			// 2. goi phuong thuc filter trong ProductDAO
			ArrayList<Product> filterType = new ProductDAO().queryGroupProduct(value);
			// 3. luu danh sach xuong request + luu cai type de hien len breabcrumb
			request.setAttribute("filter", filterType);
			request.setAttribute("groupProduct", value);
			// 4. chuyent truc tiep toi trang filterProduct.jsp
			request.getRequestDispatcher("/filterProduct.jsp").forward(request, response);
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
