<%@page import="Dao.product_dao"%>
<%@page import="model.product"%>
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
<!--  services-area start-->
        <div class="services-area2 pt-50">
            <div class="container">
             <%List<product> list =product_dao.getAllProducts(); %>
        <%for(product p:list){ %>
                <div class="row">
                    <div class="col-xl-12">
                        <div class="row">
                            <div class="col-xl-12">
                                <!-- Single -->
                                <div class="single-services d-flex align-items-center mb-0">
                                    <div class="features-img">
                                        <img src="product image/<%=p.getPimage() %>" height="200px" width = "200px" alt="">
                                    </div>
                                    <div class="features-caption">
                                        <h3><a  href="buy-single-product.jsp?pid=<%=p.getPid()%>"><%=p.getPname() %></a></h3>
                                        <p>By <%=p.getPcompany() %></p>
                                        <div class="price">
                                            <span>Rs. <%=p.getPprice() %></span>
                                        </div>
                                        <div class="review">
                                            <div class="rating">
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star"></i>
                                                <i class="fas fa-star-half-alt"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>   <%} %>
            </div>
        </div>
</body>
</html>