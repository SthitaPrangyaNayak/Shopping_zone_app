<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/index_navbar.jsp" %>
<p>${fail}</p>
Seller Login page
<form action="${pageContext.request.contextPath}/login_seller" method="post">
Enter your email:<br>
<input type="text" name="email"><br>
Enter your password:<br>ś
<input type="text" name="password"><br>
<input type="submit" value="sign in"><br>
</form>

</body>
</html>