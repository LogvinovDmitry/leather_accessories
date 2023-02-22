package app.repository;

import app.model.entity.Bag;
import app.model.entity.BagPhoto;

import java.util.List;

public interface AdminRepository {
    void createBag(Bag bag);
    void createBagPhoto(BagPhoto bagPhoto);
}
