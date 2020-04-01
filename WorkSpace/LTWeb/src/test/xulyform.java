package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class xulyform
 */
@WebServlet("/xulyform")
public class xulyform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xulyform() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		boolean error = false;
		String email = request.getParameter("txtEmail");
		String pass = request.getParameter("txtPass");
		String email_err;
		String pass_err;
		if (email == null || email.equals("")) {
			email_err = "Trường email không được để trống";
			error = true;
			request.setAttribute("email_err", email_err);
		}

		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/dangkythanhcong.jsp");
			rd.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("person", new
		Person(email,pass));
	}

}
