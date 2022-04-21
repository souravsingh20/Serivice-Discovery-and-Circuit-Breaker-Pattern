package com.quinbay.ecommerce.seller_microservice.dto;
import java.util.List;
public class ProductOfSeller {
    private Long productId;
    private String name;
    private String details;
    private String image;
    private String category;
    public ProductOfSeller() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductOfSeller(Long productId, String name, String details, String image, String category) {
        this.productId = productId;
        this.name = name;
        this.details = details;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}