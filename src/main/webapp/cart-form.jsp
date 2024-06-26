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
				<a href="https://www.javaguides.net" class="navbar-brand"> Cart
					Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_cart"
					class="nav-link">Cart</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Cart != null}">
					<form action="updateCart" method="post">
				</c:if>
				<c:if test="${Cart == null}">
					<form action="insertCart" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Cart != null}">
            			Edit Cart
            		</c:if>
						<c:if test="${Cart == null}">
            			Add New Cart
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Cart != null}">
					<input type="hidden" name="cartID"
						value="<c:out value='${Cart.cartID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User ID</label> <input type="number"
						value="<c:out value='${Cart.userID}' />" class="form-control"
						name="userID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product ID</label> <input type="number"
						value="<c:out value='${Cart.productID}' />" class="form-control"
						name="productID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Name</label> <input type="text"
						value="<c:out value='${Cart.productName}' />" class="form-control"
						name="productName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Quantity</label> <input type="number"
						value="<c:out value='${Cart.quantity}' />" class="form-control"
						name="quantity" required="required" min="0">
				</fieldset>

				<fieldset class="form-group">
					<label>Total Price</label> <input type="number"
						value="<c:out value='${Cart.totalPrice}' />" class="form-control"
						name="totalPrice" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<!-- Footer content here -->
		<p>&copy; Motor Mart Sparepart management Application</p>
	</footer>
</body>
</html>