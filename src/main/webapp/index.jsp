<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Contents</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.weight}</td>
            <c:forEach var="content" items="${product.contents}">
                <td>${content}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>