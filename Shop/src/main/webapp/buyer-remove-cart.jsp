<%@page import="Dao.cart_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "buyer-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int cart_id = Integer.parseInt(request.getParameter("cart_id"));
cart_dao.removerProduct(cart_id);
response.sendRedirect("buy-cart.jsp");
request.setAttribute("msg", "Product removed from wishlist!");
%>
</body>
</html>