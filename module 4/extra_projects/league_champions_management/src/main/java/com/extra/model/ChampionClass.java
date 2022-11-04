package com.extra.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChampionClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    @OneToMany(mappedBy = "championClass")
    private Set<Champion> champions;

    public ChampionClass() {
    }

    public ChampionClass(Integer id, String name, Set<Champion> champions) {
        this.id = id;
        this.name = name;
        this.champions = champions;
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

    public Set<Champion> getChampions() {
        return champions;
    }

    public void setChampions(Set<Champion> champions) {
        this.champions = champions;
    }

}
