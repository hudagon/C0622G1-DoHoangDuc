package com.example.labook_be.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;
import javax.persistence.*;

@Entity
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date")
    private Date OrderDate;

    @Column(name = "delete_status", columnDefinition = "boolean default false")
    private boolean deleteStatus;

    @Column(name = "payment_status", columnDefinition = "boolean default false")
    private boolean payment_status;

    @Column(name = "total_money")
    private Long totalMoney;

    @JsonManagedReference
    @OneToMany(mappedBy = "bookOrder")
    private Set<BookOrderDetail> bookOrderDetailSet;

    public BookOrder() {
    }

    public BookOrder(long id, Date orderDate, boolean deleteStatus, boolean payment_status,
                     Long totalMoney, Set<BookOrderDetail> bookOrderDetailSet) {
        this.id = id;
        OrderDate = orderDate;
        this.deleteStatus = deleteStatus;
        this.payment_status = payment_status;
        this.totalMoney = totalMoney;
        this.bookOrderDetailSet = bookOrderDetailSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public boolean isDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public boolean isPayment_status() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Set<BookOrderDetail> getBookOrderDetailSet() {
        return bookOrderDetailSet;
    }

    public void setBookOrderDetailSet(Set<BookOrderDetail> bookOrderDetailSet) {
        this.bookOrderDetailSet = bookOrderDetailSet;
    }
}
