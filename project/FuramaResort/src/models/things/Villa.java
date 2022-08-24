package models.things;

public class Villa extends Facility {
    private String villaStandard;
    private double swimmingPoolArea;
    private int numberOfFloors;

    public Villa() {}

    public Villa(String serviceName, Double usingArea, Double rentalCosts, int maxCapacity, String leaseOptions,
                 String villaStandard, double swimmingPoolArea, int numberOfFloors) {
        super(serviceName, usingArea, rentalCosts, maxCapacity, leaseOptions);
        this.villaStandard = villaStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
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
                "Villa{" +
                "villaStandard='" + villaStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
