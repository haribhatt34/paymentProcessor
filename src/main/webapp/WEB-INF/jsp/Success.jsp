<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful transaction</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<br><br>
	<h1 style="color: green; text-align: center;"> Your Transaction is Successful </h1><br><br>
	<div align="center"><img style="height: 130px; width: 130px;" alt="Success" src="/images/image1.jpg"></div><br><br>
	<div class="container" style="width: 400px;">
		<table class="table table-active table-striped">
			<tr>
				<td>Name</td>
				<td><c:out value="${Name}"/> </td>
			</tr>
			<tr>
				<td>Transaction Id</td>
				<td><c:out value="${TransactionId}"/></td>
			</tr>
			<tr>
				<td>Account Number</td>
				<td><c:out value="${AccountNo}"/></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><c:out value="${Payment}"/></td>
			</tr>
			<tr>
				<td>Date and Time</td>
				<td><c:out value="${Time}"/></td>
			</tr>
		</table>
	</div>
</body>
</html>