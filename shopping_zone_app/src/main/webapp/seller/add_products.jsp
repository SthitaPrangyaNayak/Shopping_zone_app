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
<%@ include file="../components/seller_navbar.jsp" %>
<h1>Add Products Page</h1>
<h2>${success}</h2>

<form:form action="${pageContext.request.contextPath}/add_product" method="post" modelAttribute="product">
  Enter Product name:<br>
   <form:input path="name"/><br><br>
   Enter Product price:<br>
   <form:input path="price" /><br><br>
    Enter Product category:<br>
   <form:input path="category" /><br><br>
   Enter Product description:<br>
   <form:input path="description" /><br><br>
   Enter Product quantity:<br>
   <form:input path="stockLeft" /><br><br>
   <form:hidden path="id"/><br>
   
   <form:button>Submit</form:button>
  
  </form:form>

</body>
</html>