<%@ page contentType="text/html;charset=UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="app.model.entity.Bag"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>
<div>
        <p>To add a new product, fill out the form:</p>
        <form method="post" action="/bag-logic-servlet" enctype="multipart/form-data">
            <input type="text" placeholder="Name (Standart №1)" name="form_bag_name">
            <input type="text" placeholder="Сategory: M, W, A (1, 2, 3)" name="bag_category">
            <input type="text" placeholder="Price (56.00)" name="bag_price">
            <input type="text" placeholder="Date (YYYY-MM-DD)" name="bag_date_added">
           <p> <input type="text" placeholder="Description" name="bag_description" size="140"> </p>
           <p> <input type="file" placeholder="Genre" name="file-name"> </p>
            <input type="submit" name="command-file" value="Add product to database">
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

<%--<div>
<!--Эта сточка кода не нужна! т.к. в цикл <c:forEach видит переменные сохраненные только в контексте request. Они могут быть сохранены в любом классе проекта будут доступны в этой jsp-->
<p>
<% List<Bag> fullListOfProducts = (List) request.getAttribute("fullListOfProducts");%>
</p>
</div>--%>


<div class="list_models1">
<c:forEach var="anyName" items="${fullListOfProducts}">
<li> ${anyName.getBagId()} ${anyName.getBagName()} ${anyName.getBagDescription()} ${anyName.getBagPrice()} ${anyName.getMainPhotoTitle()}</li>

<div class="list_models1">
<c:forEach var="someName" items="${anyName.getListPhoto()}">
<li> ${someName} </li>

</c:forEach>
</div>

</c:forEach>
</div>


<div>
    <img src="dispatcher?path=file/619484b4-b89b-4094-ba8b-e1da87f39862photo_2022-12-05_11-38-23.jpg&command=Display file" width="270" height="350">

</div>


</body>
</html>
