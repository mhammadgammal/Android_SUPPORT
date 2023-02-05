package com.example.shopping;

public class ShoppingModelImpl implements ShoppingModel {
    private int img;
    private String name,color,description;
    private double price;


    public ShoppingModelImpl(int img, String name, String color, String description, double price) {
        this.img = img;
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
    }

    public ShoppingModelImpl(int img, String name, double price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getImg() {
        return img;
    }

    @Override
    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
