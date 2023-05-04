<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">

<link rel="shortcut icon" href="/favicon.ico">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
<link href="css/slick.css" rel="stylesheet" type="text/css">
<link href="css/slick-theme.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<!--Основная часть-->
<main>

<!--Меняющиеся картинки-->
<div class="your-class" style="width: 700px; height: 516px">
    <c:forEach var="anyName" items="${listForChangingPictures}">
        <div>
            <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="700" height="516"></a>
        </div>
    </c:forEach>
</div>


<div id="you-interested">you might be interested...</div>

<!--Случайные товары, которые могут заинтересовать-->
<div id="goods">
    <c:forEach var="anyName" items="${listForYouInterested}">
        <div class="goods--one-item">
            <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="350" height="258"></a>

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

<!--Закрываем тег основной части-->
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>



  <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
  <script type="text/javascript" src="js/slick.min.js"></script>

  <script type="text/javascript">
    $(document).ready(function(){
      $('.your-class').slick({
        slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 3200,
          dots: true,
          speed: 800,
          <!--fade: true,-->

      });
    });
  </script>



</body>
</html>







