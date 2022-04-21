package com.ProjectProduct.Products.controller;
import com.ProjectProduct.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@CrossOrigin(origins = "http://localhost:8081")
public class StockUpdateController{

    @Autowired
    ProductService productService;
    @PutMapping("/update-product-stock-by-user")
    public void updateProductStockByUSer(@RequestParam Long id){
        productService.updateDefaultStocks(id);
    }
}