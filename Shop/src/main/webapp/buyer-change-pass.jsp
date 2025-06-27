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
    <form action="buyer_controller" method="POST">
        <!-- Register Area Start -->
        <div class="register-form-area">
            <div class="register-form text-center">
                <!-- Login Heading -->
                <div class="register-heading">
                    <span>Change Password!</span>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                <div class="single-input-fields">
                        <input type="hidden" name="email" value="<%=b.getEmail()%>">
                    </div>
                    <div class="single-input-fields">
                        <label>Old Password</label>
                        <input type="password" name="op" placeholder="Enter Old Password">
                    </div>
                    <div class="single-input-fields">
                        <label>New Password</label>
                        <input type="password" name="np" placeholder="Enter New Password">
                    </div>
                    <div class="single-input-fields">
                        <label>Confirm Password</label>
                        <input type="password" name="cp" placeholder="Enter Confirm Password">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="register-footer">
                    <button class="submit-btn3" name="action" value="Change">Change</button>
                </div>
            </div>
        </div>
        </form>
        <!-- Register Area End -->
    </main>
</body>
</html>