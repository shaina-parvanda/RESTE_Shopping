<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<%-- <%@page import="com.restful.electronicshopping.entity.Product"%> --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<h1>Add New Product</h1>
<%-- <%  
Product p = new Product();
%> --%>

	<form action="http://localhost:8080/RESTE_Shopping/sellerapp/test" method="post">
	
		<p>
			Product Name : <input type="text" name="productName" />
		</p>
		<p>
			Product Category : <input type="text" name="productCategory" />
		</p>
		<p>
			Price : <input type="text" name="price" />
		</p>
		<p>
			Current Stock : <input type="text" name="currentStockNumbers" />
		</p>
		<p>
			Remarks : <input type="text" name="remarks" />
		</p>
		<input type="submit" value="Add Details" />
	</form>

</body>
</html>