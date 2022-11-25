package com.appetite.appetite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Order {

    @Id // Makes the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

    //private Date date;
    //private Double totalPrice;
    //private String status;
    private Long clientId;
    

    @ManyToMany(cascade = {
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.PERSIST
    }, 
    fetch = FetchType.LAZY
    )
    @JoinTable(name="order_food",
    joinColumns = @JoinColumn(name="orderId"),
    inverseJoinColumns = @JoinColumn(name="foodId"))

    List<Food> foods;



    public Order(Long orderId, Long clientId) {
        this.orderId = orderId;
        this.clientId = clientId;
    }

    public Order( ) {

    }


    
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    // public Date getDate() {
    //     return date;
    // }
    // public void setDate(Date date) {
    //     this.date = date;
    // }
    // public Double getTotalPrice() {
    //     return totalPrice;
    // }
    // public void setTotalPrice(Double totalPrice) {
    //     this.totalPrice = totalPrice;
    // }
    // public String getStatus() {
    //     return status;
    // }
    // public void setStatus(String status) {
    //     this.status = status;
    // }

    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
    public List<Food> getFoods(){
        return foods;
    }

    public void setFoods(List<Food> foods){
        this.foods = foods;
    }







    
}
