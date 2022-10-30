<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="repository.DataBase.BagLogicServlet"%>
<%@ page import="repository.DataBase.BagParam"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>






<html>
<head>
<meta charset="UTF-8">
<link href="css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Hello Worldppppppppppp!</h2>
<div>
    <h1 class="text_centre"> WELCOMEeeeeeeeee! </h1>
</div>




<p>
<%
List<BagParam> bagInformation = (List) request.getAttribute("bagInformation");
BagParam anBagParam = bagInformation.get(0);
out.print(anBagParam.getBag_id());
out.print(anBagParam.getBag_name());
out.print(anBagParam.getBag_category());
out.print(anBagParam.getBag_description());
%>
</p>


<p>
<% for (BagParam information : bagInformation) {%>
<p> <%= information.getBag_id() + " " + information.getBag_name() + " " + information.getBag_category() + " " +
information.getBag_description() %> </p>



<% } %>
</p>


</body>
</html>
