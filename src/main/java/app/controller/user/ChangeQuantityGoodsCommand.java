package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class ChangeQuantityGoodsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();
        List<BagDto> listForYouInterested = new ArrayList<>();
        while (listForYouInterested.size() < 6 && listForYouInterested.size() < fullListOfProducts.size()) {

            int a = (int) (Math.random() * fullListOfProducts.size());

            if (!listForYouInterested.contains(fullListOfProducts.get(a))) {
                listForYouInterested.add(fullListOfProducts.get(a));
            }
        }
        request.setAttribute("listForYouInterested", listForYouInterested);



        int bagId = Integer.parseInt(request.getParameter("bagId"));

        Map<BagDto, Integer> listBagDtoById = new LinkedHashMap<>();

        Map<Integer, Integer> items = (LinkedHashMap<Integer, Integer>) request.getSession().getAttribute("items");



        if (request.getParameter("quantity").equals("add")) {
            Integer quantity = items.get(bagId) + 1;
            items.put(bagId, quantity);
            request.getSession().setAttribute("items", items);
        } else if (request.getParameter("quantity").equals("remove")) {

            Integer quantity = items.get(bagId) - 1;
            if (quantity == 0) {
                quantity = quantity + 1;
            }

            items.put(bagId, quantity);
            request.getSession().setAttribute("items", items);
        }


        for (Integer item : items.keySet()) {
            BagDto bagDto = userService.getBagById(item);
            Integer quantityNew = items.get(item);

            listBagDtoById.put(bagDto, quantityNew);
        }

        double totalPrise = 0;
        for (BagDto bagDto : listBagDtoById.keySet()) {
            totalPrise = totalPrise + (bagDto.getBagPrice())*listBagDtoById.get(bagDto);

        }
        request.setAttribute("totalPrise", totalPrise);


        request.setAttribute("listBagDtoById", listBagDtoById);

        request.setAttribute("jsp", "basket.jsp");

    }
}
