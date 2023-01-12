package app.repository.database;

import app.model.Bag;
import app.repository.BagParam;

import java.util.List;

public interface UserRepository {
    List<BagParam> getAll();

    //Перечислены все имеющиеся методы
}
