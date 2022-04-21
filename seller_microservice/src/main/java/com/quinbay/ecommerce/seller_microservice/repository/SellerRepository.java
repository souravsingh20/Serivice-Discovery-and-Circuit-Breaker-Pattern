package com.quinbay.ecommerce.seller_microservice.repository;


import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<SellerEntity,Long> {
   Optional<SellerEntity> findByEmailAndPassword(String email, String password);
   Optional<SellerEntity> findByEmail(String email);
}
