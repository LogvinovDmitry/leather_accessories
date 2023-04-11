package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketCommand implements Command {
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


        Map<BagDto, Integer> listBagDtoById = new HashMap<>();

        Object oldItems = request.getSession().getAttribute("items");
        if (oldItems == null) {
            request.setAttribute("jsp", "emptyBasket.jsp");
        } else {
            Map<Integer, Integer> items = (HashMap<Integer, Integer>) request.getSession().getAttribute("items");
            for (Integer item : items.keySet()) {
                BagDto bagDto = userService.getBagById(item);
                Integer quantity = items.get(item);

                listBagDtoById.put(bagDto, quantity);
            }

            double totalPrise = 0;
            for (BagDto bagDto : listBagDtoById.keySet()) {
                totalPrise = totalPrise + bagDto.getBagPrice();

            }
            request.getSession().setAttribute("totalPrise", totalPrise);

            request.getSession().setAttribute("listBagDtoById", listBagDtoById);
            request.setAttribute("jsp", "basket.jsp");
        }

    }
}
