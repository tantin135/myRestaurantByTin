package com.myRestaurant.manager.Payload.Request;

public class DishOrderRequest {
    private int dishId;
    private String status;

    public DishOrderRequest() {
    }

    public DishOrderRequest(int dishId, String status) {
        this.dishId = dishId;
        this.status = status;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}