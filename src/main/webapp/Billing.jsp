<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing Page</title>
</head>
<script type="text/javascript">
function msg() {
		if (document.getElementById("customer_id").value.length == 0) {
			alert("please enter customer_id!!");
			return false;
		}
		if (document.getElementById("item_id").value.length == 0) {
			alert("please enter item_id!!");
			return false;
		}
		if (document.getElementById("quantity").value.length == 0) {
			alert("please enter quantity!!");
			return false;
		}

	}
</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="transactioncontrol" onsubmit="return msg()">
<h3 style="color:blue">Billing</h3>
<table border="1" align="center">
<tr><td>Customer Id:</td><td><input type="text" name="customer_id" value="" id="customer_id"></td></tr>
<tr><td>Item Id:</td><td><input type="text" name="item_id" value="" id="item_id"></td></tr>
<tr><td>Quantity:</td><td><input type="text" name="quantity" value="" id="quantity"></td></tr>
<tr><td><input type="reset" name="index_clear" value="Clear"></td>
<td><input type="submit" name="index_validate" value="submit"></td></tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>