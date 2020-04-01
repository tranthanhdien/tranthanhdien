package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model_user.Customer;
import model_user.CustomerDAO;
import model_user.LoginDAO;

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
		if (action.equals("edit")) {
			try {
				// b1: lay cac gia tri tu form
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String pass = request.getParameter("pass");

				// b2: thuc hien
//				new CustomerDAO().edit(id, name, email, pass);
				response.sendRedirect("quanlikhachhang.jsp");

			} catch (Exception e) {

			}

		}

//		if (action.equals("add")) {
//			try {
//				// b1: lay cac gia tri tu form
//				int id = Integer.parseInt(request.getParameter("ma"));
//				String name = request.getParameter("ten");
//				String email = request.getParameter("email");
//				String pass = request.getParameter("pass");
//				String image = "";
//				// upload hinh anh len
//				String uploadFolder = "D:\\Nong Lam University\\webprogramming\\WebProject\\imageUser";
//				boolean uploadCompleted = false;
//				if (ServletFileUpload.isMultipartContent(request)) {
//					try {
//						ServletFileUpload sv = new ServletFileUpload(new DiskFileItemFactory());
//						List<FileItem> multiparts = sv.parseRequest(request);
//
//						for (FileItem fileItem : multiparts) {
//							if (!fileItem.isFormField()) {
//
//								String nameFile = new File(fileItem.getName()).getName();
//								File a = new File(uploadFolder);
//								if (!a.exists())
//									a.mkdir();
//								fileItem.write(new File(uploadFolder + "\\" + nameFile));
//								image = "imageUser/" + nameFile;
//
//							}
//
//						}
//						uploadCompleted = true;
//
//					} catch (Exception e) {
//						request.setAttribute("message", "File Upload Failed due to" + e);
//					}
//				} else {
//					request.setAttribute("message", "Sorry! Well done!");
//				}
//
//				if (uploadCompleted) {
//					request.setAttribute("message", "File Uploaded Successfully");
//				} else {
//
//					request.setAttribute("message", "File Uploaded Failed");
//				}
//
//				// thuc hien ghi du lieu xuong database => chuyen ve trang quan li khach hang
////				new CustomerDAO().add(id, name, email, pass, image);
//				response.sendRedirect("quanlikhachhang.jsp");
//
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//		}
		if (action.equals("remove")) {
			try {
				// b1: lay ma id tu jsp
				int id = Integer.parseInt(request.getParameter("id"));
				// thuc hien
				new CustomerDAO().remove(id);
				response.sendRedirect("quanlikhachhang.jsp");

			} catch (Exception e) {

			}
		}

		// xu li SEARCH
		if (action.equals("lookUp")) {
			// b1: lay cai chuoi tim kiem len
			String text = request.getParameter("search");

			// b2: bat dau tim kiem tren truong ID
//					ArrayList<Product> listSearch = null;

//					listSearch = new ProductDAO().search(text);

			// b3: luu danh sach do xuong request
//					request.setAttribute("listSearchID", listSearch);
			request.setAttribute("tk", text);

			// b4: chuyen toi trang truoc (index.jsp)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		if (action.equals("findProduct")) {
			// lay id tu jsp
			int id = Integer.parseInt(request.getParameter("id"));
			// lay list ban dau

			Customer c = new CustomerDAO().lookUpID(id);

			if (c != null) {
				// da tim ra User => luu xuong request
				request.setAttribute("user", c);
				getServletContext().getRequestDispatcher("/editUser.jsp").forward(request, response);

			}
			if (c == null) {
				// khong tim ra san pham
				PrintWriter out = response.getWriter();
				out.println("Stupid!!!!");
			}
		}
		if (action.equals("add")) {
			try {
				// b1: lay cac gia tri tu form
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String fullname = request.getParameter("fullname");
				String pass = request.getParameter("pass");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String address = request.getParameter("address");

				// kiem tra sdt va email coi da ton tai chua (da viet phuong thuc trong LoginDAO
				// phuong thuc
				Pattern patternObject = Pattern.compile("^0\\d{9}");
				Matcher matcherObject = patternObject.matcher(phone);
				if (matcherObject.matches() && LoginDAO.lookUpEmail(email) != null) {
					boolean add = new CustomerDAO().add(id, name, fullname, phone, address);
					boolean addPass = new LoginDAO().addUser(id, email, pass);
					if (add == true && addPass == true) {
						// thong bao them thanh cong + chuyen va trang quanlisapham.jsp
						response.sendRedirect("admin/customer/quanlikhachhang.jsp");
					} else {
						// lôi
						response.sendRedirect("add.jsp");
					}

				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
