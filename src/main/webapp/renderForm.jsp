<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="repository.database.BagLogicServlet"%>
<%@ page import="repository.database.BagParam"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>

<body>

<p>
<% Integer param = (Integer) request.getAttribute("sec");%>
</p>

<%= param %>

</body>
</html>
