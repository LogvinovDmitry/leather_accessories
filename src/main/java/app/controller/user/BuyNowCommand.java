package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BuyNowCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int bagId = Integer.parseInt(request.getParameter("bagId"));

        UserService userService = new UserServiceImpl();
        //ArrayList<BagDto> listBagDtoById = new ArrayList<>();
        Map<BagDto, Integer> listBagDtoById = new LinkedHashMap<>();

        Map<Integer, Integer> items = new LinkedHashMap<>();
        items.put(bagId, 1);
        int size = items.size();
        request.getSession().setAttribute("items", items);
        request.getSession().setAttribute("size", size);


        for (Integer item : items.keySet()) {
            BagDto bagDto = userService.getBagById(item);
            listBagDtoById.put(bagDto, 1);
        }
        request.setAttribute("listBagDtoById", listBagDtoById);


        if (request.getSession().getAttribute("orderNumber") == null) {
            int len = 5;
            // Диапазон ASCII – буквенно-цифровой (0-9, a-z, A-Z)
            final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();

            // каждая итерация цикла случайным образом выбирает символ из заданного
            // диапазон ASCII и добавляет его к экземпляру `StringBuilder`

            for (int i = 0; i < len; i++) {
                int randomIndex = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIndex));
            }
            String orderNumber = sb.toString();

            request.getSession().setAttribute("orderNumber", orderNumber);


            request.setAttribute("jsp", "orderPage.jsp");
        }
        else {
            request.setAttribute("jsp", "orderPage.jsp");
        }

    }
}
