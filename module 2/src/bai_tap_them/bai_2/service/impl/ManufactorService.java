package bai_tap_them.bai_2.service.impl;

import bai_tap_them.bai_2.model.Manufactor;

import java.util.ArrayList;
import java.util.List;

public class ManufactorService {
    static List<Manufactor> factories = new ArrayList<>();

    static {
        Manufactor companyA = new Manufactor("123", "123","123");
        Manufactor companyB = new Manufactor("456", "456","456");
        Manufactor companyC = new Manufactor("789", "789","789");
        factories.add(companyA);
        factories.add(companyB);
        factories.add(companyC);
    }

    public static List<Manufactor> getFactories() {
        return factories;
    }

    public static void setFactories(List<Manufactor> factories) {
        ManufactorService.factories = factories;
    }

}
