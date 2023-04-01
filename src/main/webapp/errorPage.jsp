<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyles.css" rel="stylesheet" type="text/css">
<title>Error</title>
</head>

<body>

<p>
    <c:out value="${requestScope.errMsg}"/>
</p>

</body>
</html>







