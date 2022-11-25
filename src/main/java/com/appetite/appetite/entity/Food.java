package com.appetite.appetite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
public class Food {

    @Id // Makes the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long foodId;

	private String name;
	private String ingredients;
	private Integer calories;
	private Double price;
    private String isAvailable;
    private Integer quantity;



    @ManyToMany(cascade = {
        CascadeType.MERGE,
        CascadeType.REFRESH,
        CascadeType.PERSIST
    }, 
    fetch = FetchType.LAZY
    )
    @JoinTable(name="order_food",
    joinColumns = @JoinColumn(name="foodId"),
    inverseJoinColumns = @JoinColumn(name="orderId"))
    private List<Order> orders;




    public Food(String name, String ingredients, Integer calories, Double price, String isAvailable) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Food() {
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getFoodId() {
        return foodId;
    }
    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public Integer getCalories() {
        return calories;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public List<Order> getOrders() {
        return orders;
    }

    public void setProjects(List<Order> orders) {
        this.orders = orders;
    }


}
