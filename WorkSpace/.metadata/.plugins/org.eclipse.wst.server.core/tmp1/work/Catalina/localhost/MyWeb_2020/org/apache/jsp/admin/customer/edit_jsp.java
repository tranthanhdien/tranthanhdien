/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-18 13:15:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model_user.User;
import model_user.Login;
import model_user.Customer;
import model_shoppingcart.Invoice;
import java.util.ArrayList;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("model_shoppingcart.Invoice");
    _jspx_imports_classes.add("model_user.Customer");
    _jspx_imports_classes.add("model_user.User");
    _jspx_imports_classes.add("model_user.Login");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Quản lí khách hàng</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<meta name=\"keywords\"\r\n");
      out.write("\tcontent=\"Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, \r\n");
      out.write("SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design\" />\r\n");
      out.write("<script type=\"application/x-javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Core CSS -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/newcss/bootstrap.css\"\r\n");
      out.write("\trel='stylesheet' type='text/css' />\r\n");
      out.write("\r\n");
      out.write("<!-- Custom CSS -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/newcss/style.css\" />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- font-awesome icons CSS -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/newcss/font-awesome.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!-- //font-awesome icons CSS-->\r\n");
      out.write("\r\n");
      out.write("<!-- side nav css file -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/newcss/SidebarNav.min.css\"\r\n");
      out.write("\tmedia='all' rel='stylesheet' type='text/css' />\r\n");
      out.write("<!-- //side nav css file -->\r\n");
      out.write("\r\n");
      out.write("<!-- js-->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/modernizr.custom.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!--webfonts-->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!--//webfonts-->\r\n");
      out.write("\r\n");
      out.write("<!-- Metis Menu -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/metisMenu.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/custom.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/newjs/custom.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<!--//Metis Menu -->\r\n");
      out.write("<!-- -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js\"></script>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("#chartdiv {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 295px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=text] {\r\n");
      out.write("\twidth: 90%;\r\n");
      out.write("\tpadding: 3px 3px;\r\n");
      out.write("\tmargin: 8px 0;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- requried-jsfiles-for owl -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/cssAdmin/owl.carousel.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/jsAdmin/owl.carousel.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(\"#owl-demo\").owlCarousel({\r\n");
      out.write("\t\t\titems : 3,\r\n");
      out.write("\t\t\tlazyLoad : true,\r\n");
      out.write("\t\t\tautoPlay : true,\r\n");
      out.write("\t\t\tpagination : true,\r\n");
      out.write("\t\t\tnav : true,\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<!-- //requried-jsfiles-for owl -->\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"cbp-spmenu-push\">\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/admin/menu.jsp", out, false);
      out.write("\r\n");
      out.write("\t<!-- main content start-->\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div id=\"page-wrapper\">\r\n");
      out.write("\t\t<div class=\"main-page\">\r\n");
      out.write("\t\t\t<div class=\"col_3\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"modal-dialog modal-lg\">\r\n");
      out.write("\t\t\t\t\t<form\r\n");
      out.write("\t\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/ControllerUser?action=edit\"\r\n");
      out.write("\t\t\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h4 class=\"modal-title\" style=\"text-align: center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<b>SỬA THÔNG TIN KHÁCH HÀNG</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table style=\"width: 100%;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><div class=\"input-group\" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"ma\"><b>Mã người dùng</b></label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.c.id  }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"id\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"ten\"><b>Tên đăng nhập</b></label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.c.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"name\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\trequired>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"ten\"><b>Họ và tên</b></label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.c.fullName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"fullname\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><div class=\"input-group \" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"gia\"><b>Mật khẩu</b></label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.l.pass }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"pass\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><div class=\"input-group \" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"giam\"><b>Số điện thoại</b></label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.c.phone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"phone\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\trequired>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td><div class=\"input-group \" style=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"gia\"><b>Email</b></label> <input type=\"email\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.l.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"email\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\"><div class=\"input-group \"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"display: grid;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"giam\"><b>Địa chỉ</b></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<textarea rows=\"3\" cols=\"30\" name=\"address\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lookUser.c.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\"><b>Admin</b> ");

 	User u = (User) request.getAttribute("lookUser");
 	Login l = u.getL();
 	if (l.isAdmin() == true) {
 
      out.write(" <input type=\"radio\" value=\"yes\" name=\"admin\" checked=\"checked\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tCó <input type=\"radio\" value=\"no\" name=\"admin\"> Không\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

 	} else {
 
      out.write(" <input type=\"radio\" value=\"yes\" name=\"admin\"> Có <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype=\"radio\" value=\"no\" name=\"admin\" checked=\"checked\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tKhông ");

 	}
 
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td align=\"right\" colspan=\"3\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width: 90%; margin-right: 2%; float: right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"bt-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/ControllerUser?action=quanlikhachhang\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"hvr-icon-back col-2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"background: #1bbc9b; text-align: left\">Trở lại</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><button type=\"submit\" class=\"hvr-icon-fade col-2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"padding: 8px; width: 100%; background: #1bbc9b; border: none; color: white; text-align: left\">Cập\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnhật</button></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Thu gon menu -->\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/classie.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document\r\n");
      out.write("\t\t\t\t.getElementById('showLeftPush'), body = document.body;\r\n");
      out.write("\r\n");
      out.write("\t\tshowLeftPush.onclick = function() {\r\n");
      out.write("\t\t\tclassie.toggle(this, 'active');\r\n");
      out.write("\t\t\tclassie.toggle(body, 'cbp-spmenu-push-toright');\r\n");
      out.write("\t\t\tclassie.toggle(menuLeft, 'cbp-spmenu-open');\r\n");
      out.write("\t\t\tdisableOther('showLeftPush');\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tfunction disableOther(button) {\r\n");
      out.write("\t\t\tif (button !== 'showLeftPush') {\r\n");
      out.write("\t\t\t\tclassie.toggle(showLeftPush, 'disabled');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- //thu gon menu -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- side nav js -->\r\n");
      out.write("\t<script src='");
      out.print(request.getContextPath());
      out.write("/newjs/SidebarNav.min.js'\r\n");
      out.write("\t\ttype='text/javascript'></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$('.sidebar-menu').SidebarNav()\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- Bootstrap Core JavaScript -->\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/newjs/bootstrap.js\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
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