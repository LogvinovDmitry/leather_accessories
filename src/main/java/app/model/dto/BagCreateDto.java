package app.model.dto;

import java.time.LocalDate;
import java.util.List;

public class BagCreateDto {

    private Integer bagId;
    private String bagName;
    private Integer bagCategory;
    private String bagDescription;
    private Double bagPrice;
    private String mainPhotoTitle;
    private LocalDate bagDateAdded;


    private List<String> listPhoto;

    public LocalDate getBagDateAdded() {
        return bagDateAdded;
    }

    public void setBagDateAdded(LocalDate bagDateAdded) {
        this.bagDateAdded = bagDateAdded;
    }

    public Integer getBagCategory() {
        return bagCategory;
    }

    public void setBagCategory(Integer bagCategory) {
        this.bagCategory = bagCategory;
    }

    public Integer getBagId() {
        return bagId;
    }

    public void setBagId(Integer bagId) {
        this.bagId = bagId;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public String getBagDescription() {
        return bagDescription;
    }

    public void setBagDescription(String bagDescription) {
        this.bagDescription = bagDescription;
    }

    public Double getBagPrice() {
        return bagPrice;
    }

    public void setBagPrice(Double bagPrice) {
        this.bagPrice = bagPrice;
    }

    public String getMainPhotoTitle() {
        return mainPhotoTitle;
    }

    public void setMainPhotoTitle(String mainPhotoTitle) {
        this.mainPhotoTitle = mainPhotoTitle;
    }

    public List<String> getListPhoto() {
        return listPhoto;
    }

    public void setListPhoto(List<String> listPhoto) {
        this.listPhoto = listPhoto;
    }
}
