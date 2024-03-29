package app.controller.admin;

import app.controller.Command;
import app.model.dto.BagDto;
import app.repository.Server.ServerRepository;
import app.service.AdminService;
import app.service.UserService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.UserServiceImpl;
import app.util.Utils;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@MultipartConfig()
public class RemoveEntryCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        AdminService adminService = new AdminServiceImpl();


        int bagId = Integer.parseInt(request.getParameter("bagId"));

        List<Integer> listOrderBagId = adminService.getListOrderBagId();
        if (listOrderBagId.contains(bagId)) {
            request.setAttribute("jsp", "errorPageTest.jsp");
        } else {


            UserService userService = new UserServiceImpl();
            BagDto bagDto = userService.getBagById(bagId);


            //AdminService adminService = new AdminServiceImpl();
            adminService.removeBag(bagId);


            ServerRepository serverRepository = new ServerRepository();
            String baseFilePath = Utils.getBasePath(request);
            serverRepository.removeFile(bagDto, baseFilePath);

            List<BagDto> fullListOfProducts = userService.getAll();


            request.setAttribute("fullListOfProducts", fullListOfProducts);

            request.setAttribute("jsp", "fullListOfProducts.jsp");
        }
    }
}