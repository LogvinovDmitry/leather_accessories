package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class DeleteEntryFromCartCommand implements Command {
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


        Map<BagDto, Integer> listBagDtoById = new LinkedHashMap<>();

        int bagId = Integer.parseInt(request.getParameter("bagId"));


        Object oldItems = request.getSession().getAttribute("items");

        Map<Integer, Integer> items = (Map) oldItems;
        //items.remove(bagId);

        Iterator<Integer> itemsIterator = items.keySet().iterator();//создаем итератор
        while (itemsIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            int nextItems = itemsIterator.next();//получаем следующий элемент
            if (nextItems == bagId) {
                itemsIterator.remove();//удаляем кота с нужным именем
            }
        }

        int size = items.size();
        if (size == 0) {
            request.getSession().setAttribute("items", null);
            request.getSession().setAttribute("size", size);
            request.setAttribute("jsp", "emptyBasket.jsp");

        } else {

            for (Integer item : items.keySet()) {
                BagDto bagDto = userService.getBagById(item);
                Integer quantity = items.get(item);
                listBagDtoById.put(bagDto, quantity);
            }

            double totalPrise = 0;
            for (BagDto bagDto : listBagDtoById.keySet()) {
                totalPrise = totalPrise + (bagDto.getBagPrice())*listBagDtoById.get(bagDto);

            }
            request.getSession().setAttribute("totalPrise", totalPrise);
            request.setAttribute("listBagDtoById", listBagDtoById);
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);


        //BagDto bagDto = userService.getBagById(bagId);


        //request.setAttribute("bagDto", bagDto);
        request.setAttribute("jsp", "basket.jsp");
        }
    }
}
