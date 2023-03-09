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
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<!--Основная часть-->
<main>

<!--Все товары-->
<div id="goods">
    <c:forEach var="anyName" items="${listOfBagsByCategory}">
        <div class="goods--one-item">
            <img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="380" height="280">
            <!-- <p> ${anyName.getBagId()} </p> -->
            <p class="one-item__name"> ${anyName.getBagName()} </p>
            <!-- <p> ${anyName.getBagDescription()} </p> -->
            <p class="one-item__price">$${anyName.getBagPrice()} USD</p>
        </div>
    </c:forEach>
</div>

<!--Закрываем тег основной части-->
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>



</body>
</html>







