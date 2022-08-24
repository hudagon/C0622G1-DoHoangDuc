package models.things;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {}

    public Room(String serviceName, Double usingArea, Double rentalCosts, int maxCapacity,
                String leaseOptions, String freeServiceIncluded) {
        super(serviceName, usingArea, rentalCosts, maxCapacity, leaseOptions);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Room{" +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
