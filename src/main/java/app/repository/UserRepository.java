package app.repository;

import app.model.BagParam;

import java.util.List;

public interface UserRepository {
    List<BagParam> getAll();

    List<BagParam> getListOfBagsByCategory(String category);

    //Перечислены все имеющиеся методы
}
