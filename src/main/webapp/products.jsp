<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <h1>Products</h1>
    <form action="products" method="get">
        <input type="text" name="query" placeholder="Search for products..."/>
        <input type="submit" value="Search"/>
    </form>
    <br>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td><a href="cart?action=add&id=${product.id}">Add to Cart</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
