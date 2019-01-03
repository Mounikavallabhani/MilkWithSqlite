package com.example.admin.arkamilkproject.model;

public  class ModelMilk {
    String image;
    String productname;
    String productml;
    String productcost;

    public ModelMilk(String image, String productname, String productml, String productcost) {
        this.image = image;
        this.productname = productname;
        this.productml = productml;
        this.productcost = productcost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductml() {
        return productml;
    }

    public void setProductml(String productml) {
        this.productml = productml;
    }

    public String getProductcost() {
        return productcost;
    }

    public void setProductcost(String productcost) {
        this.productcost = productcost;
    }
}
