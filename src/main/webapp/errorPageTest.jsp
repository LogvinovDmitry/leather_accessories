<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<link href="css/headerFooterStyles.css" rel="stylesheet" type="text/css">
<link href="css/slick.css" rel="stylesheet" type="text/css">
<link href="css/slick-theme.css" rel="stylesheet" type="text/css">
</head>

<body>

<!--Шапка сайта-->
<jsp:include page="header.jsp"/>


<!--Основная часть-->
<main>

<div class="header-logo--owl">
        <img src="images/logo/odel.png" width="160">
    </div>

<div>
<p class="error-text"> It is not possible to delete the product because it is contained in the order list. Delete orders that contain this product first. After that, you can delete the toar itself. </p>
</div>

<!--Закрываем тег основной части-->
</main>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>


</body>
</html>







