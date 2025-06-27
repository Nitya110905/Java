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
<%
        String msg = (String) request.getAttribute("msg");
        if (msg != null){
        %>
    <h2>
    <%
    out.print(msg);
    %>
    </h2>
    <%
        }
    %>
    <main class="login-bg">
    <form action="Seller_controller" method="POST">
        <!-- Register Area Start -->
        <div class="register-form-area">
            <div class="register-form text-center">
                <!-- Login Heading -->
                <div class="register-heading">
                    <span>Seller <%=s.getName() %>'s Profile</span>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                <div class="single-input-fields">
                        <input type="hidden" name="id" value="<%=s.getId()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Full name</label>
                        <input type="text" name="name" value="<%=s.getName() %>">
                    </div>
                    <div class="single-input-fields">
                        <label>Email Address</label>
                        <input type="email" name="email" value="<%=s.getEmail()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Contact</label>
                        <input type="tel" name="contact" value="<%=s.getContact()%>">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="register-footer">
                    <button class="submit-btn3" name="action" value="Update">Update</button>
                </div>
            </div>
        </div>
        </form>
        <!-- Register Area End -->
    </main>
</body>
</html>