package com.quinbay.ecommerce.seller_microservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Seller's Name cannot be null")
    private String name;
    @NotBlank(message = "Seller's Email cannot be null")
    private String email;
    private String password;
    private Double ratings;


    public SellerEntity() {};

    public SellerEntity(Long id, String name, @NotBlank(message = "Seller's Email cannot be null") String email,String password, Double ratings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
        this.ratings = ratings;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }
}

