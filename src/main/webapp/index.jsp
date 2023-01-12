<%@ page contentType="text/html;charset=UTF-8"%>



<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">

</head>

<body>
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


<!--<div>
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


<div>
        <p>View full list of mvc pattern:</p>
        <form method="get" action="dispatcher">
            <input type="submit" name="command" value="Full list of products">
        </form>
</div>

</body>
</html>
