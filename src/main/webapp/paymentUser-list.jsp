<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Motor Mart</title>

<style>
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

table th, table td ,table tr{
    border: 2px solid black
    padding: 10px;
    color:black;
}

/* Cx Styles */
.cx {
    margin: 20px auto;
    padding: 20px;
    background-color: rgba(173, 216, 230, 0.8);
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
    <input type="hidden" value="<%= session.getAttribute("userID") %>" name="userID">
    <!-- Main content wrapper -->
    

    <div class="main-content">
          <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newPaymentUser" class="btn btn-success">Add New Payment</a>
        
        <!-- Main content here -->
        <h3 class="text-center">List of Payments</h3>
        </div>
      
      
        
        <div class="cx">
            <div class="table-responsive text-center">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Payment ID</th>
                            <th>User ID</th>
                            <th>Payment Amount</th>
                            <th>Payment Method</th>
                            <th>Payment Date</th>            
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="Payment" items="${listPaymentsUser}">
                            <tr>
                                <td><c:out value="${Payment.paymentID}" /></td>
                                <td><c:out value="${Payment.userID}" /></td>
                                <td><c:out value="${Payment.paymentAmount}" /></td>
                                <td><c:out value="${Payment.paymentMethod}" /></td>
                                <td><c:out value="${Payment.paymentDate}" /></td>      
                                <td>
                                    <a href="<%=request.getContextPath()%>/editPaymentUser?paymentID=<c:out value='${Payment.paymentID}' />" class="btn btn-dark">Edit</a>
                                    <a href="<%=request.getContextPath()%>/deletePaymentUser?paymentID=<c:out value='${Payment.paymentID}' />" class="btn btn-danger">Delete</a>
                                </td>
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
