/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-18 13:04:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ResourceBundle;
import java.util.Locale;
import model_user.LoginDAO;
import model_user.Login;
import model_user.CustomerDAO;
import model_user.Customer;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model_user.LoginDAO");
    _jspx_imports_classes.add("model_user.Customer");
    _jspx_imports_classes.add("java.util.ResourceBundle");
    _jspx_imports_classes.add("model_user.CustomerDAO");
    _jspx_imports_classes.add("java.util.Locale");
    _jspx_imports_classes.add("model_user.Login");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Login</title>\r\n");
      out.write("<link href=\"css/styleLogin2.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" type=\"text/css\" rel=\"stylesheet\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		Customer user = (Customer) session.getAttribute("user");
		if (user != null) {
			//da dang nhap roi
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("hoadon.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
      out.write('	');

		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		//binh thuong thi lay ngon ngu la VN
		Locale.setDefault(new Locale("vn", "VN"));
		ResourceBundle resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");

		if (session.getAttribute("language") == null) {
			resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
		} else {
			String language = (String) session.getAttribute("language");
			if (language.equals("VN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_vn_VN");
			}
			if (language.equals("EN")) {
				resourcebundle = ResourceBundle.getBundle("bundle/demoResource_en_US");
			}
		}
	
      out.write("\r\n");
      out.write("\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<h5 class=\"modal-title\" id=\"exampleModalLabel\">");
      out.print(resourcebundle.getString("titleLogin") );
      out.write("</h5>\r\n");
      out.write("\t\t\t\t<br> <a style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.tieptuc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a> <a\r\n");
      out.write("\t\t\t\t\tstyle=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.daDK }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a> <a\r\n");
      out.write("\t\t\t\t\tstyle=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.dkThanhCong }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<form action=\"ControllerShopping?action=login\" method=\"post\"\r\n");
      out.write("\t\t\t\t\tclass=\"p-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"recipient-name\" class=\"col-form-label\">Email</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");

							if (request.getAttribute("emailRe") == null) {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" name=\"Name\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"recipient-name\" required=\"required\">\r\n");
      out.write("\t\t\t\t\t\t");

							} else {
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"email\" class=\"form-control\" name=\"Name\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"recipient-name\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.print(request.getAttribute("emailRe"));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"password\" class=\"col-form-label\">");
      out.print(resourcebundle.getString("password") );
      out.write("</label> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"password\" class=\"form-control\" name=\"Password\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"password\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.cookiePass }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t");

							if (request.getAttribute("pass_err") != null) {

								out.print("<font color=\"red\">" + (String) request.getAttribute("pass_err") + "</font");
							}
						
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"row sub-w3l my-3\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col sub-agile\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"brand1\" value=\"\"> <label\r\n");
      out.write("\t\t\t\t\t\t\t\tfor=\"brand1\" class=\"text-dark\" > <span></span>");
      out.print(resourcebundle.getString("rememberLogin") );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col forgot-w3l text-right\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"forgotPass.jsp\" class=\"text-dark\">Forgot Password?</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"right-w3l\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" class=\"form-control\" value=\"");
      out.print(resourcebundle.getString("loginbutton"));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<p class=\"text-center dont-do\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(resourcebundle.getString("neuchuacotaikhoan") );
      out.write(" <a href=\"register.jsp\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"text-dark\"> ");
      out.print(resourcebundle.getString("forgot") );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<a\r\n");
      out.write("\t\t\t\t\t\thref=\"https://www.facebook.com/dialog/oauth?client_id=1517204811748325&redirect_uri=https://localhost:8080/WebProject_Backup/LoginFacebook\">Login\r\n");
      out.write("\t\t\t\t\t\tFacebook</a>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}