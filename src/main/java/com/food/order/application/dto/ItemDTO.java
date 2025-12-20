package com.food.order.application.dto;

public class ItemDTO {

    private String name;
    private double price;
    private long quantity;

    public ItemDTO(String name, double price, long quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


//    @Override
//    public String toString() {
//        return "ItemDTO{" +
//                "name='" + name + '\'' +
//                ", price=" + price +
//                ", quantity=" + quantity +
//                '}';
//    }
}
