<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
</head>
<body>
<%@ include file="../components/index_navbar.jsp" %>
	
	<h1>Seller Registration Page</h1>
	
	<form:form action="register_seller" method="post" modelAttribute="seller">
	     Enter your name:<br>
	     <form:input path="name"/><br>
	     Enter your Mobile:<br>
	     <form:input path="mobile"/><br>
	     Enter your Email id:<br>
	     <form:input path="email"/><br>
	     Enter your password:<br>
	     <form:password path="password"/><br>
	    
	    <%--  <form:input path="name"/>--%>
	   
	     Enter your address:<br>
	    <form:textarea path="address" rows="7" cols="20"/><br>
	    
	    <form:button>submit</form:button>
	
	</form:form>

</body>
</html>