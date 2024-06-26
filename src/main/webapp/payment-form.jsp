<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body {
	background-color: #E5E1DA !important;
	background-image: url('bg.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
}

footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #333333;
	color: white;
	text-align: center;
	padding: 10px 0;
}

.card-body {
	background-color: #F2F1EB;
	padding: 20px;
}
</style>
<title>Motor Mart</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #333333">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Payment Management  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_payment"
					class="nav-link">Payment</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Payment != null}">
					<form action="updatePayment" method="post">
				</c:if>
				<c:if test="${Payment == null}">
					<form action="insertPayment" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Payment != null}">
            			Edit Payment
            		</c:if>
						<c:if test="${Payment == null}">
            			Add New Payment
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Payment != null}">
					<input type="hidden" name="paymentID"
						value="<c:out value='${Payment.paymentID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User ID</label> <input type="number"
						value="<c:out value='${Payment.userID}' />" class="form-control"
						name="userID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Payment Amount</label> <input type="number"
						value="<c:out value='${Payment.paymentAmount}' />"
						class="form-control" name="paymentAmount" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label for="paymentMethod">Payment Method</label> <select
						class="form-control" name="paymentMethod" id="paymentMethod"
						required="required">
						<option value="Credit Card"
							<c:if test="${Payment.paymentMethod eq 'Credit Card'}">selected</c:if>>Credit
							Card</option>
						<option value="PayPal"
							<c:if test="${Payment.paymentMethod eq 'PayPal'}">selected</c:if>>PayPal</option>
						<option value="Debit Card"
							<c:if test="${Payment.paymentMethod eq 'Debit Card'}">selected</c:if>>Debit
							Card</option>
					</select>
				</fieldset>



				<fieldset class="form-group">
					<label>Payment Date</label> <input type="date"
						value="<c:out value='${Payment.paymentDate}' />"
						class="form-control" name="paymentDate" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<!-- Footer content here -->
		<p>&copy; 2024 Motor Mart Sparepart management Application</p>
	</footer>
</body>
</html>