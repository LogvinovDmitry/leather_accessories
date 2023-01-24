package app.controller.user;

import app.controller.Command;
import app.model.BagParam;
import app.service.UserService;
import app.service.imp.UserServiсeImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOfBagsByCategoryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String command = request.getParameter("inputName");  //List of accessories List of lady's bag bags

        UserService userService = new UserServiсeImpl();
        List<BagParam> ListOfBagsByCategory = userService.getListOfBagsByCategory(command);

        request.setAttribute("listOfBagsByCategory", ListOfBagsByCategory);
        request.setAttribute("jsp", "listOfBagsByCategory.jsp");
    }
}
