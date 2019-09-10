<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.warehousemanagement.Bean.*" 
    import="com.example.demo.interfaces.*"
    import="org.springframework.web.servlet.ModelAndView"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Information</title>
</head>
<body align="center" bgcolor="#a3a3a3">
 
<h1 style="color:blue">Customer Details</h1>
        	<%
        	CustomerInfo custObj=(CustomerInfo)request.getAttribute("obj");
        	%>
        	<% if(custObj!=null) {%>
        	<table border="1" align="center">
        	<tr><td>Customer Name:</td><td><input type="text" value=<%=custObj.getName() %> readonly></td></tr>
        	<tr><td>Phone Number:</td><td><input type="text" value=<%=custObj.getPhonenumber() %> readonly></td></tr>
        	<tr><td>Address:</td><td><input type="text" value=<%=custObj.getAdderss() %> readonly></td></tr>
        	</table>
        	<%} %>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>

</body>
</html>