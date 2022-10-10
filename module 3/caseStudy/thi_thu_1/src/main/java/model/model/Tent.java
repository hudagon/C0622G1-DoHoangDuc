package model.model;

public class Tent {
    private int idTent;
    private String tenantName;
    private String phoneNumber;
    private String startDate;
    private int payMethodId;
    private String description;

    public Tent() {
    }

    public Tent(int idTent, String tenantName, String phoneNumber, String startDate, int payMethodId, String description) {
        this.idTent = idTent;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.payMethodId = payMethodId;
        this.description = description;
    }

    public Tent(String tenantName, String phoneNumber, String startDate, int payMethodId, String description) {
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.payMethodId = payMethodId;
        this.description = description;
    }

    public int getIdTent() {
        return idTent;
    }

    public void setIdTent(int idTent) {
        this.idTent = idTent;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(int payMethodId) {
        this.payMethodId = payMethodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tent{" +
                "idTent=" + idTent +
                ", tenantName='" + tenantName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startDate='" + startDate + '\'' +
                ", payMethodId=" + payMethodId +
                ", description='" + description + '\'' +
                '}';
    }
}
