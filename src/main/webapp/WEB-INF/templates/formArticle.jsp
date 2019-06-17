<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 27.04.19
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>formArticle</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    title: <form:input path="title"/><br>
    author: <form:select path="author" items="${allAuthors}" itemLabel="lastName" itemValue="id"/><br>
    authors: <form:select path="categories" items="${allCategories}" itemLabel="name"
                          itemValue="id" multiple="true"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
