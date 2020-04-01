<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test here</title>
    </head>
    <body>
        <%
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=BanThietBiChieuSang", "sa", "dien1998");
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM userpass WHERE username = ?");
            ps.setString(1, request.getParameter("username"));
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                out.print("User already exists");
            } else {
                out.print("User name is valid");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        %>
    </body>
</html>