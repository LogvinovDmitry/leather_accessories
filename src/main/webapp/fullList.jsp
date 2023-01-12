<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.repository.BagLogicServlet"%>
<%@ page import="app.repository.BagParam"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

<p>
<% List<BagParam> fullList = (List) request.getAttribute("fullList");%>
</p>

<div class="list_models1">
<c:forEach var="anyName7" items="${fullList}">
<li> ${anyName7.getBag_id()} ${anyName7.getBag_name()} ${anyName7.getBag_description()} ${anyName7.getBag_category_inf()} ${anyName7.getBag_price()} ${anyName7.getBag_date_added()} </li>
</c:forEach>


</div>

</body>
</html>
