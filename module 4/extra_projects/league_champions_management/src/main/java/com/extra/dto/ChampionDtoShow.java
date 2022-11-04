package com.extra.dto;

public class ChampionDtoShow {

    private Integer id;
    private String name;
    private String championClassName;

    public ChampionDtoShow() {
    }

    public ChampionDtoShow(Integer id, String name, String championClassName) {
        this.id = id;
        this.name = name;
        this.championClassName = championClassName;
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

    public String getChampionClassName() {
        return championClassName;
    }

    public void setChampionClassName(String championClassName) {
        this.championClassName = championClassName;
    }

}

