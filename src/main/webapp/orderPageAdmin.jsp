<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/orderPageAdminStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">


</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>

<!--Основная часть-->
<main>

<div class="title">
    <p class="orders-text"> orders </p>
</div>


<div class="inner-order">
<div class="client-fields">
    <p class="fields-pudding">orderNumber: <mark>ШГОтрп4</mark></p>
    <p class="fields-pudding">date added: <mark>2022-10-10 15:36</mark></p>
    <p class="fields-pudding">full name: <mark>James Smith</mark></p>
    <p class="fields-pudding">phone: <mark>+Х ХХХ ХХХ-ХХ-ХХ</mark></p>
    <p class="fields-pudding">social network: <mark>https://www.facebook.com/...</mark></p>
    <p class="fields-pudding">address: <mark>314 Robinson Lane, Wilmington, DE 19805, USA</mark></p>
    <p class="fields-pudding">comment: <mark>Commenttyjhj, thOur workshop "Smart-quiz" is located in Zaporozhye City in the south of Ukraine. We create exclusively handmade accessories using only genuine organic leather and at an affordable price. Every product is made personally for you. </mark></p>

    <form method="post" action="/dispatcher" enctype="multipart/form-data">
        <div class="inp-padding">
            <input type="hidden" id="delete-order-hidden" name="category" value="Lady's bag">
            <input class="delete-order" type="submit" name="command" value="delete order">
        </div>
    </form>
</div>

<div class="inner-table">
      <table>
        <col style="width:200px">
        <col style="width:90px">
        <col style="width:190px">
        <col style="width:90px">
        <col style="width:50px">
        <col style="width:90px">
        <thead>
          <tr>
            <th>photo</th>
            <th>item ID</th>
            <th>name</th>
            <th>price</th>
            <th>am</th>
            <th>total</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><img src="path/to/product-image.jpg" alt="Фото товара" class="product-image"></td>
            <td>123</td>
            <td class="name">jjferjierjffevfvfvvevewi</td>
            <td>23.76$</td>
            <td>2</td>
            <td>34.67$</td>
          </tr>
          <tr>
            <td><img src="path/to/product-image.jpg" alt="Фото товара" class="product-image"></td>
            <td>456</td>
            <td class="name">rgnhmg,</td>
            <td>45.87$</td>
            <td>1</td>
            <td>45.67$</td>
          </tr>
          <tr>
          <td></td>
          <td></td>
            <td colspan="3" class="total-price-text">total order price:</td>
            <td class="total-price">34.67$</td>
          </tr>
        </tbody>
      </table>
    </div>
</div>

</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

</body>
</html>