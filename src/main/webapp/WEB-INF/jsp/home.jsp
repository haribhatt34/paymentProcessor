<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter details !!!</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="paymentProcessor" method="post">
	<div class="col-md-4" style="width:30%; margin-left: 35%; margin-top: 10%">
		<table class="table table-condensed">
				<tr class="active">
					<td>Merchant</td>
					<td>
						<select name="merchant">
						  <option value="1">--Select Merchant--</option>
						  <option value="1">Flipkart</option>
						  <option value="2">Amazon</option>
						  <option value="3">Myntra</option>
						  <option value="4">Walmart</option>
						</select>
					</td>
				</tr>
				<tr class="info">
					<td>Card Number</td>
					<td><input type="text" name="cardNo"></td>
				</tr>
				<tr class="active">
					<td>Expiry Date</td>
					<td><input type="text" name="expiryDate"></td>
				</tr>
				<tr class="info">
					<td>CVV</td>
					<td><input type="password" name="cvv"></td>
				</tr>
				<tr class="active">
					<td>PIN</td>
					<td><input type="password" name="pin"></td>
				</tr>
				<tr class="info">
					<td>Bill Amount</td>
					<td><input type="text" name="bill"></td>
				</tr>
				<tr class="active">
					<td></td>
					<td><input type="submit" value="PayNow"></td>
				</tr>
		</table>
	</div>
</form>
</body>
</html>