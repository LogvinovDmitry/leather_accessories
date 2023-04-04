package app.controller;

import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SaveBagForBasket implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));
        UserService userService = new UserServiceImpl();
        BagDto bagDto = userService.getBagById(bagId);


        request.setAttribute("bagDto", bagDto);
        request.setAttribute("jsp", "basket.jsp");
    }
}
