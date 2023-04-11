package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.AdminService;
import app.service.UserService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.UserServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@MultipartConfig()
public class CreateNewOrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();
        List<BagDto> listForYouInterested = new ArrayList<>();
        while (listForYouInterested.size() < 6) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForYouInterested.contains(fullListOfProducts.get(a))) {
                listForYouInterested.add(fullListOfProducts.get(a));
            }
        }
        request.setAttribute("listForYouInterested", listForYouInterested);

        int size = 0;
        request.getSession().setAttribute("items", null);
        request.getSession().setAttribute("size", size);

        String orderNumberOld = (String) request.getSession().getAttribute("orderNumber");
        request.getSession().setAttribute("orderNumberOld", orderNumberOld);

        request.getSession().setAttribute("orderNumber", null);


        //userService.createNewOrder(request);

        request.setAttribute("jsp", "afterOrderPage.jsp");
    }
}