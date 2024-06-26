<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Motor Mart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <style>
        body {
            background-color: #E5E1DA !important;
            background-image: url('bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
        }

        footer {
            width: 100%;
            background-color: #333333;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: auto;
        }

        .card-body {
            background-color: rgba(173, 216, 230, 0.5); /* Light blue background with opacity */
            padding: 20px;
        }
        .container{
         background-color: rgba(173, 216, 230, 0.7); /* Light blue background with opacity */
            padding: 20px;
        }
    </style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
            style="background-color:#333333">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Vehicle Spare Management </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/buy_list"
                    class="nav-link">Cart</a></li>
            </ul>
        </nav>
    </header>
    <br>
    
    <div class="container">
        <h3 class="text-center">List of Products</h3>
        <hr>
        
        <br>
        <div class="row">
            <c:forEach var="Product" items="${listProducts}">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><c:out value="${Product.productName}" /></h5>
                            <p class="card-text"><c:out value="${Product.description}" /></p>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Category: <c:out value="${Product.category}" /></li>
                                <li class="list-group-item">Price: <c:out value="${Product.price}" /></li>
                                <li class="list-group-item">Quantity: <c:out value="${Product.quantity}" /></li>
                                <li class="list-group-item">User ID: <c:out value="${Product.userID}" /></li>
                            </ul>
                            <div class="mt-3">
                                <!-- Link to redirect to buy-form.jsp with product details -->
                                <a href="<%=request.getContextPath()%>/addToCart?productID=${Product.productID}&productName=${Product.productName}&price=${Product.price}">Add to Cart</a>

                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <footer>
        <!-- Footer content here -->
        <p>&copy; 2024 Motor Mart Sparepart management Application</p>
    </footer>
</body>
</html>
