<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.model.BagParam"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>


<p>
<% List<BagParam> fullListOfProducts = (List) request.getAttribute("fullListOfProducts");%>
</p>

<div class="list_models1">
<c:forEach var="anyName7" items="${fullListOfProducts}">
<li> ${anyName7.getBagId()} ${anyName7.getBagName()} ${anyName7.getBagDescription()} ${anyName7.getBagCategoryInf()} ${anyName7.getBagPrice()} ${anyName7.getBagDateAdded()} </li>

</c:forEach>
</div>




</body>
</html>
