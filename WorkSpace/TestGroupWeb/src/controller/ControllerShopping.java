package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model_product.ItemCart;
import model_product.Product;
import model_product.ProductDAO;
import model_product.ShoppingCart;

import model_user.Customer;
import model_user.CustomerDAO;

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

		//********************************************************************* xu li cho gio hang
		if (action.equals("addCart")) {

			// lay session cua khach hang
			HttpSession ss = request.getSession();

			// neu trong qua khu chua setAtribute khach hang tuc la gia tri null
			if (ss.getAttribute("customer") == null) {
				// chuyen toi trang dang nhap
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

			} else {
				// neu da dk roi

				int id = Integer.parseInt(request.getParameter("id"));
				// lay san pham vua add tu danh sach he thong tu ID
				model_product.Product p = new ProductDAO().lookUp(id);

				// lay session khach hang da dang nhap truoc do ra
				ShoppingCart shop = (ShoppingCart) ss.getAttribute("customer");
				// 1. tim coi cai san pham co ma la P da ton tai chua
				ItemCart ite = shop.lookup(p.getId());
				// 1.1: neu chu ton tai thi dat san pham do dc them vao gio hanng voi quatity la
				// 1
				if (ite == null) {
					shop.addProduct(new ItemCart(p, 1));
				}
				// 1.2: neu da ton tai roi
				if (ite != null) {
					ite.setQuantity(ite.getQuantity() + 1);
				}

				// chuyen toi trang gio hang cua khach hang
				response.sendRedirect("GioHang.jsp");
			}
		} // end: addCart
		if(action.equals("single")) {
			
			//lay id SP len
			int id = Integer.parseInt(request.getParameter("id"));
			// lay san pham vua add tu danh sach he thong
			
			Product p = new ProductDAO().lookUp(id);
		
			//lay danh sach loai san pham lien quan len
		
			//luu cai sp vao request
			request.setAttribute("singleProduct", p);
			//chuyen toi trang single
			getServletContext().getRequestDispatcher("/single.jsp").forward(request, response);
		}
		//tang so luong
		if(action.equals("increaseQuantity")) {
			try {
				HttpSession session = request.getSession();
				ShoppingCart shop = (ShoppingCart) session.getAttribute("customer");
				//lay vi tri index
				int index = Integer.parseInt(request.getParameter("index"));
				
				shop.tangQuantity(index);
				
				response.sendRedirect("GioHang.jsp");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		//giam so luong
		if(action.equals("decreaseQuantity")) {
			try {
				HttpSession session = request.getSession();
				ShoppingCart shop = (ShoppingCart) session.getAttribute("customer");
				//lay vi tri index
				int index = Integer.parseInt(request.getParameter("index"));
				
				shop.giamQuantity(index);
				
				response.sendRedirect("GioHang.jsp");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		if(action.equals("removeItemCart")) {
			// 1. lay session khach hang len
			HttpSession session = request.getSession();
			ShoppingCart shop = (ShoppingCart) session.getAttribute("customer");

			// 2. lay danh sach gio hang len
			ArrayList<ItemCart> list = (ArrayList<ItemCart>) shop.getListItemcart();

			// 3. lay chi so index can xoa
			int index = Integer.parseInt(request.getParameter("index"));
			list.remove(index);
			response.sendRedirect("GioHang.jsp");
			
		}
		//loc theo type SP
		if(action.equals("filterGroup")) {
			//1. lay chuoi dk can loc ra
			String type = request.getParameter("group");
			PrintWriter out = response.getWriter();
			
			//2. goi phuong thuc filter trong ProductDAO
			ArrayList<Product> filterType = new ProductDAO().queryGroupProduct(type);

			//3. luu danh sach xuong request + luu cai type de hien len breabcrumb
			request.setAttribute("filter", filterType);
			request.setAttribute("groupProduct", type);
			//4. chuyent truc tiep toi trang filterProduct.jsp
			request.getRequestDispatcher("/filterProduct.jsp").forward(request, response);
		}
		
		
		

		//************************************************************** xu li phan dang nhap
		if (action.equals("login")) {

			String email = request.getParameter("Name");
			String pass = request.getParameter("Password");
			String url = "";

			// kiem tra email da dang ki
			Customer user = CustomerDAO.lookUpEmail(email);

			// neu email da ton tai trong he thong
			// k1: 1. Mat khau dung hay chua thoi
			if (user != null) {
				if (pass.equals(user.getPass())) {// mhap dung pass
					// luu session
					// chuyen toi trang index.jsp
					HttpSession session = request.getSession();
					ShoppingCart shopping = new ShoppingCart(user);
					session.setAttribute("customer", shopping);
					url = "/index.jsp";

				} else {
					// nhap sai pass
					request.setAttribute("emailRe", email);
					request.setAttribute("pass_err", "Password không đúng, nhập lại");
					url = "/login.jsp";
				}

			} else {
				// email chua dang ki tai khoan
				// chuyen ve trang register.jsp
				// hien thong bao:"email chua dang ki"
				request.setAttribute("emailChuaDK", "Email chưa đăng kí trong hệ thống! Mời đăng kí");
				request.setAttribute("email", email);
				url = "/register.jsp";
			}
//			 chuyen trang
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} // end action=login

		if (action.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		}

		if (action.equals("register")) {

			String name = request.getParameter("Name");
			String Email = request.getParameter("Email");
			String pass = request.getParameter("Password");
			String repass = request.getParameter("ConfirmPassword");

			// luu de tra ve
			request.setAttribute("name", name);
			request.setAttribute("email", Email);
			// 1. kiem tra email coi co dk chua
			// 1.1: neu da dk roi thi chuyen toi trang dang nhap
			// 1.2: neu chua dk thi thuc hien thu tuc ghi thong tin user xuong
			Customer user = CustomerDAO.lookUpEmail(Email);
			String url = "";
			if (user != null) {
				// da dang ki bang email
				request.setAttribute("daDK", "Email đã được dùng để đăng kí, Mời đăng nhập");
				url = "/login.jsp";

			} else {
				// email chua tung dk: thuc hien dang ki

				// 1. dien het vao form roi

				if (name != null && Email != null && pass != null && repass != null) {
					// dien het thi kt pass coi 2 cai giong nhau chua
					if (!pass.equals(repass)) {
						url = "/register.jsp";
						request.setAttribute("dont_register", "Mật khẩu xác nhận không khớp");

					} else {

//						PrintWriter out = response.getWriter();
//						out.println("dljkm");
//						// hoan thanh tat ca thu tuc=> tao
						boolean add = CustomerDAO.addCustomerOnDatabase(1, name, Email, pass);
						if (add) {
							request.setAttribute("dkThanhCong", "Đăng kí thành công");
							url = "/login.jsp";
						} else {
							url = "/login.jsp";
						}
					}

				}

				if (name == null || name.equals("") || Email == null || Email.equals("") || pass == null
						|| pass.equals("") || repass.equals("") || repass == null) {
					if (name == null || name.equals("")) {

						request.setAttribute("name_error_register", "Không bỏ trống trường UserName");
						url = "/register.jsp";

					}
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
