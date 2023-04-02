package app.controller.admin;

import app.controller.Command;
import app.model.dto.BagDto;
import app.service.AdminService;
import app.service.UserService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.UserServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@MultipartConfig()
public class ExitAdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {


//        boolean isAdmin = false;
//        isAdmin = (boolean) session.getAttribute("isAdmin");
        boolean isAdmin = false;
        HttpSession session = request.getSession();
        session.setAttribute("isAdmin", isAdmin);

        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();


        request.setAttribute("fullListOfProducts", fullListOfProducts);

        request.setAttribute("jsp", "fullListOfProducts.jsp");
    }
}