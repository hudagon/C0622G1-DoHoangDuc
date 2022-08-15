package bai_tap_them.bai_2.model;

import bai_tap_them.bai_2.service.impl.ManufactorService;

public class Car extends Vehicle {
    private int seat;

    public Car() {}

    public Car(int seat) {
        this.seat = seat;
    }

    public Car(String licensePlate, Manufactor manufactor, int yearOfProduction, String onwer, int seat) {
        super(licensePlate, manufactor, yearOfProduction, onwer);
        this.seat = seat;
    }


    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + super.getLicensePlate() + '\'' +
                ", manufacturer='" + super.getManufactor() + '\'' +
                ", yearOfProduction=" + super.getYearOfProduction() +
                ", onwer='" + super.getOnwer() + '\'' +
                ", seat='" + this.getSeat() + '\'' +
                '}';
    }
}
