<%@page import="com.org.dto.Product"%>
<%@page import="com.org.daoimpl.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../components/allcss.jsp" %>
</head>
<body>

<%@ include file="../components/user_navbar.jsp" %>
User Home Page
<%
ProductDaoImpl dao= new ProductDaoImpl();
List<Product> products= dao.fetchAllProducts();
%>

<h4>${success}</h4>

<table border="2">
  <tr>
    <th>name</th>
    <th>price</th>
    <th>category</th>
    <th>description</th>
    <th>stock left</th>  
  </tr>
  
  <c:forEach var="p" items="<%=products%>">
  <tr>
     <td>${p.getName()}</td>
     <td>${p.getPrice()}</td>
     <td>${p.getCategory()}</td>
     <td>${p.getDescription()}</td>
     <td>${p.getStockLeft()}</td>
     <td><a href="<%=request.getContextPath()%>/add_item?productId=${p.getId()}">Add To Cart</a></td>
     <td><a href="#">Buy now</a></td>
  </tr>
  
  </c:forEach>
</table>






</body>
</html>