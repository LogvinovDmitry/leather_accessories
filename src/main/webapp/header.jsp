<%@ page contentType="text/html;charset=UTF-8"%>


<header>
<!--Блок над шапкой: сроки выполнения рабоот, логотип, узор-->
<p class="overhead-text"> lead times on new orders are 6-8 weeks</p>

<img class="header-logo--owl" src="dispatcher?path=file/logo/odel.png&command=Display file" width="160">
<img class="header-logo--curlicue" src="dispatcher?path=file/curlicue/curlicue1.png&command=Display file" width=940px height=30px>

<!--Меню с кнопками-->
<div id="header-buttons">

    <a class="button__style" href="/start-servlet">home</a>

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

    <a target="_blank" class="button__style" href="https://youtu.be/0igihKnT844">youtube</a>
</div>
</header>