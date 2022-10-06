package model.model.facility;

public class House extends Facility {
    private String standardRoom;
    private String descriptionOtherConvenience;
    private int numberOfFloors;
    private String facilityFree;

    public House() {
    }

    public House(String name, double area, double cost, int max_people, int rentType, String standardRoom,
                 String descriptionOtherConvenience, int numberOfFloors, String facilityFree) {
        super(name, area, cost, max_people, rentType);
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", descriptionOtherConvenience='" + descriptionOtherConvenience + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", facilityFree='" + facilityFree + '\'' +
                '}';
    }
}
