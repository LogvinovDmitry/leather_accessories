<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
<link href="css/orderPage.css" rel="stylesheet" type="text/css">

</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>





<div class="message-after-oder">
    <p class="message-text">YOUR ORDER NUMBER: <mark>${orderNumberOld}</mark></p>
</div>

<div class="message-after-oder-centre">
    <p class="message-text">Thank you for the order!</p>
    <p class="message-text">You can also get in touch with us in social media or wait the feedback from our manager. He will contact you asap.</p>
</div>

<div class="icon">
    <div>
        <a target="_blank" href="https://www.instagram.com/"><img src="images/icon_inst_fb_ytube/inst.png" width="70" ></a>
    </div>
    <div class="icon-img">
        <a target="_blank" href="https://www.facebook.com/logvinov1990/"><img  class="img-center" src="images/icon_inst_fb_ytube/facebook.png" width="50" ></a>
    </div>
    <div class="icon-img">
        <a target="_blank" href="https://t.me/Dmitriy_Logvinov"><img src="images/icon_inst_fb_ytube/telegram.png" width="50" ></a>
    </div>
</div>


<div class="inner-after-order-page">
<div id="you-interested-after">you might be interested...</div>
<!--Случайные товары, которые могут заинтересовать-->
<div id="goods">
    <c:forEach var="anyName" items="${listForYouInterested}">
        <div class="goods--one-item">
            <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="380" height="280"></a>

            <c:if test="${sessionScope.isAdmin == true}">
                <p class="one-item__id"> Item ID: ${anyName.getBagId()} </p>
            </c:if>

            <a class="one-item__name" href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><p > ${anyName.getBagName()} </p></a>
            <!-- <p> ${anyName.getBagDescription()} </p> -->
            <p class="one-item__price">$${anyName.getBagPrice()} USD</p>

            <c:if test="${sessionScope.isAdmin == true}">
                <div>
                    <form method="post" action="dispatcher">
                        <input type="hidden" id="inputBagId" name="bagId" value=${anyName.getBagId()}>
                        <input class="remove-entry-admin" type="submit" name="command" value="Remove entry">
                    </form>
                </div>
            </c:if>

        </div>
    </c:forEach>
</div>
</div>
<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

</body>
</html>







