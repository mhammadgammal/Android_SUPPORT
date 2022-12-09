package com.example.shopping;

public class ShoppingModel {
    private int img;
    private String name,color,description;
    private double price;


    public ShoppingModel(int img, String name, String color, String description, double price) {
        this.img = img;
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
    }

    public ShoppingModel(int img, String name, double price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
}
