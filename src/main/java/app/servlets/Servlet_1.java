package app.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class Servlet_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setContentType("text/html;charset=UTF-8"); //Добавить русский язык (а вообще подсказать клиенту (браузеру) какой тип данный будет отослан в ответе
        PrintWriter pr = httpServletResponse.getWriter();

        pr.println("<html>");
        pr.println("<h1> This is my first servlet и меня зовут" + "</h1> ");
        pr.println("</html>");
    }
}
