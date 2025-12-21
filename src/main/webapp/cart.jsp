<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <table border="1">
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity * item.product.price}</td>
                <td><a href="cart?action=remove&id=${item.product.id}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
    <h3>Total: ${cart.total}</h3>
    <br>
    <a href="products.jsp">Continue Shopping</a>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
