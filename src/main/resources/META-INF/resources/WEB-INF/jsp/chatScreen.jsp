<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" href="<c:url value="css/stylesheet1.css" />" type="text/css">
</head>
<body>
<h1>Chats</h1>
<form action="/jsp/newMessage" method="POST">
    <input type="text" placeholder="Enter your message" name="message">
    <button type ="submit">Post</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>


    <c:forEach var="chat" items="${myChats}">
        <p>
        <c:out value="${chat.message}"/>
        </p>
    </c:forEach>


    <c:forEach var="chat" items="${chats}">
        <p>
        <c:out value="${chat.message}"/>
        </p>
    </c:forEach>




</body>
</html>