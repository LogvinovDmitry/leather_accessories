package app.controller.user;

import app.controller.Command;
import app.model.BagParam;
import app.service.UserService;
import app.service.impl.UserServiсeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FullListOfProductsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


//Положить в атрибут полный список продукции, который придет от сервиса


        UserService userService = new UserServiсeImpl();
        List<BagParam> fullListOfProducts = userService.getAll();

        request.setAttribute("fullListOfProducts", fullListOfProducts);
        request.setAttribute("jsp", "fullListOfProducts.jsp");
    }
}
