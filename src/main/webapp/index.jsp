<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spoonify</title>
</head>
<body>
<h1>Hello there</h1>
<%Class.forName("com.mysql.cj.jdbc.Driver");
Connection con= DBConnect.connect();
String query="select * from user";
PreparedStatement pst =con.prepareStatement(query);
ResultSet rs= pst.executeQuery();
while(rs.next()){
	out.println(rs.getString("username"));
	out.println(rs.getString("email"));
}
DBConnect.destroy();
%>
</body>
</html>