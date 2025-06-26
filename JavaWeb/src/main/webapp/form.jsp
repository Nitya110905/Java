<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Form_Controller" method="post">
<table border="2" cellspacing="5" cellpadding = "10" >
<caption>Student Form</caption>
<tr>
<td>Name:</td>
<td><input type = "text" name="name" required></td>
</tr>
<tr>
<td>Email:</td>
<td><input type = "text" name="email" required></td>
</tr>
<tr>
<td>Contact:</td>
<td><input type = "text" name="contact" required></td>
</tr>
<tr>
<td>Password:</td>
<td><input type = "text" name="password" required></td>
</tr>
<tr>
<td>Address:</td>
<td><input type = "text" name="address" required></td>
</tr>
<tr>
                <td>HOBBIES</td>
                <td>Drawing<input name="hobby[]" value="Drawing" type="checkbox">
                Singing<input name="hobby[]" value="Singing" type="checkbox">
                Dancing<input name="hobby[]" value="Dancing" type="checkbox">

            </tr>
            <tr>
                <td>Course</td>
                <td><select name="course"><option selected disabled>Select Course</option>
                <option value="Science">Science</option>
                <option value="Commerce">Commerce</option>
                <option value="Arts">Arts</option></select></td>     
            </tr>
            	<tr>
                <td>GENDER</td>
                <td><label for="a"></label>Male<input type="radio" name="gender" value="Male" id="a"><label for="a"></label>Female<input type="radio" value="Female" name="gender" id="a"></td>
            </tr>
            <tr><td align="center" colspan="2"><input type="submit" value ="submit" name = "action">
</table>
</form>
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
</body>
</html>