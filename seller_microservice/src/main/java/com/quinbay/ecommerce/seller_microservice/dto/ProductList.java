package com.quinbay.ecommerce.seller_microservice.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    List<Product> products = new ArrayList<>();

    public ProductList() {
    }

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
