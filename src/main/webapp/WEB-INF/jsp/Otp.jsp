<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter OTP !!!</title>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1 style="text-align: center;">Enter OTP</h1>

	<form action="CheckOtp" method="post">
	<div style="border: medium; border-color:gray; border-style: solid; width: 400px; height:200px; margin-left: 360px; margin-top: 200px;">
		<br><br>
		<div class="form-group" style="margin-left: 130px;" >
			<label for="Otp">Enter Here:</label><br><br>
			<input type="text" name="otp" class="form-group mx-sm-5 " placeholder="Enter OTP"> 
			<input type="hidden" name="transaction" value="${transactionId}" />
		</div>
		<div align="center">	 
			<input type="submit" value="Submit OTP" class="btn btn-success" style="margin-bottom: 20px;">
		</div>
	</div>
	</form>
</div>
</body>
</html>