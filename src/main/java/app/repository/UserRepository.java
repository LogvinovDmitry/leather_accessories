package app.repository;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;

import java.util.List;

public interface UserRepository {
    List<Bag> getAll();

    List<Bag> getListOfBagsByCategory(String category);

    List<BagPhoto> getListBagPhoto(int bagId);
    //Перечислены все имеющиеся методы
}
