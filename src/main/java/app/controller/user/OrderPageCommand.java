package app.controller.user;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.AdminService;
import app.service.UserService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.UserServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.List;

//@WebServlet(urlPatterns = {"/order-page"})
@MultipartConfig
public class OrderPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


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