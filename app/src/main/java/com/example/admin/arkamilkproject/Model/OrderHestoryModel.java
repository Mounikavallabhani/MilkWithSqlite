package com.example.admin.arkamilkproject.model;

public class OrderHestoryModel {
    String nameone;
    String nametwo;
    String namethree;
    String namefour;

    public OrderHestoryModel(String nameone, String nametwo, String namethree, String namefour) {
        this.nameone = nameone;
        this.nametwo = nametwo;
        this.namethree = namethree;
        this.namefour = namefour;
    }

    public String getNameone() {
        return nameone;
    }

    public void setNameone(String nameone) {
        this.nameone = nameone;
    }

    public String getNametwo() {
        return nametwo;
    }

    public void setNametwo(String nametwo) {
        this.nametwo = nametwo;
    }

    public String getNamethree() {
        return namethree;
    }

    public void setNamethree(String namethree) {
        this.namethree = namethree;
    }

    public String getNamefour() {
        return namefour;
    }

    public void setNamefour(String namefour) {
        this.namefour = namefour;
    }
}
