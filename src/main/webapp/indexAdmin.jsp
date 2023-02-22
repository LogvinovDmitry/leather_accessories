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
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>
<body>

<div>
        <p>To add a new product, fill out the form:</p>
        <form method="post" action="/dispatcher" enctype="multipart/form-data">
            <input type="text" placeholder="Name (Standart №1)" name="bag_name">
            <input type="text" placeholder="Сategory: M, W, A (1, 2, 3)" name="bag_category">
            <input type="text" placeholder="Price (56.00)" name="bag_price">
           <p> <input type="text" placeholder="Description" name="bag_description" size="140"> </p>
           <p> Upload a main product photo:</p>
           <p> <input type="file" name="file_main_photo_title"> </p>

           <p> Upload other product photos:</p>
           <p><input type="file" name="file_name_1">
           <input type="file" name="file_name_2">
           <input type="file" name="file_name_3"></p>
           <p><input type="file" name="file_name_4">
           <input type="file" name="file_name_5">
           <input type="file" name="file_name_6"></p>
           <p><input type="file" name="file_name_7">
           <input type="file" name="file_name_8">
           <input type="file" name="file_name_9"></p>

           <%--<p> Upload other product photos:
           <input type="file" name="file_names[]" multiple></p>--%>

           <input type="submit" name="command" value="Create new entry">
        </form>
</div>

<div>
        <p>Buttons for the user</p>
        <form method="get" action="dispatcher">
            <input type="submit" name="command" value="Full list of products">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField1" name="category" value="Men's bag">
        <input type="submit" name="command" value="List of men's bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField2" name="category" value="Lady's bag">
        <input type="submit" name="command" value="List of lady's bag bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField3" name="category" value="Accessories">
        <input type="submit" name="command" value="Accessories">
        </form>
</div>


<div class="list_models1">
<c:forEach var="anyName" items="${fullListOfProducts}">
<li> ${anyName.getBagId()} ${anyName.getBagName()} ${anyName.getBagDescription()} ${anyName.getBagPrice()} ${anyName.getMainPhotoTitle()} ${anyName.getBagDateAdded()}</li>

<div class="list_models1">
<c:forEach var="someName" items="${anyName.getListPhoto()}">
<li> ${someName} </li>

</c:forEach>
</div>

</c:forEach>
</div>








</body>
</html>










<%--<h2>View the entire list of models from the database:</h2>

<h2> <!--Ссылка на сервлет-->
<a href="bag-logic-servlet">Click here</a>
</h2>--%>



<%--<div>
              <!--Расшифровка полей формы-->
            <p>To add a new product, fill out the form:</p>
            <form method="post" action="/bag-logic-servlet"> <!--Определяет куда будет отпраленны данный с формы-->
                <input type="text" placeholder="Genre" name="type" size="20">
                <!--type="text" Определяет однострочное текстовое поле ввода placeholder="Genre" Подсвечивает ожидаеммый ввод name="type" Каждое поле ввода должно иметь атрибут name для отправки. Если атрибут name опущен, данные этого поля ввода не будут отправлены вообще size="20"-->
                <input type="submit" name="command" value="Remove genre">
            </form>
</div>--%>



