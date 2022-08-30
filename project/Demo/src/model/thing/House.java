package model.thing;

public class House extends Facility {
    private int numberOfFloors;

    public House() {}

    public House(double usingArea, int maxCapacity, int numberOfFloors) {
        super(usingArea, maxCapacity);
        this.numberOfFloors = numberOfFloors;
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
                "numberOfFloors=" + numberOfFloors +
                '}';
    }
}
