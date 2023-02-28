<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.model.entity.Bag"%>
<%@ page import="app.service.UserService"%>
<%@ page import="app.service.impl.UserServiсeImpl"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
<link href="css/test.css" rel="stylesheet" type="text/css">

</head>
<body>




<div>
        <p>Buttons for the user</p>
        <form method="get" action="dispatcher">
            <input type="submit" name="command" value="Full list of products">
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




<div class="list_models1">
<c:forEach var="anyName" items="${fullListOfProducts}">
<li> ${anyName.getBagId()} ${anyName.getBagName()} ${anyName.getBagDescription()} ${anyName.getBagPrice()} </li>
<img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="350" height="350">

<div class="list_models1">
<c:forEach var="someName" items="${anyName.getListPhoto()}">

<img src="dispatcher?path=${someName}&command=Display file" width="170" height="250">

</c:forEach>
</div>

</c:forEach>
</div>








</body>
</html>







