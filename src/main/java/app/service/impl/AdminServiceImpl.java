package app.service.impl;

import app.model.dto.BagCreateDto;
import app.model.dto.OrderDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.entity.Client;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Map<Client, ArrayList<OrderDto>> getAllOrderData() {

        List<Client> listAllClients = adminRepository.getListAllClients();
     



//        Client client_1 = new Client();
//        LocalDateTime date = LocalDateTime.now();
//        client_1.setClientDateAdded(date);
//        client_1.setClientNumber("rtrt54");
//        client_1.setClientName("Shnj Sdgbthbrt");
//
//
//
//        Client client_2 = new Client();
//        LocalDateTime date1 = LocalDateTime.now();
//        client_2.setClientDateAdded(date1);
//        client_2.setClientNumber("trtrtr99");
//        client_2.setClientName("Wwwww Eeeee");
//
//
//        ArrayList<OrderDto> arrayList_1 = new ArrayList<>();
//
//
//        OrderDto orderDto_1 = new OrderDto();
//        orderDto_1.setBagId(344);
//        orderDto_1.setBagName("fgfffg");
//        orderDto_1.setBagPrice(25.36);
//        orderDto_1.setOrderQuantity(2);
//
//        OrderDto orderDto_2 = new OrderDto();
//        orderDto_2.setBagId(456);
//        orderDto_2.setBagName("thgfd");
//        orderDto_2.setBagPrice(25.36);
//        orderDto_2.setOrderQuantity(4);
//
//        arrayList_1.add(orderDto_1);
//        arrayList_1.add(orderDto_2);
//
//
//
//        ArrayList<OrderDto> arrayList_2 = new ArrayList<>();
//
//
//        OrderDto orderDto_3 = new OrderDto();
//        orderDto_1.setBagId(344);
//        orderDto_1.setBagName("fgfffg");
//        orderDto_1.setBagPrice(25.36);
//        orderDto_1.setOrderQuantity(2);
//
//        OrderDto orderDto_4 = new OrderDto();
//        orderDto_2.setBagId(456);
//        orderDto_2.setBagName("thgfd");
//        orderDto_2.setBagPrice(25.36);
//        orderDto_2.setOrderQuantity(4);
//
//        arrayList_2.add(orderDto_3);
//        arrayList_2.add(orderDto_4);
//
//
//        Map<Client, ArrayList<OrderDto>> allOrderData = new LinkedHashMap<>();
//        allOrderData.put(client_1, arrayList_1);
//        allOrderData.put(client_2, arrayList_2);

        //return allOrderData;
        return null;

    }
}

