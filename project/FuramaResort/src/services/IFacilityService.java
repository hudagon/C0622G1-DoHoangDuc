package services;

import models.things.Facility;

import java.util.LinkedHashMap;

public interface IFacilityService extends IService {
    void displayMaintenanceList();

    Facility getFacilityInfo();

    void addingValueToFacilityService(String serviceName);

    LinkedHashMap<Facility, Integer> getFacilities();

    LinkedHashMap<Facility, Integer> getFacilityMaintenanceList();

    void setFacilityMaintenanceList(LinkedHashMap<Facility, Integer> facilityMaintenanceList);
}
