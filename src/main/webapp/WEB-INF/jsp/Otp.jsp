<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter OTP</h1>

	<form action="CheckOtp" method="post">
		<input type="text" name="otp"> <input type="hidden"
			name="transaction" value="${transactionId}" /> <input type="submit"
			value="SubmitOtp">
	</form>

</body>
</html>