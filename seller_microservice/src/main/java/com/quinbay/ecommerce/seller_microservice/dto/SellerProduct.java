package com.quinbay.ecommerce.seller_microservice.dto;

public class SellerProduct {

    private Long id;
    private Long sellerId;
    private Long productId;
    private Double price;
    private Long stock;
    private Long sold;

    public SellerProduct() {};

    public SellerProduct(Long id, Long sellerId, Long productId,Double price, Long stock) {
        this.id = id;
        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.sold = 10L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setMerchantId(Long merchantId) {
        this.sellerId = merchantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }
}
