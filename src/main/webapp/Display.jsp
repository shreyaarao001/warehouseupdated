<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body bgcolor="#a3a3a3">
<center>
<%
        	String msg=(String)request.getAttribute("obj");
        	%>
        	<h1> <%=msg %></h1>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>        	
</center>       	
</body>
</html>