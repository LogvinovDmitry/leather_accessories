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


<div class="one-bag_line">
    <div class="second-inner">
        <div>
            <img src="dispatcher?path=${bagDto.getMainPhotoTitle()}&command=Display file" width="210" height="155">
        </div>
        <div>
            <p class="inner-text__name_line"> ${bagDto.getBagName()} </p>
            <p class="inner-text__price_line"> $${bagDto.getBagPrice()} USD</p>
        </div>
    </div>

    <div class="logo-plus_minus">
        <img src="images/shopping_icon/plus.png" width="15">
        <p> 1 </p>
        <img src="images/shopping_icon/minus.png" width="15">
    </div>

    <div class="change-photos">
      <div class="change-photo">
        <img src="images/shopping_icon/trash-can.png" width="30">
      </div>
      <div class="change-photo">
        <a href="dispatcher?bagId=${anyName.getBagId()}&command=Bag by id"><img src="images/shopping_icon/trash-can-red.png" width="30"></a>
      </div>
    </div>
    <div class="price_margin">
        <p class="inner-text__price_line1"> $${bagDto.getBagPrice()} USD </p>
    </div>

</div>

<div class="total">
    <p class="total-text"> total: $${bagDto.getBagPrice()} USD</p>
</div>

<div class="message">
    <p class="message-text"> Thank you for the order! Contact our manager to clarify the payment and order details!  Please note, that in comments you can change the color of the leather and threads in the product, the type and size of buttons, fasteners, clips, rivets, etc. </p>
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







