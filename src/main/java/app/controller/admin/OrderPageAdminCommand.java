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



//        Client client_1 = new Client();
//        LocalDateTime date = LocalDateTime.now();
//        client_1.setClientDateAdded(date);
//        client_1.setClientNumber("rtrt54");
//        client_1.setClientName("Shnj Sdgbthbrt");
//
//
//
//        Client client_2 = new Client();
//        LocalDateTime date1 = LocalDateTime.now();
//        client_2.setClientDateAdded(date1);
//        client_2.setClientNumber("trtrtr99");
//        client_2.setClientName("Wwwww Eeeee");
//
//
//        ArrayList<OrderDto> arrayList_1 = new ArrayList<>();
//
//
//        OrderDto orderDto_1 = new OrderDto();
//        orderDto_1.setBagId(344);
//        orderDto_1.setBagName("fgfffg");
//        orderDto_1.setBagPrice(25.36);
//        orderDto_1.setOrderQuantity(2);
//
//        OrderDto orderDto_2 = new OrderDto();
//        orderDto_2.setBagId(456);
//        orderDto_2.setBagName("thgfd");
//        orderDto_2.setBagPrice(25.36);
//        orderDto_2.setOrderQuantity(4);
//
//        arrayList_1.add(orderDto_1);
//        arrayList_1.add(orderDto_2);
//
//
//
//        ArrayList<OrderDto> arrayList_2 = new ArrayList<>();
//
//
//        OrderDto orderDto_3 = new OrderDto();
//        orderDto_1.setBagId(344);
//        orderDto_1.setBagName("fgfffg");
//        orderDto_1.setBagPrice(25.36);
//        orderDto_1.setOrderQuantity(2);
//
//        OrderDto orderDto_4 = new OrderDto();
//        orderDto_2.setBagId(456);
//        orderDto_2.setBagName("thgfd");
//        orderDto_2.setBagPrice(25.36);
//        orderDto_2.setOrderQuantity(4);
//
//        arrayList_2.add(orderDto_3);
//        arrayList_2.add(orderDto_4);
//
//
//        Map<Client, ArrayList<OrderDto>> allOrderData = new LinkedHashMap<>();
//        allOrderData.put(client_1, arrayList_1);
//        allOrderData.put(client_2, arrayList_2);
//

        AdminService adminService = new AdminServiceImpl();
        Map<Client, ArrayList<OrderDto>> allOrderData = adminService.getAllOrderData();

        request.setAttribute("allOrderData", allOrderData);
        request.setAttribute("jsp", "orderPageAdmin.jsp");
    }
}