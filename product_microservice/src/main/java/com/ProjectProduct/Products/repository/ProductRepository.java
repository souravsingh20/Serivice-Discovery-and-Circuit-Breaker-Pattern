package com.ProjectProduct.Products.repository;

import com.ProjectProduct.Products.entity.ProductEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Long> {

//    @Query("SELECT pd from productDetails pd where pd.name=?1")
//     public List<ProductEntity> getProductByName(String name);
//
//
//    @Query("SELECT pd from productDetails pd where pd.category=?1")
//    public List<ProductEntity> getProductByCategory(String category);



    Optional<ProductEntity> findByIdAndSellerId(Long id, Long sellerId);



}
