<%@ page contentType="text/html;charset=UTF-8"%>

<%@ page import="repository.DataBase.BagLogicServlet"%>
<%@ page import="repository.DataBase.BagParam"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>


<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>

<div>
    <h2 class="list_models"> Models: </h2>
</div>

<p>
<% List<BagParam> bagInformation = (List) request.getAttribute("bagInformation");%>
</p>

<div class="list_models1">
<c:forEach var="anyName" items="${bagInformation}">
<li> ${anyName.getBag_id()} ${anyName.getBag_name()} ${anyName.getBag_description()} ${anyName.getBag_category_inf()} ${anyName.getBag_price()} ${anyName.getBag_date_added()} </li>

<form method="post" action="/del-servlet" enctype="multipart/form-data">
            <input type="submit" name=${anyName.getBag_id()} value="Delete entry">
        </form>

<form method="post" action="/change-servlet" enctype="multipart/form-data">
            <input type="submit" name=${anyName.getBag_id()} value="Change entry">
        </form>


</c:forEach>


</div>

<h2>View the entire list of models from the database:</h2>

<h2 >
<a href="bag-logic-servlet">Click here</a>
</h2>



<h2>To add a new product, fill out the form:</h2>


<!--<div>
        <p>To add a new product, fill out the form:</p>
        <form method="post" action="/bag-logic-servlet"> <%--Определяет куда будет отпраленны данный с формы--%>
            <input type="text" <%--Определяет однострочное текстовое поле ввода--%> placeholder="Genre" <%--Подсвечивает ожидаеммый ввод--%> name="type" <%--Каждое поле ввода должно иметь атрибут name для отправки. Если атрибут name опущен, данные этого поля ввода не будут отправлены вообще.--%> size="20">
            <input type="submit" name="command" value="Remove genre">
        </form>
</div>-->


<div>
        <p>File form:</p>
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







</body>
</html>
