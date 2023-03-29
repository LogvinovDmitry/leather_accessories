<%@ page contentType="text/html;charset=UTF-8"%>

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
    <c:forEach var="anyName" items="${fullListOfProducts}">
        <div class="goods--one-item">
            <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="380" height="280"></a>
            <p> ${anyName.getBagId()} </p>
            <a class="one-item__name" href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><p > ${anyName.getBagName()} </p></a>
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







