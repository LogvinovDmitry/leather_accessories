package app.service.impl;

import app.model.dto.BagCreateDto;
import app.model.dto.OrderDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;
import app.model.entity.Order;
import app.model.mapper.BagMapper;
import app.repository.AdminRepository;
import app.repository.Server.ServerRepository;
import app.repository.impl.AdminRepositoryImpl;
import app.service.AdminService;
import app.util.Utils;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private BagMapper bagMapper = new BagMapper();
    private ServerRepository serverRepository = new ServerRepository();

    public AdminServiceImpl() {
        adminRepository = new AdminRepositoryImpl();
    }

    @Override
    public void createBag(HttpServletRequest request) {

        //String imageFullPath = "file/619484b4-b89b-4094-ba8b-e1da87f39862photo_2022-12-05_11-38-23.jpg";

        BagCreateDto bagCreateDto = new BagCreateDto();

        bagCreateDto.setBagName(request.getParameter("bag_name"));
        final String bagCategory = request.getParameter("bag_category");
        if (bagCategory == null) {
            throw new RuntimeException("Category not selected: Категория не выбрана!");
        }
        bagCreateDto.setBagCategory(Integer.parseInt(bagCategory)); //1 или 2 или 3


        bagCreateDto.setBagDescription(request.getParameter("bag_description"));


        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        bagCreateDto.setBagDateAdded(LocalDate.parse(date));

        bagCreateDto.setBagPrice(Double.parseDouble(request.getParameter("bag_price")));

        String imageFullPath = serverRepository.uploadFile(request);

        //Используем метод obrezatLishniujuChastPutiKartinki для того, что бы наши пути к файлам
        //стали универсальными и работали на любом устройстве, включая внешний сервер. (первая часть пути,
        //разная для каждого устройства, будет отсекаться, а вторая одинаковая - сохраняться)
        String partOfImageSize = obrezatLishniujuChastPutiKartinki(request, imageFullPath);

        bagCreateDto.setMainPhotoTitle(partOfImageSize);

        Bag bag = bagMapper.bagCreateDtoToBag(bagCreateDto);

        adminRepository.createBag(bag);


        List<String> listPhotoFullPath = serverRepository.uploadFiles(request);
        List<String> listPhoto = new ArrayList<>();
        for (String imageFullPathToList : listPhotoFullPath) {
            String partOfImageSizeToList = obrezatLishniujuChastPutiKartinki(request, imageFullPathToList);
            listPhoto.add(partOfImageSizeToList);
        }

        bagCreateDto.setListPhoto(listPhoto);

        int bagId = bag.getBagId();
        List<BagPhoto> listBagPhoto = bagMapper.bagCreateDtoToBagPhoto(bagCreateDto, bagId);

        for (BagPhoto bagPhoto : listBagPhoto) {
            adminRepository.createBagPhoto(bagPhoto);
        }
    }

    private static String obrezatLishniujuChastPutiKartinki(HttpServletRequest request, String imageFullPath) {
        //  в переменной imageFullPath ==
        // D:\java\leather_accessories_dima\file\shopping_icon\some-icon.png
        // сохранять надо только эту часть - file\shopping_icon\some-icon.png

        // baseDirectoryPath == D:\java\leather_accessories_dima\
        final String baseDirectoryPath = Utils.getBasePath(request); //Путь к папке, где должны быть файлы

        final Path basePath = Paths.get(baseDirectoryPath).normalize();

        final Path imagePath = Paths.get(imageFullPath).normalize();

        // от одного пути отрезается другой
        // "D:\java\leather_accessories_dima\file\shopping_icon\some-icon.png"    ->    "file\shopping_icon\some-icon.png"
        String partOfImageSize = basePath.relativize(imagePath).toString();
        return partOfImageSize.replace('\\', '/');
    }

    @Override
    public void removeBag(int bagId) {
        adminRepository.removeBag(bagId);
    }


    @Override
    public Map<Client, List<OrderDto>> getAllOrderData() {

        Map<Client, List<OrderDto>> allOrderData = new LinkedHashMap<>();

        List<Client> listAllClients = adminRepository.getListAllClients();

        for (Client client : listAllClients) {

            List<Order> listOrderForClient = adminRepository.getListOrderForClient(client.getClientId());

            List<OrderDto> listOrderForClientToDto = bagMapper.listOrderForClientToDto(listOrderForClient);

            double totalPrise = 0;
            for (OrderDto orderDto : listOrderForClientToDto) {
                totalPrise = totalPrise + orderDto.getTotal();

            }
            client.setTotalPrise(totalPrise);

            allOrderData.put(client, listOrderForClientToDto);
        }

        return allOrderData;
    }

    @Override
    public void removeOrder(int clientId) {
        adminRepository.removeOrder(clientId);
    }
}

