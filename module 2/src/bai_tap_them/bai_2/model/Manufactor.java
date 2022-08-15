package bai_tap_them.bai_2.model;

public class Manufactor {
    private String manufactorCode;
    private String manufactorName;
    private String country;

    public Manufactor() {}

    public Manufactor(String manufactorCode, String manufactorName, String country) {
        this.manufactorCode = manufactorCode;
        this.manufactorName = manufactorName;
        this.country = country;
    }

    public String getManufactorCode() {
        return manufactorCode;
    }

    public void setManufactorCode(String manufactorCode) {
        this.manufactorCode = manufactorCode;
    }

    public String getManufactorName() {
        return manufactorName;
    }

    public void setManufactorName(String manufactorName) {
        this.manufactorName = manufactorName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Manufactor{" +
                "manufactorCode='" + manufactorCode + '\'' +
                ", manufactorName='" + manufactorName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
