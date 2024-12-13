package com.myRestaurant.manager.Dto;

public class DishOrderDto {
    private int stt;
    private String dishName;
    private int quantity;
    private String status;

    public DishOrderDto(int stt, String dishName, int quantity, String status) {
        this.stt = stt;
        this.dishName = dishName;
        this.quantity = quantity;
        this.status = status;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}