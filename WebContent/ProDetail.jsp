<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<table>
		<thead>
		<tr>
		<th>ProductName</th>
		<th>ProductPrice</th>
		<th>ProductDepartment</th>
		</tr>
		</thead>
		<tbody>
			<tr>
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.department }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>