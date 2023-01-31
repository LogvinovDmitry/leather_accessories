package app.service;

import app.model.BagParam;

import java.util.List;

public interface UserService {


    List<BagParam> getAll();

    List<BagParam> getListOfBagsByCategory(String category);
}
