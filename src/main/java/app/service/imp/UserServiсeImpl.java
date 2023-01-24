package app.service.imp;


import app.model.BagParam;
import app.repository.database.UserRepository;
import app.repository.database.impl.UserRepositoryImpl;
import app.service.UserService;

import java.util.List;

public class UserServiсeImpl implements UserService {

    private UserRepository userRepository;

    public UserServiсeImpl() {

        userRepository = new UserRepositoryImpl();
    }


    @Override
    public List<BagParam> getAll() {

        return userRepository.getAll();
    }

    @Override
    public List<BagParam> getListOfBagsByCategory(String category) {


        return userRepository.getListOfBagsByCategory(category);
    }
}
