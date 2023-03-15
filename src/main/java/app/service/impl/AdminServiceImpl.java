package app.service.impl;

import app.model.dto.BagCreateDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.mapper.BagMapper;
import app.repository.AdminRepository;
import app.repository.Server.ServerRepository;
import app.repository.impl.AdminRepositoryImpl;
import app.service.AdminService;


import javax.servlet.http.HttpServletRequest;
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

        //String imagePath = "file/619484b4-b89b-4094-ba8b-e1da87f39862photo_2022-12-05_11-38-23.jpg";

        BagCreateDto bagCreateDto = new BagCreateDto();

        bagCreateDto.setBagName(request.getParameter("bag_name"));
        bagCreateDto.setBagCategory(Integer.parseInt(request.getParameter("bag_category"))); //1 или 2 или 3


        bagCreateDto.setBagDescription(request.getParameter("bag_description"));


        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        bagCreateDto.setBagDateAdded(LocalDate.parse(date));

        bagCreateDto.setBagPrice(Double.parseDouble(request.getParameter("bag_price")));

        String imagePath = serverRepository.uploadFile(request);
        bagCreateDto.setMainPhotoTitle(imagePath);

        Bag bag = bagMapper.bagCreateDtoToBag(bagCreateDto);

        adminRepository.createBag(bag);


        List<String> listPhoto = serverRepository.uploadFiles(request);
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
}

