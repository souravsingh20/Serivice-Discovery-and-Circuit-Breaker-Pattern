package com.ProjectProduct.Products.dto;
public class Cart {

    Long cartId;
    Long productId;
    Long userId;
    Long quantity;
    Long sellerId;
    public Cart(){

    }

    public Cart(Long cartId, Long productId, Long userId, Long quantity, Long sellerId) {
        this.cartId = cartId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}