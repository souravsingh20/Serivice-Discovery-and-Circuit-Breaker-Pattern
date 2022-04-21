package com.ProjectProduct.Products.controller;


//import com.ProjectProduct.Products.repository.ProductRepository;
import com.ProjectProduct.Products.dto.Product;
import com.ProjectProduct.Products.entity.ProductEntity;
import com.ProjectProduct.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "http://localhost:8081")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public void addProducts(@RequestBody Product product)
    {

        productService.addProducts(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts ();
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam (value = "id") Long id)
    {
        return productService.getProductById (id);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestParam(value = "id") Long id)
    {
        productService.deleteProduct (id);
    }

    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct (product);
    }

//    @GetMapping("/searchByName")
//    public Product getProductByName(@RequestParam String name){
//        return new Product((List < ProductEntity >)productService.getProductByName (name));
//    }
//
    @GetMapping("/searchByCategory")
    public List<ProductEntity> getProductByCategory(@RequestParam String category){
            return productService.getProductByCategory (category);
    }
}
