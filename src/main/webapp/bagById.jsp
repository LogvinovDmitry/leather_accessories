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
<link href="css/bagByIdStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<!--Основная часть-->
<main>

<!--Один конкретный выбранный товар по id-->
<div class="one-bag">

        <div class="inner-photo">
            <img src="dispatcher?path=${bagDto.getMainPhotoTitle()}&command=Display file" width="500" height="370">

            <c:forEach var="someName" items="${bagDto.getListPhoto()}">
                <img src="dispatcher?path=${someName}&command=Display file" width="500" height="370">
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

            <div class="add-to-cart_padding">
                <form method="get" action="dispatcher">
                <input type="hidden" id="addToCart" name="bagId" value=${bagDto.getBagId()}>
                <input class="button__style_add-to-cart" type="submit" name="command" value="Add to Cart">
                </form>
            </div>
            <div>
                <form method="get" action="dispatcher">
                <input type="hidden" id="buyNow" name="bagId" value=${bagDto.getBagId()}>
                <input class="button__style_buy-now" type="submit" name="command" value="Buy now">
                </form>
            </div>
        </div>
</div>

<div id="you-interested">you might be interested...</div>
<div id="goods">
            <c:forEach var="anyName" items="${listForYouInterested}">
                <div class="goods--one-item">
                    <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="350" height="258"></a>
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







