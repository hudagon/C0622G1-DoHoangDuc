package bai_tap_them.bai_2.model;

public abstract class Vehicle {
    private String licensePlate;
    private Manufactor manufactor;
    private int yearOfProduction;
    private String onwer;

    public Vehicle() {}

    public Vehicle(String licensePlate, Manufactor manufactor, int yearOfProduction, String onwer) {
        this.licensePlate = licensePlate;
        this.manufactor = manufactor;
        this.yearOfProduction = yearOfProduction;
        this.onwer = onwer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Manufactor getManufactor() {
        return manufactor;
    }

    public void setManufactor(Manufactor manufactor) {
        this.manufactor = manufactor;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getOnwer() {
        return onwer;
    }

    public void setOnwer(String onwer) {
        this.onwer = onwer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", manufacturer='" + manufactor + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", onwer='" + onwer + '\'' +
                '}';
    }
}
