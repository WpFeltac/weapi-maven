<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <title>Première page JSP</title>
  
</head>
<body>
    <h1>Bienvenue sur WeAPI</h1>
    <p>La date actuelle du serveur est : <%= (new java.util.Date()).toString()%></p>
</body>
</html>