
<!DOCTYPE html>
<%@page import="com.warehousemanagement.Bean.ItemInfo"%>
<html>
<head>
<meta charset="UTF-8">
<title>Item Info Page</title>
</head>
<body align="center">

  <%@include file="ItemCheck.jsp" %>
<h1 style="color:blue">Item Details</h1>
        	<%
        	ItemInfo itemInfoObj=(ItemInfo)request.getAttribute("obj");
        	int discount=(int)request.getAttribute("obj1");
        	%>
        	<table border="1" align="center">
        	<tr><td>Item id:</td><td><input type="text" value=<%=itemInfoObj.getItem_id()%> readonly></td></tr>
        	<tr><td>Item Name:</td><td><input type="text" value=<%=itemInfoObj.getName()%> readonly></td></tr>
        	<tr><td>Price:</td><td><input type="text" value=<%=itemInfoObj.getPrice()%> readonly></td></tr>
        	<tr><td>After Discount Price:</td><td><input type="text" value=<%=discount%> readonly></td></tr>
        	<tr><td>Stock:</td><td><input type="text" value=<%=itemInfoObj.getStock()%> readonly></td></tr>
        	</table>
  <br><br>
  <a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
</body>
</html>