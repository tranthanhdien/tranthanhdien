package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLab3")
public class ServletLab3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLab3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String email = request.getParameter("email");
		String pwd = request.getParameter("matkhau");
		String re_pwd = request.getParameter("nhaplaimatkhau");
		String hoTen = request.getParameter("hovaten");
		String sdt = request.getParameter("sodienthoai");
		String sdđ = request.getParameter("sodidong");
		String address = request.getParameter("diachinha");
		RequestDispatcher dis = request.getRequestDispatcher("/lab3.jsp");
		boolean isCheck = false;
		
		if (email == null || email.equals("")) {
			request.setAttribute("mail", "Email không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);
		}
		if (pwd == null || pwd.equals("")) {
			request.setAttribute("pass", "Mật khẩu không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);

		}
		if (!re_pwd.equals(pwd)) {
			request.setAttribute("re_pass", "Mật khẩu không trùng khớp");
			isCheck = true;
			dis.forward(request, response);
		}
		if (hoTen == null || hoTen.equals("")) {
			request.setAttribute("hoten", "Họ tên không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);
		}
		if (sdt == null || sdt.equals("")) {
			request.setAttribute("phone_1", "Số đt không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);
		}
		if (sdđ == null || sdđ.equals("")) {
			request.setAttribute("phone_2", "Số dđ không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);
		}
		if (address == null || address.equals("")) {
			request.setAttribute("address", "Địa chỉ không được bỏ trống!");
			isCheck = true;
			dis.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("Bạn đã đăng kí thành công!");
		}
		
	}

	private void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String pwd = request.getParameter("matkhau");
			String re_pwd = request.getParameter("nhaplaimatkhau");
			String hoTen = request.getParameter("hovaten");
			String sdt = request.getParameter("sodienthoai");
			String sdđ = request.getParameter("sodidong");
			String address = request.getParameter("diachinha");
			
			boolean isCheck = false;
			RequestDispatcher dis = request.getRequestDispatcher("lab3.jsp");
			if (email.equals("")) {
				request.setAttribute("mail", "Không được bỏ trống!");
				isCheck = true;
			} else {
				request.setAttribute("mail", "");
			}
			if (isCheck) {
				out.println("html");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
