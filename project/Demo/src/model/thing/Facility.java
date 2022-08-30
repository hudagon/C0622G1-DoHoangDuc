package model.thing;

public abstract class Facility {
    private double usingArea;
    private int maxCapacity;

    public Facility() {}

    public Facility(double usingArea, int maxCapacity) {
        this.usingArea = usingArea;
        this.maxCapacity = maxCapacity;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "usingArea=" + usingArea +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
