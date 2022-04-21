package com.ProjectProduct.Products.entity;


import com.sun.istack.NotNull;
import io.swagger.models.auth.In;
//import org.apache.solr.client.solrj.beans.Field;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @NotNull
    private String name,details,image,category;
    private Double price;
    private Long stock;
    private Long sellerId;

    public ProductEntity (){}

//    public ProductEntity(List<ProductEntity> productByName){}

    public ProductEntity(@NotNull Long id, @NotNull String name, @NotNull String details, @NotNull String image,@NotNull String category, Double price, Long stock, Long sellerId) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.image = image;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.sellerId = sellerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
