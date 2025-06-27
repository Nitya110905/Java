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
    <main class="login-bg">
    <form action="Seller_controller" method="POST">
        <!-- login Area Start -->
        <div class="login-form-area">
            <div class="login-form" >
                <!-- Login Heading -->
                <div class="login-heading">
                    <span>OTP</span>
                    <%
		String msg = (String) request.getAttribute("msg");
		%>
		<%
		if (msg != null) {
		%>
		<h4
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">
				<%
				out.print(msg);
				%>
			</span>
		</h4>
		<%
		}
		%>
                </div>
                <!-- Single Input Fields -->
                <div class="input-box">
                    <div class="single-input-fields">
                        <label>Username or Email Address</label>
                        <input type="text" name="email" placeholder="Username / Email address">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="login-footer">
                    <button class="submit-btn3" value="get_otp" name="action">Get OTP</button>
                </div>
            </div>
        </div>
        <!-- login Area End -->
        </form>
    </main>
</body>
</html>