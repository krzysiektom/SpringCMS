<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 27.04.19
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allCategories</title>
</head>
<body>
<a href="/categories/addCategory">Add Category</a><br>
<c:forEach items="${allCategories}" var="category">
    ${category.name} ${category.description} <a href="edit/${category.id}">Edit</a> <a href="delete/${category.id}">Delete</a> <br>
</c:forEach>
</body>
</html>
