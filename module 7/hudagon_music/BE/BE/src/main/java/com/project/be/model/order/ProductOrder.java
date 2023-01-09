package com.project.be.model.order;

import com.project.be.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderDate;

    private Integer deleteStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "productOrder")
    private Set<ProductOrderDetail> productOrderDetailSet;

    public ProductOrder(Integer id, String orderDate, Integer deleteStatus) {
        this.id = id;
        this.orderDate = orderDate;
        this.deleteStatus = deleteStatus;
    }

    public Set<ProductOrderDetail> getProductOrderDetailSet() {
        return productOrderDetailSet;
    }

    public void setProductOrderDetailSet(Set<ProductOrderDetail> productOrderDetailSet) {
        this.productOrderDetailSet = productOrderDetailSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
