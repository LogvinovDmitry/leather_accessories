package app.service;

import app.model.dto.OrderDto;
import app.model.entity.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AdminService {
    void createBag(HttpServletRequest request);

    void removeBag(int bagId);

    Map<Client, List<OrderDto>> getAllOrderData();
    void removeOrder(int clientId);

    List<Integer> getListOrderBagId();

}
