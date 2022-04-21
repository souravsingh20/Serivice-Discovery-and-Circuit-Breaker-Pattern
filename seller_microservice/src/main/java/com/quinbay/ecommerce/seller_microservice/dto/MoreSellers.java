package com.quinbay.ecommerce.seller_microservice.dto;


public class MoreSellers {
    private Long id;
    private Double price;
    private Long stock;
    private String name;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MoreSellers(Long id, Double price, Long stock, String name, String email) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.email = email;
    }

    public MoreSellers() {
    }
}
