package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Users;

@WebServlet("/ServletThemUser")
public class ServletThemUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletThemUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Users user = new Users();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		user.setUserID(new java.util.Date().getTime());
		user.setUserEmail(email);
		user.setUserPass(pass);
		user.setUserRole(false);

		UsersDAO.addUser(user);
		HttpSession ss = request.getSession();
		ss.setAttribute("user", user);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
