package model.customerDto;

public class CustomerDtoAttachService {
    private int customerId;
    private int contractId;
    private String attachFacilityName;

    public CustomerDtoAttachService() {
    }

    public CustomerDtoAttachService(int customerId, int contractId, String attachFacilityName) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.attachFacilityName = attachFacilityName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    @Override
    public String toString() {
        return "CustomerDtoAttachService{" +
                "customerId=" + customerId +
                ", contractId=" + contractId +
                ", attachFacilityName='" + attachFacilityName + '\'' +
                '}';
    }
}
