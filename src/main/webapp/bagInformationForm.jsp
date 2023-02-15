<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="repository.database.BagLogicServlet"%>
<%@ page import="app.model.entity.Bag"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>

<body>


<div>
    <h2 class="list_models"> First form: </h2>
</div>

<div>
        <p>To add a new product, fill out the form:</p>
        <form method="post" action="/bag-logic-servlet"> <%--Определяет куда будет отпраленны данный с формы--%>
            <input type="text" <%--Определяет однострочное текстовое поле ввода--%> placeholder="Genre" <%--Подсвечивает ожидаеммый ввод--%> name="type" <%--Каждое поле ввода должно иметь атрибут name для отправки. Если атрибут name опущен, данные этого поля ввода не будут отправлены вообще.--%> size="20">
            <input type="submit" name="command" value="Remove genre">
        </form>
</div>



</body>
</html>
