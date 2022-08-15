package bai_tap_them.bai_2.model;

public class Motorcycle extends Vehicle {
    private double wattage;

    public Motorcycle() {}

    public Motorcycle(double wattage) {
        this.wattage = wattage;
    }

    public Motorcycle(String licensePlate, Manufactor manufactor, int yearOfProduction, String onwer, double wattage) {
        super(licensePlate, manufactor, yearOfProduction, onwer);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "licensePlate='" + super.getLicensePlate() + '\'' +
                ", manufacturer='" + super.getManufactor() + '\'' +
                ", yearOfProduction=" + super.getYearOfProduction() +
                ", onwer='" + super.getOnwer() + '\'' +
                ", wattage='" + this.getWattage() + '\'' +
                '}';
    }
}
