package com.example.admin.arkamilkproject.model;

public class CardItemsDataModel {
    int image;
    String name;
    String cost;
    String size;

    public CardItemsDataModel(int image, String name, String cost, String size) {
        this.image = image;
        this.name = name;
        this.cost = cost;
        this.size = size;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
