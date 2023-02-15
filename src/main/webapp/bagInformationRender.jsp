<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="app.repository.BagLogicServlet"%>
<%@ page import="app.model.entity.Bag"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<jsp:include page="index.jsp"/>

<div>
    <h2 class="list_models"> Models: </h2>
</div>

<p>
<% List<Bag> bagInformation = (List) request.getAttribute("bagInformation");%>
</p>

<div class="list_models1">
<c:forEach var="anyName" items="${bagInformation}">
<li> ${anyName.getBag_id()} ${anyName.getBag_name()} ${anyName.getBag_description()} ${anyName.getBag_category_inf()} ${anyName.getBag_price()} ${anyName.getBag_date_added()} </li>

<form method="post" action="/del-servlet" enctype="multipart/form-data">
            <input type="submit" name=${anyName.getBag_id()} value="Delete entry">
        </form>

<form method="post" action="/change-servlet" enctype="multipart/form-data">
            <input type="submit" name=${anyName.getBag_id()} value="Change entry">
        </form>


</c:forEach>


</div>




</body>
</html>
