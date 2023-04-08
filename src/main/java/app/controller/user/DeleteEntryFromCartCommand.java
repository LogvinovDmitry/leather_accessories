package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteEntryFromCartCommand implements Command {
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


        ArrayList<BagDto> listBagDtoById = new ArrayList<>();

        int bagId = Integer.parseInt(request.getParameter("bagId"));


        Object oldItems = request.getSession().getAttribute("items");

        ArrayList<Integer> items = (ArrayList<Integer>) oldItems;
        //items.remove(bagId);

        Iterator<Integer> itemsIterator = items.iterator();//создаем итератор
        while (itemsIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            int nextItems = itemsIterator.next();//получаем следующий элемент
            if (nextItems == bagId) {
                itemsIterator.remove();//удаляем кота с нужным именем
            }
        }

        int size = items.size();
        if (size == 0) {
            items = null;
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);
            request.setAttribute("jsp", "emptyBasket.jsp");

        } else {

            for (Integer item : items) {
                BagDto bagDto = userService.getBagById(item);
                listBagDtoById.add(bagDto);
            }

            double totalPrise = 0;
            for (BagDto bagDto : listBagDtoById) {
                totalPrise = totalPrise + bagDto.getBagPrice();

            }
            request.getSession().setAttribute("totalPrise", totalPrise);
            request.getSession().setAttribute("listBagDtoById", listBagDtoById);
            request.getSession().setAttribute("items", items);
            request.getSession().setAttribute("size", size);


        //BagDto bagDto = userService.getBagById(bagId);


        //request.setAttribute("bagDto", bagDto);
        request.setAttribute("jsp", "basket.jsp");
        }
    }
}
