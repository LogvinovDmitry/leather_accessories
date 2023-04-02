<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<!--Блок над шапкой: сроки выполнения рабоот, логотип, узор-->
<p class="overhead-text"> lead times on new orders are 6-8 weeks</p>

<!--Меню с кнопками-->
<div class="inner">

    <div class="header-logo--owl">
        <img src="images/logo/odel.png" width="160">
    </div>

    <div class="curlicue-buttons">
        <div class="curlicue"></div>

        <div id="header-buttons">

            <div>
                <a class="button__style" href="/start-servlet">home</a>
            </div>
            <div>
                <form method="get" action="dispatcher">
                    <input class="button__style" type="submit" name="command" value="all products">
                </form>
            </div>
            <div>
                <form method="get" action="dispatcher">
                <input type="hidden" id="thisField1" name="category" value="Men's bag">
                <input class="button__style" type="submit" name="command" value="for men">
                </form>
            </div>
            <div>
                <form method="get" action="dispatcher">
                <input type="hidden" id="thisField2" name="category" value="Lady's bag">
                <input class="button__style" type="submit" name="command" value="for women">
                </form>
            </div>
            <div>
                <form method="get" action="dispatcher">
                <input type="hidden" id="thisField3" name="category" value="Accessories">
                <input class="button__style" type="submit" name="command" value="accessories">
                </form>
            </div>
            <div>
                <a target="_blank" class="button__style" href="https://youtu.be/0igihKnT844">youtube</a>
            </div>


            <c:if test="${sessionScope.isAdmin == true}">
                <div>
                    <a class="create-entry-admin" href="/createNewEntryAdmin.jsp">Create new entry</a>
                </div>
            </c:if>

            <c:if test="${sessionScope.isAdmin == true}">
                <div>
                    <form method="get" action="dispatcher">
                    <input class="create-entry-admin" type="submit" name="command" value="Exit admin">
                </form>
                </div>
            </c:if>

        </div>
    </div>

    <div class="basket">
            <img src="images/shopping_icon/shopping_icon-icons.png" width="60">
            <p>(0)</p>
    </div>
</div>
</header>