<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="add">
		productID : &nbsp; <input type="number" name="id"><br>
		<br> productName &nbsp; : &nbsp; <input type="text" name="name"><br>
		<br> productCategory &nbsp; : &nbsp; <input type="text" name="cat"><br>
		<br> price &nbsp; : &nbsp; <input type="number" name="price"><br>
		<br> currentStockNumbers &nbsp; : &nbsp; <input type="number" name="qty"><br>
		<br> remarks &nbsp; : &nbsp; <input type="text" name="rem"><br>
		<input type="submit" value="Add Details">
	</form>
</body>
</html>