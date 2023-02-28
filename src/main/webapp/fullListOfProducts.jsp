<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.model.entity.Bag"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/user.css" rel="stylesheet" type="text/css">

</head>

<body>



<div class="list_mod">
        <form method="get" action="dispatcher">
        <input  type="submit" name="command" value="Full list of products">
        </form>

</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField1" name="category" value="Men's bag">
        <input type="submit" name="command" value="List of men's bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField2" name="category" value="Lady's bag">
        <input type="submit" name="command" value="List of lady's bag bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField3" name="category" value="Accessories">
        <input type="submit" name="command" value="Accessories">
        </form>
</div>

<%--<div>
<!--Эта сточка кода не нужна! т.к. в цикл <c:forEach видит переменные сохраненные только в контексте request. Они могут быть сохранены в любом классе проекта будут доступны в этой jsp-->
<p>
<% List<Bag> fullListOfProducts = (List) request.getAttribute("fullListOfProducts");%>
</p>
</div>--%>



<c:forEach var="anyName" items="${fullListOfProducts}">
<div class="list_models">
<p> <img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="350" height="350"> </p>
<p> ${anyName.getBagName()} </p>
<p> $${anyName.getBagPrice()} USD</p>


<c:forEach var="someName" items="${anyName.getListPhoto()}">

<img src="dispatcher?path=${someName}&command=Display file" width="170" height="250">

</c:forEach>

</div>
</c:forEach>







</body>
</html>
