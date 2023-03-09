package app.service.impl;


import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.mapper.BagMapper;
import app.repository.UserRepository;
import app.repository.impl.UserRepositoryImpl;
import app.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiсeImpl implements UserService {

    private UserRepository userRepository;


    private BagMapper bagMapper = new BagMapper();
    // userRepository назначается через конструктор,
    // т.к. предполагается, что есть еще сеттер и второй конструктор, который принимает
    // параметром репозиторий. В данном случае это безсмысленно и можно было бы назначить
    // так: private UserRepository userRepository = new UserRepositoryImpl();

    public UserServiсeImpl() {

        userRepository = new UserRepositoryImpl();
    }


    @Override
    public List<BagDto> getAll() {

        List<Bag> fullListOfProducts = userRepository.getAll();

        List<BagDto> fullListOfProductsDto = new ArrayList<>();


        for (Bag bag : fullListOfProducts) {
            List<BagPhoto> listBagPhoto = userRepository.getListBagPhoto(bag.getBagId());
            BagDto bagDto = bagMapper.bagToDto(bag, listBagPhoto);
            fullListOfProductsDto.add(bagDto);
        }
        return fullListOfProductsDto;
    }

//    @Override
//    public List<Bag> getListOfBagsByCategory(String category) {
//
//        return userRepository.getListOfBagsByCategory(category);
//    }

    @Override
    public List<BagDto> getListOfBagsByCategory(String category) {

        List<Bag> listOfBagsByCategory = userRepository.getListOfBagsByCategory(category);


        List<BagDto> listOfBagsByCategoryDto = new ArrayList<>();


        for (Bag bag : listOfBagsByCategory) {
            List<BagPhoto> listBagPhoto = userRepository.getListBagPhoto(bag.getBagId());

            BagDto bagDto = bagMapper.bagToDto(bag, listBagPhoto);
            listOfBagsByCategoryDto.add(bagDto);
        }
        return listOfBagsByCategoryDto;
    }

    @Override
    public BagDto getBagById(int bagId) {

        Bag bag = userRepository.getBagById(bagId);

        List<BagPhoto> listBagPhoto = userRepository.getListBagPhoto(bagId);

        BagDto bagDto = bagMapper.bagToDto(bag, listBagPhoto);


        return bagDto;
    }
}
