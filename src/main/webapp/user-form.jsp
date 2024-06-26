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
    background-color: rgba(242, 241, 235, 0.5); /* Light gray with adjusted opacity */
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
				<a href="#" class="navbar-brand"> User
					Management  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_user"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${User != null}">
					<form action="updateUser" method="post">
				</c:if>
				<c:if test="${User == null}">
					<form action="insertUser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${User != null}">
            			Edit User
            		</c:if>
						<c:if test="${User == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${User != null}">
					<input type="hidden" name="id"
						value="<c:out value='${User.userID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${User.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${User.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Phone Number</label> <input type="text"
						value="<c:out value='${User.phoneNumber}' />" class="form-control"
						name="phoneNumber" required="required" pattern="[0-9]{10}"
						title="Please enter a 10-digit phone number">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${User.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${User.password}' />" class="form-control"
						name="password" required="required"
						pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{1,6}$"
						title="Password must contain at least one letter, one number, and be at most 6 characters long">
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