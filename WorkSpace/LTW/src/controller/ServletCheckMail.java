package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

@WebServlet("/ServletCheckMail")
public class ServletCheckMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletCheckMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		try {
			if (UsersDAO.checkEmail(email)) {
				response.getWriter().write("<img src=\"img/not-available.png\" />");
			} else {
				response.getWriter().write("<img src=\"img/available.png\" />");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
