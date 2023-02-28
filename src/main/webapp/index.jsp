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

        <p class="overhead"> lead times on new orders are 6-8 weeks</p>

        <img class="logo" src="dispatcher?path=file/logo/wwwwwwwwwwww.png&command=Display file" width="130">
        <img class="curlicue" src="dispatcher?path=file/curlicue/curlicue1.png&command=Display file" width=940px height=30px>


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



    <div id="main"> Основная часть


        <div>
        <c:forEach var="anyName" items="${fullListOfProducts}">
        <li> ${anyName.getBagId()} ${anyName.getBagName()} ${anyName.getBagDescription()} ${anyName.getBagPrice()} </li>
        <img src="dispatcher?path=${anyName.getMainPhotoTitle()}&command=Display file" width="350" height="350">

            <div class="list_models1">
                <c:forEach var="someName" items="${anyName.getListPhoto()}">

                    <img src="dispatcher?path=${someName}&command=Display file" width="170" height="250">

                </c:forEach>
            </div>

        </c:forEach>
        </div>
    </div>

<!--Закрываем тег content-->
</div>



<div id="footer">
Нижний колонтитуefefvevfdvvsfvvfл
</div>




<!--Закрываем тег wrapper-->
</div>








</body>
</html>







