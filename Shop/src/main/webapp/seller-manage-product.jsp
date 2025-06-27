<%@page import="model.product"%>
<%@page import="java.util.List"%>
<%@page import="Dao.product_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file = "seller-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-12 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Product</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Company</th>
							<th>Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<%
					List<product> list = product_dao.getProductsBySid(s.getId());
					%>
					<tbody class="align-middle">
					<%for(product p:list){ %>
						<tr>
						    <td class="align-middle"><img src="product image/<%=p.getPimage() %>" width="50px"></td>
							<td class="align-middle"> <%=p.getPname() %></td>
							<td class="align-middle">Rs. <%=p.getPprice() %></td>
							<td class="align-middle"><%=p.getPquant() %> items</td>
							<td class="align-middle"><%=p.getPcompany() %></td>
							<td class="align-middle"><%=p.getPdesc() %></td>
							<td class="align-middle"><a href="sell-single-product.jsp?id=<%=p.getPid() %>" class="btn btn-success">Edit</a></td>
							<td class="align-middle"><a href="sell-delete-product.jsp?id=<%=p.getPid() %>" class="btn btn-danger">Delete</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Cart End -->
	
</body>
</html>