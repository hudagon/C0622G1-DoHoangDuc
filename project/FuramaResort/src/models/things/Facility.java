package models.things;

public abstract class Facility {
    private String serviceName;
    private Double usingArea;
    private Double rentalCosts;
    private int maxCapacity;
    private String leaseOptions;
    private String serviceId;

    public Facility() {}

    public Facility(String serviceId, String serviceName, Double usingArea, Double rentalCosts, int maxCapacity, String leaseOptions) {
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.rentalCosts = rentalCosts;
        this.maxCapacity = maxCapacity;
        this.leaseOptions = leaseOptions;
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(Double usingArea) {
        this.usingArea = usingArea;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getLeaseOptions() {
        return leaseOptions;
    }

    public void setLeaseOptions(String leaseOptions) {
        this.leaseOptions = leaseOptions;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName=" + serviceName + '\'' +
                ", usingArea=" + usingArea +
                ", rentalCosts=" + rentalCosts +
                ", maxCapacity=" + maxCapacity +
                ", leaseOptions=" + leaseOptions + '\'' +
                ", serviceId=" + serviceId + '\'' +
                '}';
    }
}
