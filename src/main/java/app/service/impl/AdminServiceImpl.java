package app.service.impl;

import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.model.mapper.BagMapper;
import app.repository.AdminRepository;
import app.repository.impl.AdminRepositoryImpl;
import app.service.AdminService;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    public BagMapper bagMapper;

    public AdminServiceImpl() {
        adminRepository = new AdminRepositoryImpl();
    }

    @Override
    public void createBag(HttpServletRequest request) {

        String imagePath = "dddd";

        Bag bag = new Bag();
        bag.setBagName(request.getParameter("bag_name"));
        bag.setBagCategory(Integer.parseInt(request.getParameter("bag_category")));
        bag.setBagDescription(request.getParameter("bag_description"));
        bag.setBagDateAdded(LocalDate.parse(request.getParameter("bag_date_added")));
        bag.setBagPrice(Double.parseDouble(request.getParameter("bag_price")));


        BagDto bagDto = new BagDto();

        List<String> listPhoto = new ArrayList<>();
        listPhoto.add(request.getParameter("file-name"));
        listPhoto.add(request.getParameter("file-name1"));

        bagDto.setListPhoto(listPhoto);

//        adminRepository.create(Bag b);
//
//        for () {
//        adminRepository.create(BagPhoto bf);
//    }
    }
}

