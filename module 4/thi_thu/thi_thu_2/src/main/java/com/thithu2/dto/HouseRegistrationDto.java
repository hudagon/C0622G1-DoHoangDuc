package com.thithu2.dto;

public class HouseRegistrationDto {

    private Integer id;
    private String houseCode;
    private String hostName;
    private Integer numberOfMembers;
    private String registryDate;
    private String houseAddress;

    public HouseRegistrationDto() {
    }

    public HouseRegistrationDto(Integer id, String houseCode,
                                String hostName, Integer numberOfMembers, String registryDate, String houseAddress) {
        this.id = id;
        this.houseCode = houseCode;
        this.hostName = hostName;
        this.numberOfMembers = numberOfMembers;
        this.registryDate = registryDate;
        this.houseAddress = houseAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }
}
