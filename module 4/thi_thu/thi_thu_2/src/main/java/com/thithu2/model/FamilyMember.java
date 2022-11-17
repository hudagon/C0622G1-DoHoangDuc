package com.thithu2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class FamilyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String idCard;
    private Integer status;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "houseRegistration_id", referencedColumnName = "id")
    private HouseRegistration houseRegistration;

    public FamilyMember() {
    }

    public FamilyMember(Integer id, String name, String idCard) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public HouseRegistration getHouseRegistration() {
        return houseRegistration;
    }

    public void setHouseRegistration(HouseRegistration houseRegistration) {
        this.houseRegistration = houseRegistration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
