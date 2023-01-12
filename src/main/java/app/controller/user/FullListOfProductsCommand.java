package app.controller.user;

import app.controller.Command;
import app.repository.BagParam;
import app.service.imp.UserServiseImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FullListOfProductsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


//Положить в атрибут полный список продукции, который придет от сервиса

        UserServiseImpl ggg = new UserServiseImpl();
        List<BagParam> ttt = ggg.getAll();

        request.setAttribute("fullList", ttt);
        request.setAttribute("jsp", "fullList.jsp");
    }
}
