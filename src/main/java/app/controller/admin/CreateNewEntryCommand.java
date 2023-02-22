package app.controller.admin;

import app.controller.Command;
import app.service.AdminService;
import app.service.impl.AdminServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig()
public class CreateNewEntryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        AdminService adminService = new AdminServiceImpl();
        adminService.createBag(request);



        request.setAttribute("jsp", "fullListOfProducts.jsp");
    }
}