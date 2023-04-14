package app.repository;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    List<Bag> getAll();

    List<Bag> getListOfBagsByCategory(String category);

    List<BagPhoto> getListBagPhoto(int bagId);

    Bag getBagById(int bagId);


    void createNewClient(Client client);

    void createNewOrder(Map<Integer, Integer> items);
    //Перечислены все имеющиеся методы
}
