package com.quinbay.ecommerce.seller_microservice.service;


import com.quinbay.ecommerce.seller_microservice.dto.MoreSellers;
import com.quinbay.ecommerce.seller_microservice.dto.ProductOfSeller;
import com.quinbay.ecommerce.seller_microservice.dto.SellerProduct;
import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;

import java.util.List;

public interface SellerProductService {
    void addProductBySeller(SellerProduct sellerProduct);
    SellerProduct updateProductBySeller(SellerProduct sellerProduct);
    void deleteProductBySeller(Long id);
    SellerProduct getSellerProductById(Long id);
    List<SellerProduct> getAllSellerProduct();
    List<MoreSellers> getSellerListsByPid(Long pid);
    void updateProductStockByUser(Long id);
    List<ProductOfSeller> getProductsOfSeller(Long sellerId);
    Double getPrice(Long sId,Long pId);


}
