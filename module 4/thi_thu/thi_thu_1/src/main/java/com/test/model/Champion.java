package com.test.model;

import javax.persistence.*;

@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String nation;
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "championClass_id", referencedColumnName = "id")
    private ChampionClass championClass;

    public Champion() {
    }

    public Champion(Integer id, String name, String nation, ChampionClass championClass) {
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

    public ChampionClass getChampionClass() {
        return championClass;
    }

    public void setChampionClass(ChampionClass championClass) {
        this.championClass = championClass;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
