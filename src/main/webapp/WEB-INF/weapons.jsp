<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Première page JSP</title>
  
</head>
<body>
    <h1>Bienvenue sur WeAPI</h1>
    <p>La date actuelle du serveur est : <%= (new java.util.Date()).toString()%></p>
    <!-- <p>Vous avez actuellement ${weaponList.size()} armes</p> -->
    <p>Vous avez actuellement ${test} armes</p>
</body>
</html>