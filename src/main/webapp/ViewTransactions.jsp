<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.warehousemanagement.Bean.*"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions Page</title>
</head>
<body align="center" bgcolor="#a3a3a3">

  <%@include file="DisplayTransactions.jsp" %>
<h1 style="color:blue">Item Details</h1>
        	<%
        	List<Transactions> list = (List<Transactions>)request.getAttribute("obj");
        	%>
        	<table border="1" align="center">
        	<tr><td>Transaction Id</td><td>Quantity</td><td>Date</td><td>Customer Id</td><td>Item Id</td></tr>
        	<% System.out.println("printing");
        	for(Transactions trans:list){ %>
        	
        	<tr><td><input type="text" value=<%=trans.getTransaction_id()%> readonly></td>
        	<td><input type="text" value=<%=trans.getQuantity()%> readonly></td>
        	<td><input type="text" value=<%=trans.getTransaction_date()%> readonly></td>
        	<td><input type="text" value=<%=trans.getCustObj().getCustomer_id()%> readonly></td>
        	<td><input type="text" value=<%=trans.getItemObj().getItem_id()%> readonly></td></tr>
        	
        	<% }%>
        	</table>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>