package com.quinbay.ecommerce.seller_microservice.repository;

import com.quinbay.ecommerce.seller_microservice.dto.MoreSellers;
import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerProductRepository extends CrudRepository<SellerProductEntity, Long> {
//    @Modifying
//    @Query(value = "select sp.seller_id as id,sp.price,sp.stock,s.name,s.email from seller_product sp , seller s where sp.seller_id=s.id and sp.product_id=:pid", nativeQuery = true)
//    List<MoreSellers> getSellerListsByPid(@Param("pid") Long pid);



    List<SellerProductEntity> findAllByProductId(Long id);


    @Query(value = "select * from seller_product where seller_id = ?1",nativeQuery = true)
    List<SellerProductEntity> findBySellerId(Long sellerId);


    @Query(value = "select * from seller_product where seller_id = ?1 and product_id = ?2", nativeQuery = true)
    Optional<SellerProductEntity> findBySellerIdAndProductId(Long sellerId,Long productId);


}
