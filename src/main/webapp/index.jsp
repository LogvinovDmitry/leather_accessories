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
<link href="css/user.css" rel="stylesheet" type="text/css">
</head>

<body>


<div id="wrapper">
<div id="content">

    <!--Блок над шапкой: сроки выполнения рабоот, логотип, узор-->
    <p id="overhead"> lead times on new orders are 6-8 weeks</p>

    <img class="logo" src="dispatcher?path=file/logo/odel.png&command=Display file" width="160">
    <img class="curlicue" src="dispatcher?path=file/curlicue/curlicue1.png&command=Display file" width=940px height=30px>

<!--Шапка-меню с кнопками-->
<div id="header">

    <a class="button_style" href="/start-servlet">home</a>

    <div>
        <form method="get" action="dispatcher">
            <input class="button_style" type="submit" name="command" value="all products">
        </form>
    </div>
    <div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField1" name="category" value="Men's bag">
        <input class="button_style" type="submit" name="command" value="for men">
        </form>
    </div>
    <div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField2" name="category" value="Lady's bag">
        <input class="button_style" type="submit" name="command" value="for women">
        </form>
    </div>
    <div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField3" name="category" value="Accessories">
        <input class="button_style" type="submit" name="command" value="accessories">
        </form>
    </div>

    <a target="_blank" class="button_style" href="https://youtu.be/0igihKnT844">youtube</a>
</div>


<!--Основная часть-->

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

<!--Закрываем тег content-->
</div>


<div id="footer">

    <div class="footer_left">
        <p>ABOUT THE SHOP:</p>
        <p>A small workshop "Smart-quiz" is located in a small town in the south of Ukraine.
        We create exclusively handmade products from high quality materials.
        Each product is made individually for you.</p>
        <p>Hurry up to buy a piece hard, but beloved work and talent of the master.</p>
    </div>

    <div class="footer_center">
        <p> follow us: </p>
        <a target="_blank" href="https://www.instagram.com/"><img src="dispatcher?path=file/icon_inst_fb_ytube/inst.png&command=Display file" width="70" ></a>
        <a target="_blank" href="https://www.facebook.com/logvinov1990/"><img src="dispatcher?path=file/icon_inst_fb_ytube/facebook.png&command=Display file" width="50" ></a>
        <a target="_blank" href="https://youtu.be/0igihKnT844"><img src="dispatcher?path=file/icon_inst_fb_ytube/youtube.png&command=Display file" width="70" ></a>
    </div>

    <div class="footer_right">
        <p> You can also leave your feedback and suggestions here: </p>
        <p class="footer_right_p"> builder141990@gmail.com </p>
    </div>

</div>


<!--Закрываем тег wrapper-->
</div>


</body>
</html>







