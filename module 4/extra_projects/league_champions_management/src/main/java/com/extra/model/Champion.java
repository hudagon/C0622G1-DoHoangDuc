package com.extra.model;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "championClass_id", referencedColumnName = "id")
    private ChampionClass championClass;

    public Champion() {
    }

    public Champion(Integer id, String name, ChampionClass championClass) {
        this.id = id;
        this.name = name;
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

    public ChampionClass getChampionClass() {
        return championClass;
    }

    public void setChampionClass(ChampionClass championClass) {
        this.championClass = championClass;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", championClass=" + championClass +
                '}';
    }
}
