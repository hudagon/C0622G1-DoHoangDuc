package com.test.dto;

public class ChampionDto {

    private Integer id;
    private String name;
    private String nation;
    private String championClass;

    public ChampionDto() {
    }

    public ChampionDto(Integer id, String name, String nation, String championClass) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.championClass = championClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getChampionClass() {
        return championClass;
    }

    public void setChampionClass(String championClass) {
        this.championClass = championClass;
    }
}
