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
					Feedback Management  </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_feedback"
					class="nav-link">Feedbacks</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Feedback != null}">
					<form action="updateFeedback" method="post">
				</c:if>
				<c:if test="${Feedback == null}">
					<form action="insertFeedback" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Feedback != null}">
            			Edit Feedback
            		</c:if>
						<c:if test="${Feedback == null}">
            			Add New Feedback
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Feedback != null}">
					<input type="hidden" name="feedbackID"
						value="<c:out value='${Feedback.feedbackID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User ID</label> <input type="number"
						value="<c:out value='${Feedback.userID}' />" class="form-control"
						name="userID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product ID</label> <input type="number"
						value="<c:out value='${Feedback.productID}' />"
						class="form-control" name="productID" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label for="ratings">Ratings</label> <input type="number"
						value="<c:out value='${Feedback.ratings}' />" class="form-control"
						name="ratings" min="1" max="5"
						oninput="this.value = Math.min(Math.max(parseInt(this.value), 1), 5)"
						required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Message</label>
					<textarea class="form-control" name="message" rows="5"
						required="required">
				        <c:out value="${Feedback.message}" />
				    </textarea>
				</fieldset>


				<fieldset class="form-group">
					<label>Feedback Date</label> <input type="date"
						value="<c:out value='${Feedback.feedbackDate}' />"
						class="form-control" name="feedbackDate" required="required">
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