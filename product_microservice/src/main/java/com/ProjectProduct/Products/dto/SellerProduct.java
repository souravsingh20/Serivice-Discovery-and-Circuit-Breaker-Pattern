package com.ProjectProduct.Products.dto;


public class SellerProduct {
    private Long id;
    private Long sellerId;
    private Long productId;
    private double price;
    private Long stock;
    private Integer sold;

    public SellerProduct() {};

    public SellerProduct(Long sellerId, Long productId, double price, Long stock) {

        this.sellerId = sellerId;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.sold=10;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
