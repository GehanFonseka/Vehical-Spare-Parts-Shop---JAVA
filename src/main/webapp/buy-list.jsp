<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Motor Mart</title>

<style>
/* Global Styles */
body {
    background-color: #E5E1DA;
    background-image: url('bg.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

.text-center {
    text-align: center;
}

/* Header and Footer */
.header, .footer {
    background-color: #333;
    color: #fff;
    padding: 10px 0;
    text-align: center;
}

/* Main Content */
.main-content {
    margin: 20px auto;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.5);
    /* White background with opacity */
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); /* Shadow effect */
}

.table-responsive {
    margin-top: 20px;
    margin-bottom: 20px;
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table th, table td {
    border: 1px solid #ccc;
    padding: 10px;
}

/* Cx Styles */
.cx {
    margin: 20px auto;
    padding: 20px;
    background-color: rgba(173, 216, 230, 0.2);
    /* Light blue background with opacity */
    border-radius: 10px;
}

/* Buttons */
.btn {
    display: inline-block;
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #0056b3;
}
</style>
</head>

<body>
    <div class="header">
        <jsp:include page="header.jsp"></jsp:include>
    </div>

    <div class="container">
        <input type="hidden" value="<%=session.getAttribute("userID")%>"
            name="userID">
        <div class="main-content">
            <h3 class="text-center">List of Carts</h3>


            <div class="table-responsive">
                <div class="cx">
                    <table>
                        <thead>
                            <tr>
                                <th>Cart ID</th>
                                <th>User ID</th>
                                <th>Product ID</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Total Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="Cart" items="${listCartUser}">
                                <tr>
                                    <td><c:out value="${Cart.cartID}" /></td>
                                    <td><c:out value="${Cart.userID}" /></td>
                                    <td><c:out value="${Cart.productID}" /></td>
                                    <td><c:out value="${Cart.productName}" /></td>
                                    <td><c:out value="${Cart.quantity}" /></td>
                                    <td><c:out value="${Cart.totalPrice}" /></td>
                                    <td><a
                                        href="<%=request.getContextPath()%>/editCartUser?cartID=<c:out value='${Cart.cartID}' />"
                                        class="btn btn-primary">Edit</a> <a
                                        href="<%=request.getContextPath()%>/deleteCartUser?cartID=<c:out value='${Cart.cartID}' />"
                                        class="btn btn-danger">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
