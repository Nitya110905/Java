<%@page import="Dao.product_dao"%>
<%@page import="model.product"%>
<%@page import="Dao.wishlist_dao"%>
<%@page import="model.wishlist"%>
<%@page import="java.util.List"%>
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
<%String msg =(String)request.getAttribute("msg"); %>
<%if(msg!=null){ %>
<div class="text-center">
	<h3><%out.print(msg); %></h3>
</div>
<%} %>
	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-12 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Product Name</th>
							<th>Price</th>
							<th>Category</th>
							<th>Description</th>
							<th>Remove</th>
						</tr>
					</thead>
					<%
					List<wishlist> list = wishlist_dao.getWishLIstBycid(b.getId());
					%>
					<tbody class="align-middle">
					<%for(wishlist w:list){ %>
					<%product p = product_dao.getProductByPid(w.getPid()); %>
						<tr>
							<td class="align-middle"><img src="product image/<%=p.getPimage() %>" alt=""
								style="width: 50px;"> <%=p.getPname() %></td>
							<td class="align-middle">Rs. <%=p.getPprice() %></td>
							<td class="align-middle"><%=p.getPcompany()%></td>
							<td class="align-middle"><%=p.getPdesc() %></td>
							<td class="align-middle"><a href="buyer-remove-wishlist.jsp?wid=<%=w.getWid() %>" class="btn btn-danger">Remove From WishList</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>