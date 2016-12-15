<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX JSP</title>
    <%-- <link rel="stylesheet" href="<c:url value="css/stylesheet1.css" />" type="text/css"> --%>
    <spring:url value="/css/stylesheet1.css" var="mainCss" />
</head>
<body>
<h1>INDEX JSP</h1>
<br><br>
    <a href="/jspTest">Go to Secure JSP</a>
    <br><br>
    <a href="/chat/help">Go to REST Chat</a>
    <br><br>
    <a href="/logout">SIGN OUT</a>
    <br><br>
    <a href="/jsp/viewAll">Go to JSP Chat</a>
    <p>this is a test</p>
</body>
</html>