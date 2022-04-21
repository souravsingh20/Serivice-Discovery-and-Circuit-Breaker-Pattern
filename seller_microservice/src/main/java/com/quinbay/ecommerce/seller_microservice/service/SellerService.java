package com.quinbay.ecommerce.seller_microservice.service;

import com.quinbay.ecommerce.seller_microservice.dto.Seller;

public interface SellerService {
    Seller addSeller(Seller seller);
    Seller getSellerByEmailAndPassword(String email,String password);
}
