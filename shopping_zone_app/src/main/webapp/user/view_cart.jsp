<%@page import="com.org.daoimpl.UserDaoImpl"%>
<%@page import="com.org.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% int userId= (int)session.getAttribute("userId");
  List<Item> items= new UserDaoImpl().fetchUserByID(userId).getItems();
%>

<table border="2">
<tr>
    <th>name</th>
    <th>price</th>
    <th>category</th>
    <th>description</th>
    <th>stock left</th>
    <th>action</th>
    <th>action</th>
      
  </tr>
  
  <c:forEach var="p" items="<%=items%>">
  <tr>
     <td>${p.getName()}</td>
     <td>${p.getPrice()}</td>
     <td>${p.getCategory()}</td>
     <td>${p.getDescription()}</td>
     <td>${p.getStockLeft()}</td>
     <td><a href="#">Remove from cart</a></td>
     <td><a href="#">Buy now</a></td>
  </tr>
  
  </c:forEach>
</table>


</table>
</body>
</html>