<%@page import="Dao.product_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int pid = Integer.parseInt(request.getParameter("id"));
product_dao.deleteProductByPid(pid);
response.sendRedirect("seller-manage-product.jsp");
%>
</body>
</html>