<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 27.04.19
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>allArticles</title>
</head>
<body>
<a href="/articles/addArticle">Add Article</a><br>
<c:forEach items="${allArticles}" var="article">
    title: <a>${article.title}</a><br>
    author: <a>${article.author.firstName} ${article.author.lastName}</a><br>
    category: <c:forEach items="${article.categories}" var="category">
        <a>${category.name}, </a>
    </c:forEach>
    <br>
    <a href="edit/${article.id}">Edit</a> <a href="delete/${article.id}">Delete</a> <br>
</c:forEach>
</body>
</html>
