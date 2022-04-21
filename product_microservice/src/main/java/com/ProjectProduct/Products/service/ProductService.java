package com.ProjectProduct.Products.service;

import com.ProjectProduct.Products.dto.Product;
import com.ProjectProduct.Products.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    void addProducts(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
    Product updateProduct(Product product);
//    List<ProductEntity> getProductByName(String name);
    List<ProductEntity> getProductByCategory(String category);
    //void addProducttoSellerDatabase(SellerProduct);
    void updateDefaultStocks(Long id);
}
