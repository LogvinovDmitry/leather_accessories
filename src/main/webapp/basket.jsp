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



<div>

dsfghgjhkjl;lk


</div>

<!--Футер сайта-->
<jsp:include page="footer.jsp"/>



  <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
  <script type="text/javascript" src="js/slick.min.js"></script>

  <script type="text/javascript">
    $(document).ready(function(){
      $('.your-class').slick({
        slidesToShow: 1,
          slidesToScroll: 1,
          autoplay: true,
          autoplaySpeed: 3200,
          dots: true,
          speed: 800,
          <!--fade: true,-->

      });
    });
  </script>



</body>
</html>







