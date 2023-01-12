package app.service;

import app.model.Bag;
import app.repository.BagParam;

import java.util.List;

public interface UserService {
    List<BagParam> getAll();
}
