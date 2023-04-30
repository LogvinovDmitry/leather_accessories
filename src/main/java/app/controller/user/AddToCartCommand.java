package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddToCartCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));

        UserService userService = new UserServiceImpl();
        BagDto bagDto = userService.getBagById(bagId);

        List<BagDto> fullListOfProducts = userService.getAll();
        List<BagDto> listForYouInterested = new ArrayList<>();
        while (listForYouInterested.size() < 6 && listForYouInterested.size() < fullListOfProducts.size()) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForYouInterested.contains(fullListOfProducts.get(a))) {
                listForYouInterested.add(fullListOfProducts.get(a));
            }
        }

        request.setAttribute("listForYouInterested", listForYouInterested);

        request.setAttribute("bagDto", bagDto);

        Object oldItems = request.getSession().getAttribute("items");

        if (oldItems == null) {
            Map<Integer, Integer> items = new LinkedHashMap<>();
            items.put(bagId, 1);
            int size = items.size();
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);
        } else if (oldItems instanceof Map) {
            Map<Integer, Integer> items = (LinkedHashMap) oldItems;
            if (items.containsKey(bagId)) {

                request.setAttribute("jsp", "bagById.jsp");
            } else {
                items.put(bagId, 1);
                int size = items.size();
                request.getSession().setAttribute("items", items);
                request.getSession().setAttribute("size", size);
            }
        }

        request.setAttribute("jsp", "bagById.jsp");

    }
}
