<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Check</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("customer_id").value.length == 0) {
			alert("please enter customer_id!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="customer" onsubmit="return msg()">
<h3 style="color:blue">Customer Information Page</h3>
<p>Customer ID:<input type="text" name="customer_id" value="" id="customer_id"></p>
<input type="submit" name="index_validate" value="submit">
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>

</body>
</html>