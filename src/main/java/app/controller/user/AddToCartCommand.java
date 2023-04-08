package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddToCartCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));

        Object oldItems = request.getSession().getAttribute("items");
        if (oldItems == null) {
            ArrayList<Integer> items = new ArrayList<>();
            items.add(bagId);
            int size = items.size();
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);
        } else if (oldItems instanceof List) {
            ArrayList<Integer> items = (ArrayList<Integer>) oldItems;
            items.add(bagId);
            int size = items.size();
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);
        }



        UserService userService = new UserServiceImpl();
        BagDto bagDto = userService.getBagById(bagId);

        List<BagDto> fullListOfProducts = userService.getAll();
        List<BagDto> listForYouInterested = new ArrayList<>();
        while (listForYouInterested.size() < 6) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForYouInterested.contains(fullListOfProducts.get(a))) {
                listForYouInterested.add(fullListOfProducts.get(a));
            }
        }

        request.setAttribute("listForYouInterested", listForYouInterested);

        request.setAttribute("bagDto", bagDto);
        request.setAttribute("jsp", "bagById.jsp");

    }
}
