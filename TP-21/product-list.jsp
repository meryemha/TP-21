<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liste des Produits</title>
</head>
<body>
    <h2>Liste des Produits</h2>
    <c:forEach var="product" items="${listeProducts}">
        <p>${product.nom} - ${product.description} - ${product.prix}</p>
    </c:forEach>
</body>
</html>