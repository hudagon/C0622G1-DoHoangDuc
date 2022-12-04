package com.C0622G1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarHost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "carHost")
    @JsonBackReference
    private Set<Ticket> tickets;

    public CarHost() {
    }

    public CarHost(Integer id, String name, Set<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "CarHost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
