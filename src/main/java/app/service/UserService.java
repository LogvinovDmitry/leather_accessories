package app.service;

import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;

import java.util.List;

public interface UserService {


    List<BagDto> getAll();

    List<BagDto> getListOfBagsByCategory(String category);

    BagDto getBagById(int bagId);


}
