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


<form method="post" action="/dispatcher" enctype="multipart/form-data">
<div class="create-order">
    <p>your name</p>
    <input type="text" placeholder="Agata" name="you_name">
    <p>your phone</p>
    <input type="text" placeholder="+Х ХХХ ХХХ-ХХ-ХХ" name="your_phone">
</div>
    <input class="button__style_order_page-text" type="submit" name="command" value="Create new order">

</form>


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




<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

</body>
</html>







