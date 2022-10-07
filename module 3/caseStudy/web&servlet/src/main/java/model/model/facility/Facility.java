package model.model.facility;

public class Facility {
    int id;
    String name;
    int area;
    double cost;
    int maxPeople;
    int rentTypeId;
    int facilityTypeId;
    String standardRoom;
    String desriptionOtherConvenience;
    double poolArea;
    int numberOfFloors;
    String facilityFree;

    public Facility() {
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, int rentTypeId, int facilityTypeId,
                    String standardRoom, String desriptionOtherConvenience, double poolArea,
                    int numberOfFloors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.standardRoom = standardRoom;
        this.desriptionOtherConvenience = desriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDesriptionOtherConvenience() {
        return desriptionOtherConvenience;
    }

    public void setDesriptionOtherConvenience(String desriptionOtherConvenience) {
        this.desriptionOtherConvenience = desriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
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
        return "Facility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", rentTypeId=" + rentTypeId +
                ", facilityTypeId=" + facilityTypeId +
                ", standardRoom='" + standardRoom + '\'' +
                ", desriptionOtherConvenience='" + desriptionOtherConvenience + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                ", facilityFree='" + facilityFree + '\'' +
                '}';
    }
}
