<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Transaction</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("transaction_id").value.length == 0) {
			alert("please enter transaction_id!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="cancelTransactionControl" onsubmit="return msg()">
<h3 style="color:blue">Check Transaction</h3>
<table border="1" align="center" >
<tr><td>Transaction Id:</td><td><input type="text" name="transaction_id" value="" id="transaction_id"></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>