package app.model.mapper;

import app.model.dto.BagCreateDto;
import app.model.dto.BagDto;
import app.model.dto.OrderDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Order;
import app.repository.UserRepository;
import app.repository.impl.UserRepositoryImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BagMapper {
    public BagDto bagToDto(Bag bag, List<BagPhoto> listBagPhoto) {

        BagDto bagDto = new BagDto();
        bagDto.setBagId(bag.getBagId());
        bagDto.setBagName(bag.getBagName());
        bagDto.setBagDescription(bag.getBagDescription());
        bagDto.setBagPrice(bag.getBagPrice());
        bagDto.setMainPhotoTitle(bag.getMainPhotoTitle());


        List<String> listPhoto = new ArrayList<>();

        for (BagPhoto s : listBagPhoto) {
            listPhoto.add(s.getPhotoTitle());
        }

        bagDto.setListPhoto(listPhoto);

        return bagDto;
    }


//Добавиить два метода конвектирования обьекта ДТО в баг (один для полей, второй для листа)


    public Bag bagCreateDtoToBag(BagCreateDto bagCreateDto) {
        Bag bag = new Bag();

        bag.setBagName(bagCreateDto.getBagName());
        bag.setBagCategory(bagCreateDto.getBagCategory());
        bag.setBagDescription(bagCreateDto.getBagDescription());
        bag.setBagDateAdded(bagCreateDto.getBagDateAdded());
        bag.setBagPrice(bagCreateDto.getBagPrice());
        bag.setMainPhotoTitle(bagCreateDto.getMainPhotoTitle());

        return bag;
    }

    public List<BagPhoto> bagCreateDtoToBagPhoto(BagCreateDto bagCreateDto, int bagId) {
        List<BagPhoto> listBagPhoto = new ArrayList<>();
        List<String> listPhoto = bagCreateDto.getListPhoto();

        for (String strList : listPhoto) {

            BagPhoto bagPhoto = new BagPhoto();

            bagPhoto.setBagId(bagId);
            bagPhoto.setPhotoTitle(strList);
            listBagPhoto.add(bagPhoto);
        }
        return listBagPhoto;
    }

    public List<OrderDto> listOrderForClientToDto(List<Order> listOrderForClient) {

        List<OrderDto> listOrderForClientDto = new ArrayList<>();

        UserRepository userRepository = new UserRepositoryImpl();

        for (Order order : listOrderForClient) {

            OrderDto orderDto = new OrderDto();
            orderDto.setBagId(order.getOrderBagId());
            orderDto.setOrderQuantity(order.getOrderQuantity());

            Bag bagById = userRepository.getBagById(order.getOrderBagId());
            orderDto.setBagName(bagById.getBagName());
            orderDto.setBagPrice(bagById.getBagPrice());
            orderDto.setMainPhotoTitle(bagById.getMainPhotoTitle());

            double total = bagById.getBagPrice()*order.getOrderQuantity();
            //double total = 25.36;
            orderDto.setTotal(total);

            listOrderForClientDto.add(orderDto);
        }


        return listOrderForClientDto;
    }

}
