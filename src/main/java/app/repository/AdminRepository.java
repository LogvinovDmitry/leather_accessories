package app.repository;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;
import app.model.entity.Order;

import java.util.List;

public interface AdminRepository {
    void createBag(Bag bag);
    void createBagPhoto(BagPhoto bagPhoto);

    void removeBag(int bagId);


   List<Client> getListAllClients();
   List<Order> getListOrderForClient(int clientId);
   void removeOrder(int clientId);
}
