package app.model.entity;


import java.util.List;

public class BagPhoto {
//    private List<String> listPhoto;
//
//    public List<String> getListPhoto() {
//        return listPhoto;
//    }
//
//    public void setListPhoto(List<String> listPhoto) {
//        this.listPhoto = listPhoto;
//    }


    private Integer bagId;

    private Integer photoId;
    private String photoTitle;



    public Integer getBagId() {
        return bagId;
    }

    public void setBagId(Integer bagId) {
        this.bagId = bagId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }
}
