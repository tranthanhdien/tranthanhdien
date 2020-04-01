package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLab2")
public class ServletLab2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletLab2() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	toDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("userName ", userName);
		request.setAttribute("dob", dob);
		request.setAttribute("password", password);
		request.setAttribute("re_password", re_password);
		request.setAttribute("address", address);
		request.setAttribute("sex", sex);
		
		RequestDispatcher rd = request.getRequestDispatcher("lab2_hienthi.jsp");
		rd.forward(request, response);

		
	}
	private void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
