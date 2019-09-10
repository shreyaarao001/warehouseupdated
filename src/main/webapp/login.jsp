<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ware House Management System</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter id!!");
			return false;
		}
		if (document.getElementById("password").value.length == 0) {
			alert("please enter password!!");
			return false;
		}

	}
</script>
<body bgcolor="#a3a3a3">
<form action="control" method="post" onsubmit="return msg()">
<center>
<h1>WAREHOUSE MANAGEMENT SYSTEM</h1>
<table>
<tr><td>id:</td></tr>
<tr><td><input type="text" name="id" id="id"></td></tr>
<tr><td>password:</td></tr>
<tr><td><input type="password" name="password" password="password"></td></tr>
<tr><td><input type="submit"></td></tr>
</table>
</center>
</form>
</body>
</html>