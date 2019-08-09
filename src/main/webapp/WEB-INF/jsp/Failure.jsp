<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Failed Transaction</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<br><br>
	<h1 style="color: red; text-align: center;"> Your Transaction is Failed </h1><br><br>
	<div align="center"><img style="height: 130px; width: 130px;" alt="Success" src="/images/declined.jpg"></div><br><br>
	<div class="container" style="width: 400px;">
		<table class="table table-active table-striped">
			<tr>
				<td>Transaction Id</td>
				<td><c:out value="${TransactionId}"/></td>
			</tr>
			<tr>
				<td>Amount</td>
				<td><c:out value="${Payment}"/></td>
			</tr>
			<tr>
				<td>Date and Time</td>
				<td><c:out value="${Time}"/></td>
			</tr>
			<tr>
				<td>Reason</td>
				<td><c:out value="${Message}"/></td>
			</tr>
		</table>
	</div>
</body>
</html>