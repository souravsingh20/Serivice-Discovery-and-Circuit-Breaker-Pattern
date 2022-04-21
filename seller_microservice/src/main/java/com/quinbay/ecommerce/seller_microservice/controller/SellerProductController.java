package com.quinbay.ecommerce.seller_microservice.controller;

import com.quinbay.ecommerce.seller_microservice.dto.SellerProduct;
import com.quinbay.ecommerce.seller_microservice.service.SellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:8081")
public class SellerProductController {

    @Autowired
    SellerProductService sellerProductService;

    @PutMapping("/update-product-stock-by-user")
    public void updateProductStockByUSer(@RequestParam Long id){
        sellerProductService.updateProductStockByUser(id);
    }

    @GetMapping("/getPrice")
    public Double getPriceFromSellerProductTable(@RequestParam Long sId,@RequestParam Long pId){
        return sellerProductService.getPrice(sId, pId);
    }
}
