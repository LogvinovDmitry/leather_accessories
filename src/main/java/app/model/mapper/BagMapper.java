package app.model.mapper;

import app.model.dto.BagDto;
import app.model.entity.Bag;
import app.model.entity.BagPhoto;
import app.repository.UserRepository;
import app.repository.impl.UserRepositoryImpl;

import java.util.ArrayList;
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

//    public BagDto bagParamToDto(Bag bag) {
//        new Bag
//
//    }

//
//    public Bag bagFromRequest(HttpServletRequest request){
//
//    }

}
