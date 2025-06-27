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
        <!-- login Area Start -->
        <div class="login-form-area">
            <div class="login-form" >
                <!-- Login Heading -->
                <div class="login-heading">
                    <span>Login Seller</span>
                    <p>Enter Login details to get access</p>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                    <div class="single-input-fields">
                        <label>Username or Email Address</label>
                        <input type="text" name="email" placeholder="Username / Email address">
                    </div>
                    <div class="single-input-fields">
                        <label>Password</label>
                        <input type="password" name="password" placeholder="Enter Password">
                    </div>
                    <div class="single-input-fields login-check">
                        <input type="checkbox" id="fruit1" name="keep-log">
                        <label for="fruit1">Keep me logged in</label>
                        <a href="seller-fp.jsp" class="f-right">Forgot Password?</a>
                    </div>
                </div>
                <!-- form Footer -->
                <div class="login-footer">
                    <p>Don’t have an account? <a href="sell-sign.jsp">Sign Up</a>  here</p>
                    <button class="submit-btn3" value="login" name="action">Login</button>
                </div>
            </div>
        </div>
        <!-- login Area End -->
        </form>
    </main>
</body>
</html>