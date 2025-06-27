<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="common-header.jsp" %>
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
                    <span>Sign Up Seller</span>
                    <p>Create your account to get full access</p>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                    <div class="single-input-fields">
                        <label>Full name</label>
                        <input type="text" name="name" placeholder="Enter full name">
                    </div>
                    <div class="single-input-fields">
                        <label>Email Address</label>
                        <input type="email" name="email" placeholder="Enter email address">
                    </div>
                    <div class="single-input-fields">
                        <label>Contact</label>
                        <input type="tel" name="contact" placeholder="Enter Contact">
                    </div>
                    <div class="single-input-fields">
                        <label>Password</label>
                        <input type="password" name="password" placeholder="Enter Password">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="register-footer">
                    <p> Already have an account? <a href="sell-login.jsp"> Login</a> here</p>
                    <button class="submit-btn3" name="action" value="register">Sign up</button>
                </div>
            </div>
        </div>
        </form>
        <!-- Register Area End -->
    </main>
</body>
</html>