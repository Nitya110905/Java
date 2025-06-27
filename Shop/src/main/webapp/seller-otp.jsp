<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "common-header.jsp" %>
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
                    <span>Verify OTP!</span>
                </div>
                
                
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
		<%String email = (String)request.getAttribute("email"); %>
					<%int otp = (Integer)request.getAttribute("otp"); %>
					
					<input type="hidden" name="email" value="<%=email%>">
						<input type="hidden" name="otp1" value="<%=otp%>">
                <!-- Single Input Fields -->
                <div class="input-box">
                    <div class="single-input-fields">
                        <label>Enter Your OTP</label>
                        <input type="text" name="otp2" placeholder="OTP">
                    </div>
                </div>
                <!-- form Footer -->
                <div class="login-footer">
                    <button class="submit-btn3" value="verify" name="action">Verify</button>
                </div>
            </div>
        </div>
        <!-- login Area End -->
        </form>
    </main>
</body>
</html>