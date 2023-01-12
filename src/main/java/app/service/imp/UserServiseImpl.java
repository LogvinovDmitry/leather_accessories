package app.service.imp;


import app.model.Bag;
import app.repository.BagParam;
import app.repository.database.UserRepository;
import app.repository.database.impl.UserRepositoryImpl;
import app.service.UserService;

import java.util.List;

public class UserServiseImpl implements UserService {

    private UserRepository userRepository;

    public UserServiseImpl() {

        userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<BagParam> getAll() {

        return userRepository.getAll();
    }
}
