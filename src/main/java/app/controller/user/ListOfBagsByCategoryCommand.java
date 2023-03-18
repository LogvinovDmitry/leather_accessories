package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListOfBagsByCategoryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String category = request.getParameter("category");  //Accessories, Lady's bag, Men's bag

        UserService userService = new UserServiceImpl();
        List<BagDto> listOfBagsByCategory = userService.getListOfBagsByCategory(category);

        request.setAttribute("listOfBagsByCategory", listOfBagsByCategory);
        request.setAttribute("jsp", "listOfBagsByCategory.jsp");
    }
}
