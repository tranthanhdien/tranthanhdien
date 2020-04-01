package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/New")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public New() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("txtEmail");
		String pass = request.getParameter("txtPass");
		String repass = request.getParameter("txtRepassword");
		String name = request.getParameter("txtName");
		String sexMale = request.getParameter("radNam");
		String sexFemale = request.getParameter("radNu");
		
		String email_err;
		boolean error = false;
		if (email == null || email.equals("")) {
			email_err = "Trường email không được để trống";
			error = true;
			request.setAttribute("email_err", email_err);
		}

		if (error) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
