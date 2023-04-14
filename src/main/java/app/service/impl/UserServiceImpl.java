package app.service.impl;


import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.Client;
import app.model.entity.BagPhoto;
import app.model.mapper.BagMapper;
import app.repository.UserRepository;
import app.repository.impl.UserRepositoryImpl;
import app.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    private BagMapper bagMapper = new BagMapper();
    // userRepository назначается через конструктор,
    // т.к. предполагается, что есть еще сеттер и второй конструктор, который принимает
    // параметром репозиторий. В данном случае это безсмысленно и можно было бы назначить
    // так: private UserRepository userRepository = new UserRepositoryImpl();

    public UserServiceImpl() {

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

        String description = bagDto.getBagDescription(); //из БД прилетает описание товара с {}, которые мы ниже заменим на <>
        String descrRep = description.replaceAll("\\{(/?)(li|ul|p)\\}", "<$1$2>");
        bagDto.setBagDescription(descrRep);

        return bagDto;
    }


    @Override
    public void createNewOrder(HttpServletRequest request) {


        Client client = new Client();

        client.setClientName(request.getParameter("name"));
        client.setClientPhone(request.getParameter("phone"));
        client.setClientNetwork(request.getParameter("network"));
        client.setClientAddress(request.getParameter("address"));
        client.setClientComment(request.getParameter("comment"));

        String orderNumber = (String) request.getSession().getAttribute("orderNumber");
        client.setClientNumber(orderNumber);

//Вариант №1
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, format);
        client.setClientDateAdded(dateTime);



//Вариант №2 - поробовать проконает в бд или нет.
//        LocalDateTime date = LocalDateTime.now();
//        client.setClientDateAdded(date);

        userRepository.createNewClient(client);



        Map<Integer, Integer> items = (LinkedHashMap<Integer, Integer>) request.getSession().getAttribute("items");

        userRepository.createNewOrder(items);



//
//        for (Integer item : items.keySet()) {
//            BagDto bagDto = userService.getBagById(item);
//            Integer quantity = items.get(item);
//
//            listBagDtoById.put(bagDto, quantity);
//        }

    }
}
