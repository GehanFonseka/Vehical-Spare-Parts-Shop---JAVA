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
        width: 100%;
        background-color: #333333;
        color: white;
        text-align: center;
        padding: 10px 0;
        margin-top: auto;
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
            style="background-color:#333333">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Product Management App </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/buy_list"
                    class="nav-link">Cart</a></li>
            </ul>
        </nav>
    </header>
    <br>
    
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form id="cartForm" action="<c:if test='${Product != null}'>updateCartUser</c:if><c:if test='${Product == null}'>insertCartUser</c:if>" method="post">
                
                <caption>
                    <h2>
                        <c:if test="${Product != null}">
                            Edit Cart
                        </c:if>
                        <c:if test="${Product == null}">
                            Add New Cart
                        </c:if>
                    </h2>
                </caption>

                <fieldset class="form-group">
                    <label>User ID</label> 
                    <input type="number" value="<%= session.getAttribute("userID") %>" class="form-control" name="userID" readonly>
                </fieldset>
                

                <fieldset class="form-group">
                    <label>Product ID</label> 
                    <input type="number" value="<%= request.getParameter("productID") %>" class="form-control" name="productID" required="required" readonly>
                </fieldset>

                <fieldset class="form-group">
                    <label>Product Name</label> 
                    <input type="text" value="<%= request.getParameter("productName") %>" class="form-control" name="productName" required="required" readonly>
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Price</label> 
                    <input type="text" value="<%= request.getParameter("price") %>" class="form-control" name="price" required="required" readonly id="price">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Quantity</label> 
                    <input type="number" value="<c:out value='${Product.quantity}' />" class="form-control" name="quantity" required="required" min="0" id="quantity">
                </fieldset>
                
                <fieldset class="form-group">
                    <label>Total Price</label> 
                    <input type="number" value="<c:out value='${Product.totalPrice}' />'" class="form-control" name="totalPrice" required="required" readonly id="totalPrice">
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

<script>
    document.getElementById('quantity').addEventListener('input', function() {
        var price = parseFloat(document.getElementById('price').value);
        var quantity = parseInt(document.getElementById('quantity').value);
        var totalPrice = price * quantity;
        document.getElementById('totalPrice').value = totalPrice;
    });
</script>

</body>
</html>
