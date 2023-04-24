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

<c:set var = "count" scope = "page" value = "${0}"/>

<c:forEach var="order" items="${allOrderData}">

<c:set var="count" scope="page" value="${count + 1}" />

<div class="inner-order">
    <div class="client-fields">
        <p class="count-value">№ <c:out value = "${count}" /></p>
        <p>orderNumber: <mark>${order.key.getClientNumber()}</mark></p>
        <p>date added: <mark>${order.key.getClientDateAdded()}</mark></p>
        <p>full name: <mark>${order.key.getClientName()}</mark></p>
        <p>phone: <mark>${order.key.getClientPhone()}</mark></p>
        <p>social network: <mark>${order.key.getClientNetwork()}</mark></p>
        <p>address: <mark>${order.key.getClientAddress()}</mark></p>
        <p>comment: <mark>${order.key.getClientComment()}</mark></p>

        <form method="post" action="/dispatcher" enctype="multipart/form-data">
            <div class="inp-padding">
                <input type="hidden" id="delete-order-hidden" name="clientId" value="${order.key.getClientId()}">
                <input class="delete-order" type="submit" name="command" value="Remove order">
            </div>
        </form>
    </div>

    <div class="inner-table">
      <table>
        <col style="width:200px">
        <col style="width:50px">
        <col style="width:150px">
        <col style="width:80px">
        <col style="width:70px">
        <col style="width:80px">
        <thead>
          <tr>
            <th>photo</th>
            <th>ID</th>
            <th>name</th>
            <th>price</th>
            <th>q-ty</th>
            <th>total</th>
          </tr>
        </thead>
        <tbody>


          <c:forEach var="orderTable" items="${order.value}">
              <tr>
                <td><img src="dispatcher?path=${orderTable.getMainPhotoTitle()}&command=Display file" alt="Фото товара" class="product-image"></td>
                <td>${orderTable.getBagId()}</td>
                <td class="name">${orderTable.getBagName()}</td>
                <td>${orderTable.getBagPrice()}$</td>
                <td>${orderTable.getOrderQuantity()}</td>
                <td>${orderTable.getTotal()}$</td>
              </tr>
          </c:forEach>


          <tr>
          <td></td>
          <td></td>
          <td></td>
            <td colspan="2" class="total-price-text">total price:</td>
            <td class="total-price">${order.key.getTotalPrise()}$</td>
          </tr>
        </tbody>
      </table>
    </div>
</div>
</c:forEach>



</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>

</body>
</html>