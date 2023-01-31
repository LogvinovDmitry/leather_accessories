package app.controller.user;

import app.controller.Command;
import app.model.BagParam;
import app.service.UserService;
import app.service.impl.UserServiсeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOfBagsByCategoryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String category = request.getParameter("category");  //Accessories, Lady's bag, Men's bag

        UserService userService = new UserServiсeImpl();
        List<BagParam> listOfBagsByCategory = userService.getListOfBagsByCategory(category);

        request.setAttribute("listOfBagsByCategory", listOfBagsByCategory);
        request.setAttribute("jsp", "listOfBagsByCategory.jsp");
    }
}
