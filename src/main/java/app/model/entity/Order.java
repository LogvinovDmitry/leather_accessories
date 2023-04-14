package app.model.entity;


import java.time.LocalDate;

public class Order {
    private Integer orderId;
    private Integer orderBagId;
    private Integer orderQuantity;
    private Integer orderClientId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderBagId() {
        return orderBagId;
    }

    public void setOrderBagId(Integer orderBagId) {
        this.orderBagId = orderBagId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getOrderClientId() {
        return orderClientId;
    }

    public void setOrderClientId(Integer orderClientId) {
        this.orderClientId = orderClientId;
    }
}
