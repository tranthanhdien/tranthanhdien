package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
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

import model_mail.MailUtil;
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

@WebServlet("/ControllerShopping")
public class ControllerShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerShopping() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set tiếng Việt
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		new ProductDAO().getListProduct();

		// xử lí thêm vào giỏ hàng
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
			// 1. tìm xem sản phẩm có mã đó tồn tại chưa
			ItemCart ite = cart.lookup(p.getId());
			// 1.1: neu chua ton tai thi dat san pham do dc them vao gio hanng voi quatity la
			if (ite == null) {
				// kiem tra so luong san pham trong kho co > 1 khong?
				if (soLuongTrongKho >= 1) {
					cart.addProduct(new ItemCart(p, 1));
					// tru so luong trong list xuong 1
					new ProductDAO().updateProductInList(id, soLuongTrongKho - 1, ProductDAO.listProduct);

					ss.setAttribute("numbercart", cart.numberProduct());

					if (ss.getAttribute("language") == null) {
						pw.print("Số lượng sản phẩm: " + cart.numberProduct() + "\t" + cart.numberProduct());
					} else {
						String s = (String) ss.getAttribute("language");
						if (s.equals("VN")) {
							pw.print("Số lượng sản phẩm: " + cart.numberProduct() + "\t" + cart.numberProduct());
						}
						if (s.equals("EN")) {
							pw.print("Quantity product: " + cart.numberProduct() + "\t" + cart.numberProduct());
						}
					}

				} else {
					if (ss.getAttribute("language") == null) {
						pw.print("Hết hàng: " + cart.numberProduct());
					} else {
						String s = (String) ss.getAttribute("language");
						if (s.equals("VN")) {
							pw.print("Hết hàng: " + cart.numberProduct());
						}
						if (s.equals("EN")) {
							pw.print("End: " + cart.numberProduct());
						}
					}
					ss.setAttribute("numbercart", cart.numberProduct());
				}
			}
			// 1.2: neu da ton tai roi
			if (ite != null) {
				// kiem tra so luong trong kho > quantity khong
				if (soLuongTrongKho >= ite.getQuantity() + 1) {
					ite.setQuantity(ite.getQuantity() + 1);
					new ProductDAO().updateProductInList(id, soLuongTrongKho - 1, ProductDAO.listProduct);
					if (ss.getAttribute("language") == null) {
						pw.print("Số lượng sản phẩm: " + cart.numberProduct() + "\t" + cart.numberProduct());
					} else {
						String s = (String) ss.getAttribute("language");
						if (s.equals("VN")) {
							pw.print("Số lượng sản phẩm: " + cart.numberProduct() + "\t" + cart.numberProduct());
						}
						if (s.equals("EN")) {
							pw.print("Quantity product: " + cart.numberProduct() + "\t" + cart.numberProduct());
						}
					}

					ss.setAttribute("numbercart", cart.numberProduct());
					// response.sendRedirect("GioHang.jsp");
				} else {
					pw.println("Số lượng sản phẩm không đủ để thêm. Cảm ơn " + "\t" + cart.numberProduct());
					ss.setAttribute("numbercart", cart.numberProduct());
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
				int result = shop.getListItemcart().get(index).getQuantity();
				session.setAttribute("numbercart", shop.numberProduct());
				pw.print(result + "\t" + shop.totalPrice());
			} catch (Exception e) {

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
				new ProductDAO().updateProductInList(p.getP().getId(), p.getP().getSoLuongTrongKho() + 1,
						ProductDAO.listProduct);
				int result = shop.getListItemcart().get(index).getQuantity();
				session.setAttribute("numbercart", shop.numberProduct());
				pw.print(result +  "\t" + shop.totalPrice());

			} catch (Exception e) {
			}

		}
		if (action.equals("removeItemCart")) {
			// 1. lay session khach hang len
			try {
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
				// 5. luu lai session
				session.setAttribute("cart", shop);
				session.setAttribute("numbercart", shop.numberProduct());
				// 6. thong bao
				pw.print("Xóa thành công Sản phẩm khỏi gio hàng");
			} catch (Exception e) {
				PrintWriter pw = response.getWriter();
				pw.print("Đang xóa");
			}
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
				// kiem tra cookie neu co thi tra ve login + hien thong tin
				Cookie[] cookies = request.getCookies();
				String emailAddress = null;
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						String name = cookies[i].getName();
						if (name.equals("emailCookie")) {
							emailAddress = cookies[i].getValue();
						}

					}
				}
				// truy suat pass dua vao email
				Login l = null;
				l = new LoginDAO().lookUpEmail(emailAddress);
				if (l != null) {
					// luu request chuyen ve trang login: email + pass
					request.setAttribute("emailRe", emailAddress);
					request.setAttribute("cookiePass", l.getPass());
					// thong bao tiep tuc dang nhap voi tu cach la userName
					Customer c = new CustomerDAO().mappingUserInfo(l.getIdUser());
					request.setAttribute("tieptuc", "Tiếp tục đăng nhập với tư cách là " + c.getUsername());
				}
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
					cu = new Customer(customer.getIdUser(), "no name", "no fullname", "no phone", "no address");
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
					// luu lai cookie la cai email => dk bang tai khoan khac
					// 2. luu email vao cookie
					Cookie emailCookie = new Cookie("emailCookie", email);
					emailCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
					emailCookie.setPath("/");
					response.addCookie(emailCookie);
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
				request.setAttribute("emailChuaDK", "Email chÆ°a Ä‘Äƒng kÃ­ trong há»‡ thá»‘ng! Má»�i Ä‘Äƒng kÃ­");
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
				request.setAttribute("daDK", "Email Ä‘Ã£ Ä‘Æ°á»£c dÃ¹ng Ä‘á»ƒ Ä‘Äƒng kÃ­, Má»�i Ä‘Äƒng nháº­p");
				url = "/login.jsp";
			} else {
				// email chua tung dk: thuc hien dang ki
				// 1. dien het vao form roi

				if (Email != null && pass != null && repass != null) {
					// dien het thi kt pass coi 2 cai giong nhau chua
					if (!pass.equals(repass)) {
						url = "/register.jsp";
						request.setAttribute("dont_register", "Máº­t kháº©u xÃ¡c nháº­n khÃ´ng khá»›p");

					} else {
						// hoan thanh tat ca thu tuc => luu xuong database
						int id = LoginDAO.dynamicID(new LoginDAO().getListLogin());
						// luu vao userpass duoi DB + luu ID vao userInfo
						boolean add = new LoginDAO().addUser(id, Email, pass);
						if (add == true) {
							// 1. luu ID vao userInfo
							new CustomerDAO().add(id, "no name", "no fullname", "no phone", "no address");
							// 2. luu email vao cookie
							Cookie emailCookie = new Cookie("emailCookie", Email);
							emailCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
							emailCookie.setPath("/");
							response.addCookie(emailCookie);

							request.setAttribute("dkThanhCong", "Đăng kí thành công");
							request.setAttribute("emailRe", Email);
							request.setAttribute("cookiePass", pass);
							url = "/login.jsp";
						} else {
							url = "/login.jsp";
						}
					}

				}

				if (Email == null || Email.equals("") || pass == null || pass.equals("") || repass.equals("")
						|| repass == null) {

					if (Email == null || Email.equals("")) {

						request.setAttribute("email_error_register", "KhÃ´ng bá»� trá»‘ng trÆ°á»�ng Email");
						url = "/register.jsp";

					}
					if (pass == null || pass.equals("")) {

						request.setAttribute("pass_error_register", "KhÃ´ng bá»� trá»‘ng trÆ°á»�ng Password");
						url = "/register.jsp";

					}
					if (repass == null || repass.equals("")) {

						request.setAttribute("repass_error_register", "KhÃ´ng bá»� trá»‘ng trÆ°á»�ng Confirm Password");
						url = "/register.jsp";

					}

					if (pass != null && repass != null) {
						if (!pass.equals(repass)) {
							request.setAttribute("dont_register", "Máº­t kháº©u xÃ¡c nháº­n khÃ´ng khá»›p");
							url = "/register.jsp";

						}
					}

				}

			}
			// chuyen trang TH2
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		// quen mat khau
		if (action.equals("forgotPass")) {
			// gui mat khau ve email

			String to = request.getParameter("email");
			// tim tai lhoan du vao email
			Login l = new LoginDAO().lookUpEmail(to);

			if (l != null) {

				String subject = "Passworld";
				String body = "Your passworld is: " + l.getPass() + "\n\n" + "Click to login: "
						+ "http://localhost:8080/WebProject_Backup/login.jsp";
				boolean isbodyHTML = false;

				MailUtil.sendMail(to, subject, body);
				// chuyen lai trang dang nhap
				String url = "/login.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {
				request.setAttribute("email", to);
				// chuyen lai trang forgot pass
				String url = "/forgotPass.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}

		}
		if (action.equals("completeOrder")) {
			// 1. luu hoa don xuong database
			HttpSession session = request.getSession();
			Customer cus = (Customer) session.getAttribute("infoUser");

			if (cus.getUsername().equals("no name") || cus.getFullName().equals("no fullname")
					|| cus.getPhone().equals("no phone") || cus.getAddress().equals("no address")) {
				// chuyen ve trang hoa don va thong bao ra loi
				request.setAttribute("thieuInfo",
						"Bạn cần hoàn tất thông tin cá nhân và chọn Cập Nhật trước khi đặt hàng. Cảm ơn");
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
				// bo gio hang vao cai Shopping tam de hien thi 1 lan cuoi nen dat vao request,
				// gui ve form hoan tat
				ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
				ShoppingCart temp = new ShoppingCart();
				temp.setListCart(cart.getListCart());
				// 3. xoa gio hang hien tai
				request.setAttribute("tempCart", temp);
				cart.setListCart(new ArrayList<ItemCart>());
				// 4. gui mail cho khach hang thong bao don hang thanh cong
				Login user = (Login) session.getAttribute("user");
				String to = user.getEmail();
				String form = "thanhdien25598@gmail.com";
				String subject = "Hoàn tất đơn hàng";
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
				session.setAttribute("numbercart", invoice.getShop().numberProduct());
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);
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
					request.setAttribute("infoName", "KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng UserName");

				}
				if (fullName.equals("") || fullName == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoFullName", "KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng Full Name");

				}
				if (phone.equals("") || phone == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoPhone", "KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng Phone");

				}
				if (address.equals("") || address == null) {
					url = "/hoadon.jsp";
					request.setAttribute("infoAddress", "KhÃ´ng Ä‘Æ°á»£c Ä‘á»ƒ trá»‘ng Address");

				}
				if (phone != null) {
					// da dien vao phone roi thi kiem tra coi sdt co hop le khong
					char[] arr = phone.toCharArray();
					java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\d*");
					java.util.regex.Matcher matcher = pattern.matcher(phone);
					if (!matcher.matches() || arr.length != 10) {
						// khong hop le
						url = "/hoadon.jsp";
						request.setAttribute("erro_phone_info", "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng há»£p lá»‡");
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
					request.setAttribute("erro_phone_info", "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng há»£p lá»‡");

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
		if (action.equals("userInfoUpdate")) {
			HttpSession session = request.getSession();
			Login user = (Login) session.getAttribute("user");
			int id = user.getIdUser();
			String userName = request.getParameter("userName");
			String realName = request.getParameter("realName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");

			boolean a = new CustomerDAO().edit(id, userName, realName, phone, address);
			boolean b = new LoginDAO().edit(id, email, user.getPass());
			user.setEmail(email);
			session.setAttribute("user", user);
			PrintWriter pw = response.getWriter();
			pw.print("Cập nhật thành công thông tin khách hàng");
//			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
//			pw.println(
//					"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
//			pw.println("<script type=\"text/javascript\">");
//			pw.println("	$(document).ready(function(){");
//			pw.println("swal ( \"Thông báo\" ,  \"Cập nhật thành công thông tin\" ,  \"success\" )");
//			pw.println("});");
//			pw.println("</script>");
//			getServletContext().getRequestDispatcher("/userinfo.jsp").include(request, response);

		}
		if (action.equals("detailInvoice")) {
			// lay ma hoa don
			int idInvoice = Integer.parseInt(request.getParameter("id"));
			// tim hoa don dua vao ma
			Invoice invoice = new InvoiceDB().lookInvoiceALL(idInvoice);
			request.setAttribute("invoiceUser", invoice);
			getServletContext().getRequestDispatcher("/detail_invoice.jsp").include(request, response);

		}
		if (action.equals("search")) {
			// lay gia tri tim
			String search = request.getParameter("Search");
			// tim
			ArrayList<Product> listProduct = null;
			listProduct = new ProductDAO().search(search);

			request.setAttribute("search", listProduct);
			request.setAttribute("searchTitle", search);
			// tra ve trang
			getServletContext().getRequestDispatcher("/search.jsp").include(request, response);
		}
		if (action.equals("languageVN")) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("language", "VN");
			PrintWriter out = response.getWriter();
			out.print("Ngôn ngữ hiện tại: Tiếng Việt");
		}
		if (action.equals("languageEN")) {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("language", "EN");
			PrintWriter out = response.getWriter();
			out.print("Current language is: English");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
