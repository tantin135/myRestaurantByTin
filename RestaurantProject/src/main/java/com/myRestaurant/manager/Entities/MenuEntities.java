package com.myRestaurant.manager.Entities;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity(name = "menu")
public class MenuEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Enumerated(EnumType.STRING)
    private DishType dishType;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public enum DishType {
        Dish, Drink, Combo;
    	
    	public static DishType fromString(String type) {
            for (DishType dishType : DishType.values()) {
                if (dishType.name().equalsIgnoreCase(type)) {
                    return dishType;
                }
            }
            throw new IllegalArgumentException("Unknown enum type " + type);
        }
    }

    // Getters and Setters
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
