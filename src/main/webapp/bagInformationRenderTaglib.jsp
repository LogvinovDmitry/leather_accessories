<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="repository.DataBase.BagLogicServlet"%>
<%@ page import="repository.DataBase.BagParam"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Hello Woooooorld!</h2>
<div>
    <h1 class="text_centre"> WELCoooooOME! </h1>
</div>


<p>
<% List<BagParam> bagInformation = (List) request.getAttribute("bagInformation");
for (BagParam information : bagInformation) {%>
<p> <%= information.getBag_id() + " " + information.getBag_name() + " " + information.getBag_category() + " " +
information.getBag_description() %> </p>

<% } %>
</p>

<div class="rightForm">
<c:forEach var="anyName" items="${bagInformation}">
<p> ${anyName.getBag_name()} </p>
</c:forEach>
</div>

<%
String[] ggg = new String[] {"dsds", "ewewew", "qqwqwqw", "ffffff", "rrrrrr"};
request.setAttribute("urls", ggg);
%>


<c:forEach var="any" items="${urls}">
${any}
</c:forEach>




</body>
</html>
