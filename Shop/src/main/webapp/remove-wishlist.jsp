<%@page import="Dao.wishlist_dao"%>
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
<%int wid = Integer.parseInt(request.getParameter("wid"));
wishlist_dao.removerProduct(wid);
response.sendRedirect("wishlist.jsp");
%>
</body>
</html>