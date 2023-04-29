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
    private LocalDateTime clientDateAdded;
    private Timestamp clientDateAdded1;
    private LocalDate clientDateAdded2;

    public LocalDate getClientDateAdded2() {
        return clientDateAdded2;
    }

    public void setClientDateAdded2(LocalDate clientDateAdded2) {
        this.clientDateAdded2 = clientDateAdded2;
    }

    public Timestamp getClientDateAdded1() {
        return clientDateAdded1;
    }

    public void setClientDateAdded1(Timestamp clientDateAdded1) {
        this.clientDateAdded1 = clientDateAdded1;
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
