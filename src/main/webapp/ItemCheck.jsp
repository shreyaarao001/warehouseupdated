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
		if (document.getElementById("item_id").value.length == 0) {
			alert("please enter item_id!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="viewitem" onsubmit="return msg()">
<h3 style="color:blue">Customer Information Page</h3>
<p>Item ID:<input type="text" name="item_id" value="" id="item_id"></p>
<input type="submit" name="index_validate" value="submit">
  <a href="login.jsp"><input type="button" name="button" value="Logout"></a>
  </form>

</body>
</html>