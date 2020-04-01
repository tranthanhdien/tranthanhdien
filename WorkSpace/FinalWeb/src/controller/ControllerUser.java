package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model_shoppingcart.InvoiceDB;
import model_user.Customer;
import model_user.CustomerDAO;
import model_user.Login;
import model_user.LoginDAO;
import model_user.User;

/**
 * Servlet implementation class ControllerUser
 */
@WebServlet("/ControllerUser")
public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dau tieng viet
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("action");
		// lay danh sach
		if (action.equals("quanlikhachhang")) {
			// truy suat danh sach
			ArrayList<User> list = new CustomerDAO().getListUser();
			request.setAttribute("listUser", list);
			String url = "/admin/customer/quanlikhachhang.jsp";
			RequestDispatcher re = getServletContext().getRequestDispatcher(url);
			re.forward(request, response);
		}
		// xoa 1 user o trang quanli
		if (action.equals("remove")) {
			try {
				// lay id KH
				int id = Integer.parseInt(request.getParameter("id"));
				// update IDUser truoc + xóa userInfo trước + xoa userpass sau
				new InvoiceDB().editIDUser(id);
				new CustomerDAO().remove(id);
				new LoginDAO().remove(id);

				PrintWriter out = response.getWriter();
				// dat lai danh sach
				ArrayList<User> list = new CustomerDAO().getListUser();
				request.setAttribute("listUser", list);
				// thong bao
				out.print("Xóa thành công khách hàng: " + id);

			} catch (Exception e) {

			}
		}
		// xoa o view
		if (action.equals("removeview")) {
			try {
				// lay id KH
				int id = Integer.parseInt(request.getParameter("id"));
				// update IDUser truoc + xóa userInfo trước + xoa userpass sau
				new InvoiceDB().editIDUser(id);
				new CustomerDAO().remove(id);
				new LoginDAO().remove(id);

				PrintWriter out = response.getWriter();
				// dat userrong
				request.setAttribute("lookUser", new User());
				// thong bao
				out.print("Xóa thành công khách hàng: " + id);

			} catch (Exception e) {

			}
		}
		// sua thong tin user
		if (action.equals("edit")) {
			try {
				// b1: lay cac gia tri tu form
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String fullname = request.getParameter("fullname");
				String pass = request.getParameter("pass");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String Admin = request.getParameter("admin");
				boolean check = false;
				if (Admin.equals("yes")) {
					check = true;
				}
				// b2: luu xuong DB
				new LoginDAO().edit2(id, email, pass, check);
				new CustomerDAO().edit(id, name, fullname, phone, address);
			
				// set lai user
				Login login = new LoginDAO().lookUpID(id);
				Customer customer = new CustomerDAO().mappingUserInfo(id);
				User u = new User(customer, login);
				request.setAttribute("lookUser", u);
				// thong bao
				PrintWriter pw = response.getWriter();
				pw.println(
						"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>");
				pw.println(
						"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js\"></script>");
				pw.println("<script type=\"text/javascript\">");
				pw.println("	$(document).ready(function(){");
				pw.println("swal ( \"\" ,  \"Sửa thành công\" ,  \"success\" )");
				pw.println("});");
				pw.println("</script>");
				String url = "/admin/customer/edit.jsp";
				RequestDispatcher re = getServletContext().getRequestDispatcher(url);
				re.include(request, response);

			} catch (Exception e) {

			}
		}
		// them 1 user
		if (action.equals("add")) {
			PrintWriter pw = response.getWriter();
			try {
				// b1: lay cac gia tri tu form
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String fullname = request.getParameter("fullname");
				String pass = request.getParameter("pass");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String Admin = request.getParameter("admin");
				boolean check = false;
				if (Admin.equals("yes")) {
					check = true;
				}
				// kiem tra email ton tai chua

				new LoginDAO().addUser2(id, email, pass, check);
				new CustomerDAO().add(id, name, fullname, phone, address);

				ArrayList<User> list = new CustomerDAO().getListUser();
				request.setAttribute("listUser", list);
				// thong bao them thanh cong + chuyen va trang quanlisapham.jsp
				request.getRequestDispatcher("/admin/customer/quanlikhachhang.jsp").forward(request, response);

			} catch (Exception e) {
				// TODO: handle exception

			}

		}

		// tim 1 nguoi dung dua vao ID *
		if (action.equals("lookUp")) {
			// b1: lay id
			int id = Integer.parseInt(request.getParameter("id"));
			// b2: tim kH
			Login login = new LoginDAO().lookUpID(id);
			Customer customer = new CustomerDAO().mappingUserInfo(id);
			User u = new User(customer, login);
			// b3: luu xuong request
			request.setAttribute("lookUser", u);
			// b4: chuyen toi trang truoc
			request.getRequestDispatcher("/admin/customer/view.jsp").forward(request, response);
		}
		// tim 1 nguoi dung dua vao ID *
		if (action.equals("lookToEdit")) {
			// b1: lay id
			int id = Integer.parseInt(request.getParameter("id"));
			// b2: tim kH
			Login login = new LoginDAO().lookUpID(id);
			Customer customer = new CustomerDAO().mappingUserInfo(id);
			User u = new User(customer, login);
			// b3: luu xuong request
			request.setAttribute("lookUser", u);
			// b4: chuyen toi trang truoc
			request.getRequestDispatcher("/admin/customer/edit.jsp").forward(request, response);
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
