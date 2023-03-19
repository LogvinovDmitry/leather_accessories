package app.service.impl;

import app.model.dto.BagCreateDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
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
import java.util.Date;
import java.util.List;

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

        String partOfImageSize = obrezatLishniujuChastPutiKartinki(request, imageFullPath);

        bagCreateDto.setMainPhotoTitle(partOfImageSize);

        Bag bag = bagMapper.bagCreateDtoToBag(bagCreateDto);

        adminRepository.createBag(bag);


        List<String> listPhoto = serverRepository.uploadFiles(request);
        // TODO: Нужно лбрезать лишнюю часть пути У КАЖДОЙ картинки в списке, и в setListPhoto передавать уже правильные пути
        // Можно использовать метод obrezatLishniujuChastPutiKartinki
        bagCreateDto.setListPhoto(listPhoto);

        int bagId = bag.getBagId();
        List<BagPhoto> listBagPhoto = bagMapper.bagCreateDtoToBagPhoto(bagCreateDto, bagId);

        for (BagPhoto bagPhoto : listBagPhoto) {
            adminRepository.createBagPhoto(bagPhoto);
        }


//        BagDto bagDto = new BagDto();
//
//        List<String> listPhoto = new ArrayList<>();
//        listPhoto.add(request.getParameter("file_names"));
//
//        bagDto.setListPhoto(listPhoto);

//        adminRepository.create(Bag b);
//
//        for () {
//        adminRepository.create(BagPhoto bf);
//    }
    }

    private static String obrezatLishniujuChastPutiKartinki(HttpServletRequest request, String imageFullPath) {
        //  в переменной imageFullPath ==
        // D:\java\leather_accessories_dima\file\shopping_icon\some-icon.png
        // сохранять надо только эту часть - file\shopping_icon\some-icon.png

        // baseDirectoryPath == D:\java\leather_accessories_dima\
        final String baseDirectoryPath = Utils.getBasePath(request);

        final Path basePath = Paths.get(baseDirectoryPath).normalize();

        final Path imagePath = Paths.get(imageFullPath).normalize();

        // от одного пути отрезается другой
        // "D:\java\leather_accessories_dima\file\shopping_icon\some-icon.png"    ->    "file\shopping_icon\some-icon.png"
        String partOfImageSize = basePath.relativize(imagePath).toString();
        return partOfImageSize.replace('\\', '/');
    }
}

