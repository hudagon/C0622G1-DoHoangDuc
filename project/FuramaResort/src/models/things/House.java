package models.things;

public class House extends Facility {
    private String houseStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, Double usingArea, Double rentalCosts, int maxCapacity,
                 String leaseOptions, String houseStandard, int numberOfFloors) {
        super(serviceName, usingArea, rentalCosts, maxCapacity, leaseOptions);
        this.houseStandard = houseStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getHouseStandard() {
        return houseStandard;
    }

    public void setHouseStandard(String houseStandard) {
        this.houseStandard = houseStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "House{" +
                "houseStandard='" + houseStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
