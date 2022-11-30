package com.appetite.appetite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetail {

    @Id // Makes the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetailId;

    private Integer quantity;
    private Double price;
    private Double subTotal;

    private Long foodId;
    private String foodName;

    private Long orderId;

    public OrderDetail() {
    }

    public OrderDetail(Long id, String foodName, Long orderId, Double price, Integer quantity, Double subTotal) {
        this.foodId = id;
        this.foodName = foodName;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

}
