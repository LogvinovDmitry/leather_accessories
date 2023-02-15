package app.model.entity;


import java.time.LocalDate;
import java.util.List;

public class Bag {
    private Integer bagId;
    private String bagName;
    private Integer bagCategory;
    private String bagDescription;
    private LocalDate bagDateAdded;
    private Double bagPrice;
    private String bagCategoryInf;
    private String mainPhotoTitle;




    public String getMainPhotoTitle() {
        return mainPhotoTitle;
    }

    public void setMainPhotoTitle(String mainPhotoTitle) {
        this.mainPhotoTitle = mainPhotoTitle;
    }

    public Double getBagPrice() {
        return bagPrice;
    }

    public void setBagPrice(Double bagPrice) {
        this.bagPrice = bagPrice;
    }


    public LocalDate getBagDateAdded() {
        return bagDateAdded;
    }

    public void setBagDateAdded(LocalDate bagDateAdded) {
        this.bagDateAdded = bagDateAdded;
    }

    public String getBagCategoryInf() {
        return bagCategoryInf;
    }

    public void setBagCategoryInf(String bagCategoryInf) {
        this.bagCategoryInf = bagCategoryInf;
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

    public Integer getBagCategory() {
        return bagCategory;
    }

    public void setBagCategory(Integer bagCategory) {
        this.bagCategory = bagCategory;
    }

    public String getBagDescription() {
        return bagDescription;
    }

    public void setBagDescription(String bagDescription) {
        this.bagDescription = bagDescription;
    }

    //  @Override
//    public String toString() {
//        return getClass().getSimpleName() + " (movies_id: " + movies_id + "; movie_title: " + movie_title + "; genre: " + genre + "; rating: " + rating + "; producer_id: " + producer_id + ")";
//    }
}
