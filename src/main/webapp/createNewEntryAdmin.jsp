<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/createNewEntryAdminStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">


</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>

<!--Основная часть-->
<main>
    <p class="element-padding">To add a new product, fill out the form:</p>

    <form method="post" action="/dispatcher" enctype="multipart/form-data">

        <input type="text" placeholder="Name (Standart №1)" name="bag_name">
        <input type="text" placeholder="Price (56.00)" name="bag_price">
        <!--<input class="form_admin_input" type="text" placeholder="Сategory: M, W, A (1, 2, 3)" name="bag_category">-->

        <input class="element-padding-first_input" type="radio" value="1" name="bag_category"/>for men
        <input class="element-padding-second_input" type="radio" value="2" name="bag_category"/>for women
        <input class="element-padding-third_input" type="radio" value="3" name="bag_category"/>accessories

        <div class="description">
            <p> <textarea rows="30" cols="70" class="form_admin_input" placeholder="Description" name="bag_description"></textarea></p>
            <div class="description-example">
                <p class="title">Filling example "Description":</p>
                <p><mark>{p}</mark>The Long Wallet is a unisex leather wallet for the person who carries everything. Whether it’s cash, coins, cards, or receipts, the Long Wallet has got you covered. Made from the finest leathers and highest quality hardware, this wallet will age beautifully and only get better with time. Built for life.<mark>{/p}</mark></p>
                <p><mark>{p}</mark>Features:<mark>{/p}</mark></p>
                <p><mark>{ul}</mark></p>
                <ul>
                <li><mark>{li}</mark>100% handcrafted by a single craftsman<mark>{/li}</mark></li>
                <li><mark>{li}</mark> Fairtrade made - Ethnically sourced materials<mark>{/li}</mark></li>
                <li><mark>{li}</mark> 6 Card Pockets (holds 2-3 cards each)<mark>{/li}</mark></li>
                <li><mark>{li}</mark> 3 Large bill/receipt pockets<mark>{/li}</mark></li>
                <li><mark>{li}</mark> 1 Large zippered pocket for coins and other things<mark>{/li}</mark></li>
                <li><mark>{li}</mark> Machine Stitched with bonded nylon thread<mark>{/li}</mark></li>
                </ul>
                <p><mark>{/ul}</mark></p>
                <p><mark>{p}</mark>Additional paragraph. (If necessary, you can add paragraphs by framing them with brackets)<mark>{/p}</mark></p>
            </div>
        </div>
        <div class="inp-padding">
        <p class="main-photo"> Upload a main product photo:</p>
        <p> <input type="file" name="file_main_photo_title" accept=".jpg, .jpeg, .png"> </p>
        <p class="other-photos"> Upload other product photos:</p>
        <p><input type="file" name="file_name_1" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_2" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_3" accept=".jpg, .jpeg, .png"></p>
        <p><input type="file" name="file_name_4" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_5" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_6" accept=".jpg, .jpeg, .png"></p>
        <p><input type="file" name="file_name_7" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_8" accept=".jpg, .jpeg, .png">
        <input type="file" name="file_name_9" accept=".jpg, .jpeg, .png"></p>

        <input class="create-entry" type="submit" name="command" value="Create new entry">
        </div>
    </form>
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

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



