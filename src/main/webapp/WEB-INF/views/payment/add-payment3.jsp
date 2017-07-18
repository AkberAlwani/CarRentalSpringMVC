<html>
<head>
<meta charset="ISO-8859-1" />
<title>Add Payment</title>
</head>

<body>
	<h1>Pay your reservation bill</h1>
	<form th:action="@{pay-bill}" th:object="${payment}" method="post">
		<table>
			<tr>
				<td>Amount</td>
				<td><input type="text" name="amount" /></td>

			</tr>
			<tr>
				<td>Selection Card Type</td>
				<td><select name="paymentType">
						<option value="Credit Card">Credit Card</option>
						<option value="Master Card">Master Card</option>
						<option value="Visa Card">Visa Card</option>
				</select></td>
			</tr>
			<tr>
				<td>Card Number</td>
				<td><input type="text" name="cardNumber" /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="text" name="expiryDate" /></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvv" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Pay" /></td>
			</tr>
		</table>
	</form>
</body>

</html>
