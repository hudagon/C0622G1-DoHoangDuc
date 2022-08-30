package services;

import models.things.Facility;

public interface IFacilityService extends IService {
    void displayMaintenanceList();

    Facility getFacilityInfo();

    void addingValueToFacilityService(String serviceName);
}
