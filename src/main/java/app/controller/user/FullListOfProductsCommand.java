package app.controller.user;

import app.controller.Command;
import app.model.BagParam;
import app.service.imp.UserServiсeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FullListOfProductsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


//Положить в атрибут полный список продукции, который придет от сервиса

        UserServiсeImpl userServiсeImpl = new UserServiсeImpl();
        List<BagParam> fullList = userServiсeImpl.getAll();

        request.setAttribute("fullList", fullList);
        request.setAttribute("jsp", "fullList.jsp");
    }
}
