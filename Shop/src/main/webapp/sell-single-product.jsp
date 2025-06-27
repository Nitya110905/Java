<%@page import="Dao.product_dao"%>
<%@page import="model.product"%>
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
<%int pid = Integer.parseInt(request.getParameter("id")); %>
<%product p = product_dao.getProductByPid(pid); %>

	<main class="login-bg">
    <form action="Product_Controller" method="POST" enctype="multipart/form-data">
        <!-- Register Area Start -->
        		<%
		String msg = (String) request.getAttribute("msg");
		%>
		<%
		if (msg != null) {
		%>
		<h4
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3"> <%
 out.print(msg);
 %>
			</span>
		</h4>
		<%
		}
		%>
        <div class="register-form-area">
            <div class="register-form text-center">
                <!-- Login Heading -->
                <div class="register-heading">
                    <span>Update Product</span>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                <input type="hidden" name="pid" value="<%=p.getPid()%>">
                	<div class="control-group">
							<img src="product image/<%=p.getPimage()%>" height="250" width="250">
						</div>
                    <div class="single-input-fields">
                        <label>Product Name</label>
                        <input type="text" name="pname" value="<%=p.getPname()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Product Company</label>
                        <input type="text" name="pcompany" value="<%=p.getPcompany()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Product Description</label>
                        <input type="text" name="pdesc" value="<%=p.getPdesc()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Product Quantity</label>
                        <input type="tel" name="pquant" value="<%=p.getPquant()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Product Image</label>
                        <input type="file" name="pimage" value="<%=p.getPimage()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Product Price</label>
                        <input type="tel" name="pprice" value="<%=p.getPprice()%>">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="register-footer">
                    <button class="submit-btn3" name="action" value="update">Update</button>
                </div>
            </div>
        </div>
        </form>
        <!-- Register Area End -->
    </main>
</body>
</html>