package model.model.facility;

public class Room extends Facility {
    private String facilityFree;

    public Room() {
    }

    public Room(String name, double area, double cost, int max_people, int rentType) {
        super(name, area, cost, max_people, rentType);
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "facilityFree='" + facilityFree + '\'' +
                '}';
    }
}
