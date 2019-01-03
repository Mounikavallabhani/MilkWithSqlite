package com.example.admin.arkamilkproject.model;

public class CardModelTwo {
    int image;
    String name;
    String size;
    String price;

    public CardModelTwo(int image, String name, String size, String price) {
        this.image = image;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
