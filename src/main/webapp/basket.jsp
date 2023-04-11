<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
<link href="css/basketStyles.css" rel="stylesheet" type="text/css">
<link href="css/slick.css" rel="stylesheet" type="text/css">
<link href="css/slick-theme.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<div class="title">
    <p class="cart"> cart </p>
</div>

<div class="table_headers">
    <p class="product"> product </p>
    <p class="quantity"> quantity</p>
    <p class="remove"> remove</p>
    <p class="total-prise"> total</p>
</div>

<c:forEach var="anyName" items="${sessionScope.listBagDtoById}">

<div class="one-bag_line">
    <div class="second-inner">
        <div>
            <img src="dispatcher?path=${anyName.key.getMainPhotoTitle()}&command=Display file" width="210" height="155">
        </div>
        <div>
            <p class="inner-text__name_line"> ${anyName.key.getBagName()} </p>
            <p class="inner-text__price_line"> $${anyName.key.getBagPrice()} USD</p>
        </div>
    </div>

    <div class="logo-plus_minus">
        <a href="dispatcher?bagId=${anyName.key.getBagId()}&quantity=remove&command=Change quantity"><img src="images/shopping_icon/minus.png" width="15"></a>
            <p> ${anyName.value} </p>
        <a href="dispatcher?bagId=${anyName.key.getBagId()}&quantity=add&command=Change quantity"><img src="images/shopping_icon/plus.png" width="15"></a>
    </div>

    <div class="change-photos">
      <div class="change-photo">
        <img src="images/shopping_icon/trash-can.png" width="30">
      </div>
      <div class="change-photo">
        <a href="dispatcher?bagId=${anyName.key.getBagId()}&command=Delete entry from cart"><img src="images/shopping_icon/trash-can-red.png" width="30"></a>
      </div>
    </div>


    <div class="price_margin">
        <p class="inner-text__price_line1"> $${anyName.key.getBagPrice()} USD </p>
    </div>

</div>


</div>
</c:forEach>

<div class="total">
    <p class="total-text"> total: $${sessionScope.totalPrise} USD</p>
</div>

<div class="order_page">
    <a class="button__style_order_page-text" href="dispatcher?&command=Order page">go to order page</a>
</div>


<main>
<div id="you-interested">you might be interested...</div>
<div id="goods">
            <c:forEach var="anyName" items="${listForYouInterested}">
                <div class="goods--one-item">
                    <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="380" height="280"></a>
                    <!-- <p> ${anyName.getBagId()} </p> -->
                    <p class="one-item__name"> ${anyName.getBagName()} </p>
                    <!-- <p> ${anyName.getBagDescription()} </p> -->
                    <p class="one-item__price">$${anyName.getBagPrice()} USD</p>
                </div>
            </c:forEach>
        </div>
</main>


<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

</body>
</html>







