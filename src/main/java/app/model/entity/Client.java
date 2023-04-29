package app.model.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Timestamp;


public class Client {

    private Integer clientId;
    private String clientName;
    private String clientPhone;
    private String clientNetwork;
    private String clientAddress;
    private String clientComment;
    private String clientNumber;

    private String clientDateAddedStr;

    private LocalDateTime clientDateAdded;
//    private Timestamp clientDateAdded1;
//    private LocalDate clientDateAdded2;


    public String getClientDateAddedStr() {
        return clientDateAddedStr;
    }

    public void setClientDateAddedStr(String clientDateAddedStr) {
        this.clientDateAddedStr = clientDateAddedStr;
    }

    private Double totalPrise;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientNetwork() {
        return clientNetwork;
    }

    public void setClientNetwork(String clientNetwork) {
        this.clientNetwork = clientNetwork;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public LocalDateTime getClientDateAdded() {
        return clientDateAdded;
    }

    public void setClientDateAdded(LocalDateTime clientDateAdded) {
        this.clientDateAdded = clientDateAdded;
    }

    public Double getTotalPrise() {
        return totalPrise;
    }

    public void setTotalPrise(Double totalPrise) {
        this.totalPrise = totalPrise;
    }
}
