package bai_tap_them.bai_2.model;

public class Truck extends Vehicle {
    private double payload;

    public Truck() {}

    public Truck(double payload) {
        this.payload = payload;
    }

    public Truck(String licensePlate, Manufactor manufactor, int yearOfProduction, String onwer, double payload) {
        super(licensePlate, manufactor, yearOfProduction, onwer);
        this.payload = payload;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "licensePlate='" + super.getLicensePlate() + '\'' +
                ", manufacturer='" + super.getManufactor() + '\'' +
                ", yearOfProduction=" + super.getYearOfProduction() +
                ", onwer='" + super.getOnwer() + '\'' +
                ", payLoad='" + this.getPayload() + '\'' +
                '}';
    }
}
