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
<link href="css/userGo.css" rel="stylesheet" type="text/css">
<link href="css/header-footer.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<!--Основная часть-->
<main>

<!--Меняющиеся картинки-->
<div class="imgContainer">
    <c:forEach var="anyName" items="${listForChangingPictures}">
        <img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" >
    </c:forEach>
</div>

<div id="you_interested">you might be interested...</div>

<!--Случайные товары, которые могут заинтересовать-->
<div id="main">
    <c:forEach var="anyName" items="${listForYouInterested}">
        <div class="name_price">
            <img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="380" height="280">
            <!-- <p> ${anyName.getBagId()} </p> -->
            <p class="name"> ${anyName.getBagName()} </p>
            <!-- <p> ${anyName.getBagDescription()} </p> -->
            <p class="price">$${anyName.getBagPrice()} USD</p>
        </div>
    </c:forEach>
</div>

<!--Закрываем тег основной части-->
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>



</body>
</html>







