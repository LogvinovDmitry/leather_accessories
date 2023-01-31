package app.service.impl;


import app.model.BagParam;
import app.repository.UserRepository;
import app.repository.impl.UserRepositoryImpl;
import app.service.UserService;

import java.util.List;

public class UserServiсeImpl implements UserService {

    private UserRepository userRepository;


    // userRepository назначается через конструктор,
    // т.к. предполагается, что есть еще сеттер и второй конструктор, который принимает
    // параметром репозиторий. В данном случае это безсмысленно и можно было бы назначить
    // так: private UserRepository userRepository = new UserRepositoryImpl();

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
