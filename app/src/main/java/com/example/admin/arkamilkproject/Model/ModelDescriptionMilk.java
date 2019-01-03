package com.example.admin.arkamilkproject.model;

public class ModelDescriptionMilk {
     String pimage;
     String pname;
     String pml;
     String pcost;

    public ModelDescriptionMilk(String pimage, String pname, String pml, String pcost) {
        this.pimage = pimage;
        this.pname = pname;
        this.pml = pml;
        this.pcost = pcost;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPml() {
        return pml;
    }

    public void setPml(String pml) {
        this.pml = pml;
    }

    public String getPcost() {
        return pcost;
    }

    public void setPcost(String pcost) {
        this.pcost = pcost;
    }
}
