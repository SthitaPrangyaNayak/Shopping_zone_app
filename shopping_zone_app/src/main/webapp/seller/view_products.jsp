<%@page import="com.org.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.org.daoimpl.SellerDaoImpl"%>
<%@page import="com.org.dto.Seller"%>
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
<%@ include file="../components/seller_navbar.jsp" %>

<%
 int sellerId=(int) session.getAttribute("sellerId");
 Seller seller= new SellerDaoImpl().fetchSellerByID(sellerId);
 List<Product> products= seller.getProducts();
%>
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
     <td><a href="<%=request.getContextPath() %>/update_product?productId=${p.getId()}">Update</a></td>
     <td><a href="<%=request.getContextPath() %>/delete_product?productId=${p.getId()}">Delete</a></td>
  </tr>
  
  </c:forEach>
</table>

</body>
</html>