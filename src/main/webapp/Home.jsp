<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="home">
<h3 style="color:blue">Home Page</h3>
<p>Please Choose from the following options:</p>
<h4>
		<a href="CreateCustomer.jsp">Create Customer</a>
	</h4>
<h4>
		<a href="CustomerCheck.jsp">Display Customer Information</a>
	</h4>
	<h4>
		<a href="NewItem.jsp">Add Item</a>
	</h4>
	<h4>
		<a href="Billing.jsp">Billing</a>
	</h4>
	<h4>
		<a href="CancelOrder.jsp">Cancel Order</a>
	</h4>
	<h4>
		<a href="DisplayTransactions.jsp">Transactions</a>
	</h4>
	<h4>
		<a href="ItemCheck.jsp">Display Item Information</a>
	</h4>
	<h4>
 <a href="allcustomers">view all customers</a>
 </h4>
 <h4>
 <a href="CheckStock.jsp">Add Stock</a>
 </h4>
  <br><br>
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>