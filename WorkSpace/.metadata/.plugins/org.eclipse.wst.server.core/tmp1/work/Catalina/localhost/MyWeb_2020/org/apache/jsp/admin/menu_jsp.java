/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-02-18 13:05:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model_user.LoginDAO;
import model_user.Login;
import model_user.CustomerDAO;
import model_user.Customer;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("model_user.CustomerDAO");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main-content\">\r\n");
      out.write("\t\t<div class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left\"\r\n");
      out.write("\t\t\tid=\"cbp-spmenu-s1\">\r\n");
      out.write("\t\t\t<!--left-fixed -navigation-->\r\n");
      out.write("\t\t\t<aside class=\"sidebar-left\">\r\n");
      out.write("\t\t\t\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-toggle=\"collapse\" data-target=\".collapse\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"navbar-brand\"\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/admin/index.jsp\"><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"fa fa-area-chart\"></span> Lightting<span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dashboard_text\">Administrator</span></a>\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"collapse navbar-collapse\"\r\n");
      out.write("\t\t\t\t\t\tid=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"sidebar-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"header\">Menu chính</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/admin/index.jsp\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-dashboard\"></i> <span>Dashboard</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-pie-chart\"></i> <span>Trang bán hàng</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/ControllerAdmin?action=displayInvoiceProcess\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Xử lí hóa đơn</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/ControllerProduct?action=truyXuatSanPham\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Quản lí sản phẩm</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/ControllerUser?action=quanlikhachhang\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Quản lí người dùng</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/ControllerInvoice?action=quanlihoadon\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Quản lí hóa đơn</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/admin/report/reports.jsp\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Biểu đồ thống kê</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"");
      out.print(request.getContextPath());
      out.write("/admin/report/report.jsp\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-pie-chart\"></i> <span>Thong ke main</span>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-laptop\"></i> <span>UI Elements</span> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"treeview-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"general.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> General</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"icons.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tIcons</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"buttons.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> Buttons</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"typography.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> Typography</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"widgets.html\"> <i class=\"fa fa-th\"></i> <span>Widgets</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<small class=\"label pull-right label-info\">08</small>\r\n");
      out.write("\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a href=\"#\"> <i class=\"fa fa-edit\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Forms</span> <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"treeview-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"forms.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tGeneral Forms</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"validation.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> Form Validations</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a href=\"#\"> <i class=\"fa fa-table\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Tables</span> <i class=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"treeview-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"tables.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tSimple tables</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-envelope\"></i> <span>Mailbox </span> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-left pull-right\"></i><small\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"label pull-right label-info1\">08</small><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"label label-primary1 pull-right\">02</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"treeview-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"inbox.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tMail Inbox </a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"compose.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> Compose Mail </a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"treeview\"><a href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-folder\"></i> <span>Examples</span> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-left pull-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"treeview-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"login.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tLogin</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"signup.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tRegister</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"404.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t404 Error</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"500.html\"><i class=\"fa fa-angle-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t500 Error</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"blank-page.html\"><i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-right\"></i> Blank Page</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"header\">LABELS</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-angle-right text-red\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Important</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-angle-right text-yellow\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Warning</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-angle-right text-aqua\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Information</span></a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- /.navbar-collapse -->\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("\t\t\t</aside>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--left-fixed -navigation-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- header-starts -->\r\n");
      out.write("\t\t<div class=\"sticky-header header-section \">\r\n");
      out.write("\t\t\t<div class=\"header-left\">\r\n");
      out.write("\t\t\t\t<!--toggle button start-->\r\n");
      out.write("\t\t\t\t<button id=\"showLeftPush\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<!--toggle button end\r\n");
      out.write("\t\t\t\t<div class=\"profile_details_left\">\r\n");
      out.write("\t\t\t\t\t<!--notifications of menu start \r\n");
      out.write("\t\t\t\t\t<ul class=\"nofitications-dropdown\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown head-dpdn\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"><i class=\"fa fa-envelope\"></i><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge\">4</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>You have 3 new messages</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"odd\"><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/4.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_bottom\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">See all messages</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown head-dpdn\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"><i class=\"fa fa-bell\"></i><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge blue\">4</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>You have 3 new notification</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/4.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"odd\"><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"../imageAdmin/1.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"images/3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"user_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"images/2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"notification_desc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>Lorem ipsum dolor amet</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>1 hour ago</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_bottom\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">See all notifications</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown head-dpdn\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"><i class=\"fa fa-tasks\"></i><span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge blue1\">8</span></a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3>You have 8 pending task</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"task-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"task-desc\">Database update</span><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"percentage\">40%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-striped active\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"bar yellow\" style=\"width: 40%;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"task-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"task-desc\">Dashboard done</span><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"percentage\">90%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-striped active\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"bar green\" style=\"width: 90%;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"task-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"task-desc\">Mobile App</span><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"percentage\">33%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-striped active\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"bar red\" style=\"width: 33%;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"task-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"task-desc\">Issues fixed</span><span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"percentage\">80%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"progress progress-striped active\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"bar  blue\" style=\"width: 80%;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"notification_bottom\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">See all pending tasks</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--notification menu end -->\r\n");
      out.write("\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"header-right\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!--search-box-->\r\n");
      out.write("\t\t\t\t<div class=\"search-box\">\r\n");
      out.write("\t\t\t\t\t<form class=\"input\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"sb-search-input input__field--madoka\"\r\n");
      out.write("\t\t\t\t\t\t\tplaceholder=\"Search...\" type=\"search\" id=\"input-31\" /> <label\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"input__label\" for=\"input-31\"> <svg class=\"graphic\"\r\n");
      out.write("\t\t\t\t\t\t\t\twidth=\"100%\" height=\"100%\" viewBox=\"0 0 404 77\"\r\n");
      out.write("\t\t\t\t\t\t\t\tpreserveAspectRatio=\"none\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<path d=\"m0,0l404,0l0,77l-404,0l0,-77z\" />\r\n");
      out.write("\t\t\t\t\t\t\t</svg>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--//end-search-box-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"profile_details\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown profile_details_drop\"><a href=\"#\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"dropdown-toggle\" data-toggle=\"dropdown\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"profile_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"prfil-img\"><img src=\"images/2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"user-name\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<p></p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span>Administrator</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-angle-down lnr\"></i> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"fa fa-angle-up lnr\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu drp-mnu\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-cog\"></i> Cài đặt</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-user\"></i> Tài khoản\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tcủa tôi</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-suitcase\"></i> Profile</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-sign-out\"></i> Đăng\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\txuất</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- //header-ends -->\r\n");
      out.write("\t</div>\r\n");
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