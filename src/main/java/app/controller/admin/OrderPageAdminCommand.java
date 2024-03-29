package app.controller.admin;

import app.controller.Command;
import app.model.dto.BagDto;
import app.model.dto.OrderDto;
import app.model.entity.Client;
import app.service.AdminService;
import app.service.UserService;
import app.service.impl.AdminServiceImpl;
import app.service.impl.UserServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig()
public class OrderPageAdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        AdminService adminService = new AdminServiceImpl();
        Map<Client, List<OrderDto>> allOrderData = adminService.getAllOrderData();

        request.setAttribute("allOrderData", allOrderData);
        request.setAttribute("jsp", "orderPageAdmin.jsp");
    }
}