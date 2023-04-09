package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class BuyNowCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));

        UserService userService = new UserServiceImpl();
        ArrayList<BagDto> listBagDtoById = new ArrayList<>();
//
//
//        Object oldItems = request.getSession().getAttribute("items");
//        if (oldItems == null) {
//            ArrayList<Integer> items = new ArrayList<>();
//            items.add(bagId);
//            int size = items.size();
//            request.getSession().setAttribute("items", items);
//            request.getSession().setAttribute("size", size);
//
//
//            for (Integer item : items) {
//                BagDto bagDto = userService.getBagById(item);
//                listBagDtoById.add(bagDto);
//            }
//            request.getSession().setAttribute("listBagDtoById", listBagDtoById);
//            request.setAttribute("jsp", "orderPage.jsp");
//
//        } else {
//            ArrayList<Integer> items = (ArrayList<Integer>) request.getSession().getAttribute("items");
//            items.clear();
//            items.add(bagId);
//            int size = items.size();
//            request.getSession().setAttribute("items", items);
//            request.getSession().setAttribute("size", size);
//
//
//            for (Integer item : items) {
//                BagDto bagDto = userService.getBagById(item);
//                listBagDtoById.add(bagDto);
//            }
//            request.getSession().setAttribute("listBagDtoById", listBagDtoById);
//            request.setAttribute("jsp", "orderPage.jsp");
//        }

        ArrayList<Integer> items = new ArrayList<>();
        items.add(bagId);
        int size = items.size();
        request.getSession().setAttribute("items", items);
        request.getSession().setAttribute("size", size);


        for (Integer item : items) {
            BagDto bagDto = userService.getBagById(item);
            listBagDtoById.add(bagDto);
        }
        request.getSession().setAttribute("listBagDtoById", listBagDtoById);
        request.setAttribute("jsp", "orderPage.jsp");


    }
}
