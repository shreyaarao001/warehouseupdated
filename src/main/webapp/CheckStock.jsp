<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Stock Page</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("item_id").value.length == 0) {
			alert("please enter item_id!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action=checkItem onsubmit="return msg()">
<h3 style="color:blue">Check Item</h3>
<table border="1" align="center" >
<tr><td>Item Id:</td><td><input type="text" name="item_id" value="" id="item_id"></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="ItemDetails.jsp"><input type="button" name="button" value="back"></a>
<a href="login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>