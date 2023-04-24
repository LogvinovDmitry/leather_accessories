package app.model.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {

    private Integer orderId;
    private Integer bagId;
    private String bagName;
    private Double bagPrice;
    private String mainPhotoTitle;
    private Integer orderQuantity;
    private Double total;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
