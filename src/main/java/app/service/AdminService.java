package app.service;

import app.model.dto.OrderDto;
import app.model.entity.Client;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

public interface AdminService {
    void createBag(HttpServletRequest request);

    void removeBag(int bagId);

    Map<Client, ArrayList<OrderDto>> getAllOrderData();
}
