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
import java.util.List;

@MultipartConfig()
public class CreateNewEntryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        AdminService adminService = new AdminServiceImpl();
        adminService.createBag(request);

        UserService userService = new UserServiceImpl();
        List<BagDto> fullListOfProducts = userService.getAll();


        request.setAttribute("fullListOfProducts", fullListOfProducts);

        request.setAttribute("jsp", "createNewEntryAdmin.jsp");
    }
}