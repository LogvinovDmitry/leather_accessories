package app.controller.admin;

import app.controller.Command;
import app.model.dto.OrderDto;
import app.model.entity.Client;
import app.service.AdminService;
import app.service.impl.AdminServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@MultipartConfig()
public class RemoveOrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        int clientId = Integer.parseInt(request.getParameter("clientId"));

        AdminService adminService = new AdminServiceImpl();
        adminService.removeOrder(clientId);

        Map<Client, List<OrderDto>> allOrderData = adminService.getAllOrderData();


        request.setAttribute("allOrderData", allOrderData);
        request.setAttribute("jsp", "orderPageAdmin.jsp");
    }
}