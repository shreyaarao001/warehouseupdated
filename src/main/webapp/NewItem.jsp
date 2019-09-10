<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item Page</title>
</head>
<script type="text/javascript">
function msg() {
		if (document.getElementById("name").value.length == 0) {
			alert("please enter name!!");
			return false;
		}
		if (document.getElementById("price").value.length == 0) {
			alert("please enter price!!");
			return false;
		}
		if (document.getElementById("stock").value.length == 0) {
			alert("please enter stock!!");
			return false;
		}

	}
</script>
<body bgcolor="#a3a3a3">
<form name="index" style="text-align:center" method="post" action="item" onsubmit="return msg()">
<h3 style="color:blue">Create a new Item</h3>
<table border="1" align="center" >
<tr><td>Item Name:</td><td><input type="text" name="name" value="" id="name"></td></tr>
<tr><td>Price:</td><td><input type="text" name="price" value="" id="price"></td></tr>
<tr><td>Stock:</td><td><input type="text" name="stock" value="" id="stock"></td></tr>
<tr><td><input type="submit" name="index_validate" value="submit"></td></tr><tr>
</table>
<a href="Home.jsp"><input type="button" name="button" value="back"></a>
<a href="login.jsp"><input type="button" name="button" value="logout"></a>
</form>
</body>
</html>