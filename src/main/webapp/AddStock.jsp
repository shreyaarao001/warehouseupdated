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
		if (document.getElementById("stock").value.length == 0) {
			alert("please enter stock!!");
			return false;
		}
		</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="addStock" onsubmit="return msg()">
<h3 style="color:blue">Add Stock</h3>
<table border="1" align="center" >
<tr><td>Stock:</td><td><input type="text" name="stock" value="" id="stock"></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="CheckStock.jsp"><input type="button" name="button" value="back"></a>
<a href="login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>