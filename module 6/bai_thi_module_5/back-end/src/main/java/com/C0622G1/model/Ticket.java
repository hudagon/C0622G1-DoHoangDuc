package com.C0622G1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;
    private String startPoint;
    private String endPoint;
    private String startDate;
    private String startTime;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "carHost_id", referencedColumnName = "id")
    @JsonManagedReference
    private CarHost carHost;

    public Ticket(Integer id, Double price, String startPoint,
                  String endPoint, String startDate, String startTime, CarHost carHost) {
        this.id = id;
        this.price = price;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startDate = startDate;
        this.startTime = startTime;
        this.carHost = carHost;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public CarHost getCarHost() {
        return carHost;
    }

    public void setCarHost(CarHost carHost) {
        this.carHost = carHost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", carHost=" + carHost +
                '}';
    }


}
