package com.example.admin.arkamilkproject.model;

/**
 * Created by Grepthor_9 on 2/19/2018.
 */
public  class Products {
        private String productcatagiryid;
        private String productname;
        private String Productimage;
        private String category_status;

        public Products(String productcatagiryid, String productname, String productimage, String category_status) {
                this.productcatagiryid = productcatagiryid;
                this.productname = productname;
                Productimage = productimage;
                this.category_status = category_status;
        }

        public String getProductcatagiryid() {
                return productcatagiryid;
        }

        public void setProductcatagiryid(String productcatagiryid) {
                this.productcatagiryid = productcatagiryid;
        }

        public String getProductname() {
                return productname;
        }

        public void setProductname(String productname) {
                this.productname = productname;
        }

        public String getProductimage() {
                return Productimage;
        }

        public void setProductimage(String productimage) {
                Productimage = productimage;
        }

        public String getCategory_status() {
                return category_status;
        }

        public void setCategory_status(String category_status) {
                this.category_status = category_status;
        }
}
