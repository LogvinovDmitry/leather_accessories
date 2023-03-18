<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.model.entity.Bag"%>
<%@ page import="app.service.UserService"%>
<%@ page import="app.service.impl.UserServiceImpl"%>

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

<!--Один конкретный выбранный товар по id-->

<div id="inner">
        <div class="inner-photo">
            <img src="dispatcher?path=${bagDto.getMainPhotoTitle()}&command=Display file" width="560" height="414">

            <c:forEach var="someName" items="${bagDto.getListPhoto()}">
                <img src="dispatcher?path=${someName}&command=Display file" width="560" height="414">
            </c:forEach>
        </div>
        <div class="inner-text">
            <!--<p> ${bagDto.getBagId()} </p>-->
            <p class="inner-text__name"> ${bagDto.getBagName()} </p>
            <p class="inner-text__price"> $${bagDto.getBagPrice()} USD</p>
            <p class="inner-text__description-title"> Description </p>

            <div class="inner-text__description">
            ${bagDto.getBagDescription()}
            </div>
        </div>
</div>
<!--Закрываем тег основной части-->
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>



</body>
</html>







