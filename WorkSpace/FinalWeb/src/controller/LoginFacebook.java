package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_loginFacebook.RestFB;
import com.restfb.types.User;


/**
 * Servlet implementation class LoginFacebook
 */
@WebServlet("/LoginFacebook")
public class LoginFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFacebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
	    if (code == null || code.isEmpty()) {
	      RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
	      dis.forward(request, response);
	    } else {
	    	//goi phuong thuc trong thu vien RestFB da viet o tren: lay code
	      String accessToken = RestFB.getToken(code);
	      //lay ra user
	      User user = RestFB.getUserInfo(accessToken);
	      //luu thong tin vao request
//	      request.setAttribute("id", user.getId());
//	      request.setAttribute("name", user.getName());
//	      request.setAttribute("email", user.getEmail());
	      PrintWriter out = response.getWriter();
	      out.print(user.getId());
	      out.print(user.getName());
	      out.print(user.getEmail());
	      //tra thong tin ve trang index
	      RequestDispatcher dis = request.getRequestDispatcher("/index.jsp");
	      dis.forward(request, response);
	    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
