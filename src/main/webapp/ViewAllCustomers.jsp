<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.warehousemanagement.Bean.*"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center" bgcolor="#a3a3a3">
<center>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
	<h1>Customer Details</h1>
		<table style="width: 80%" id="a" border=1 align="center">
			<tr>
				
				
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Phone number</th>
				<th>Address</th>
			</tr>

			<%
				@SuppressWarnings("unchecked")
						List<CustomerInfo> customers = (List<CustomerInfo>) request.getAttribute("customer_details");
						for (CustomerInfo c : customers) {
			%>
			<tr>
				<td><%=c.getCustomer_id()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getPhonenumber()%></td>
				<td><%=c.getAdderss()%></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>
	</center>
</body>
</html>