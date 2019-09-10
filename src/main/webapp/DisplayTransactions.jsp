<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transactions Page</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("transaction_date").value.length == 0) {
			alert("please enter transaction_date!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="displayTransaction" onsubmit="return msg()">
<h3 style="color:blue">Transactions Page</h3>
<p>Transaction Date:<input type="date" name="transaction_date" value="" id="transaction_date"></p>
<input type="submit" name="index_validate" value="submit">
<a href="Home.jsp"><input type="button" name="button" value="Back"></a>
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>
</body>
</html>