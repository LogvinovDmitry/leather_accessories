package app.controller;

import app.controller.admin.RedirectCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/dispatcher"})
@MultipartConfig
public class ServletDispatcher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommandHelper commandHelper = new CommandHelper();
        Command command = commandHelper.chooseCommand(req); //new FullListOfProductsCommand()
        command.execute(req, resp);


        RequestDispatcher requestDispatcher;
        // В данном случае command = new RedirectCommand;
        // Оператор instanceof проверяет является ли объект comand объектом класса RedirectCommand
        // Обрати внимание на тип переменной comand (он родительский, поэтому мы делаем даункаст на строке №32)
        if (command instanceof RedirectCommand) {
            String newAddress = ((RedirectCommand) command).getNewAddress();
            requestDispatcher = req.getRequestDispatcher(newAddress);

        } else {
            requestDispatcher = req.getRequestDispatcher((String) req.getAttribute("jsp"));
        }


        if (requestDispatcher != null) {
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommandHelper commandHelper = new CommandHelper();
        Command command = commandHelper.chooseCommand(req);
        command.execute(req, resp);
        Object jspName = req.getAttribute("jsp");
        if (jspName  != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher((String) jspName);
            requestDispatcher.forward(req, resp);
        }
    }
}




