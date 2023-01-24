<%@ page contentType="text/html;charset=UTF-8"%>



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
        <input type="hidden" id="thisField" name="inputName" value="Men's bag">
        <input type="submit" name="command" value="List of men's bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField" name="inputName" value="Lady's bag">
        <input type="submit" name="command" value="List of lady's bag bags">
        </form>
</div>

<div>
        <form method="get" action="dispatcher">
        <input type="hidden" id="thisField" name="inputName" value="Accessories">
        <input type="submit" name="command" value="Accessories">
        </form>
</div>



</body>
</html>









<!--<h2>View the entire list of models from the database:</h2>

<h2> <%--Ссылка на сервлет--%>
<a href="bag-logic-servlet">Click here</a>
</h2>-->



<!--<div>
              <%--Расшифровка полей формы--%>
            <p>To add a new product, fill out the form:</p>
            <form method="post" action="/bag-logic-servlet"> <%--Определяет куда будет отпраленны данный с формы--%>
                <input type="text" <%--Определяет однострочное текстовое поле ввода--%> placeholder="Genre" <%--Подсвечивает ожидаеммый ввод--%> name="type" <%--Каждое поле ввода должно иметь атрибут name для отправки. Если атрибут name опущен, данные этого поля ввода не будут отправлены вообще.--%> size="20">
                <input type="submit" name="command" value="Remove genre">
            </form>
    </div>-->




<!--<div>
                 <%--Форма для логина и пароля--%>
<form class="login" method="get" action="dispatcher">
    <input type="text" placeholder="Username" name="username" size="30">
    <input type="password" placeholder="********" name="password" size="30">
    <select name="command" id="command">
        <option disabled selected>Choose mode</option>
        <option value="To dataChange">editor</option>
        <option value="To mainPage">user</option>
    </select>
    <input type="submit" value="Submit">
</form>
</div>-->