<%--
  Created by IntelliJ IDEA.
  User: krzysztof
  Date: 27.04.19
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>formCategory</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    name: <form:input path="name"/><br>
    description: <form:input path="description"/><br>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
