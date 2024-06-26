<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Motor Mart</title>
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/images/icons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/images/icons/favicon-16x16.png">
<link rel="shortcut icon" href="assets/images/icons/favicon.ico">
<!-- Stylesheets -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
body {
    background-color: #E5E1DA !important;
    background-image: url('bg.jpg'); /* Replace 'path/to/your/image.jpg' with the actual path to your image */
    background-size: cover; /* Cover the entire background */
    background-repeat: no-repeat; /* Prevent the background image from repeating */
    background-position: center; /* Center the background image */
}


.sidebar {
    height: calc(100vh - 60px); /* Adjusted sidebar height */
    width: 250px;
    position: fixed;
    left: 0;
    background-color: #34495e; /* Dark blue background */
    padding-top: 10px; /* Adjust padding to fit content */
}

.sidebar .nav-link {
    color: #fff; /* White text color */
    transition: color 0.3s ease;
}

.sidebar .nav-link:hover {
    color: #ccc; /* Light gray text color on hover */
}


}

.nav-item {
    margin-bottom: 10px; /* Add space between each navigation item */
}

.nav-link {
    color: #ffffff; /* Text color */
    transition: color 0.3s ease; /* Smooth transition effect for text color */
}

.nav-link:hover {
    color: #ccc; /* Change text color on hover */
}

.nav-link.active {
    font-weight: bold; /* Make the active link bold */
    background-color: #333333; /* Dark background color for active link */
    padding: 8px 15px; /* Padding for active link */
    border-radius: 5px; /* Rounded corners */
}

.sidebar {
    padding: 20px;
    border-right: 1px solid #ccc; /* Add a border to separate sidebar from content */
}


.content {
	padding: 20px;
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
</style>
</head>
<body>
	<div class="page-wrapper">
		<header>
			<nav class="navbar navbar-expand-md navbar-dark"
				style="background-color: #333333">
				<div>
					<a href="home.jsp" class="logo"
						style="font-size: 24px; font-weight: bold; text-decoration: none; color: #ADD8E6;">
						Motor Mart </a>
				</div>
				<div class="header-right">
					<ul class="top-menu">
						<li><a href="#">Links</a>
							<ul>
								<li class="nav-item ms-3"><span class="input-group-btn">
										<form action="logout" method="post">
											<button class="nav-link button" data-bs-toggle="modal"
												data-bs-target="#signup-modal" type="submit"
												style="background-color: #ADD8E6; color:black;">Logout</button>

										</form>
								</span></li>
							</ul></li>
					</ul>
					<!-- End .top-menu -->
				</div>
				<!-- End .header-right -->

			</nav>
		</header>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<div class="sidebar">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link active"
								href="admin-dash.jsp">Dashboard</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/list_user">Users</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/list_product">Products</a></li>
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/list_cart" class="nav-link">Cart</a>
							</li>
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/list_payment"
								class="nav-link">Payments</a></li>
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/list_feedback"
								class="nav-link">Feedbacks</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-10">
					<div class="content">
						<h4>Welcome Back! Admin</h4>
						<br> Motor Mart is a cutting-edge mobile application tailored
						for seamless management of vehicle spare parts. With the
						ever-expanding realm of automotive aftermarket, there arises a
						necessity for a cohesive platform that simplifies the procurement
						and distribution process of spare parts. Motor Mart offers a
						user-friendly interface for both buyers and sellers, ensuring
						secure transactions and optimized inventory management. Sellers
						can list their spare parts for sale, while buyers can browse
						through a diverse range of offerings with ease. Moreover, users
						have the opportunity to provide feedback and ratings, contributing
						to the continual enhancement of our platform.
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<p>&copy; 2024 Motor Mart Sparepart management Application</p>
	</footer>
</body>
</html>
