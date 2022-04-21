package com.quinbay.ecommerce.seller_microservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.quinbay.ecommerce.seller_microservice.dto.*;
import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;
import com.quinbay.ecommerce.seller_microservice.repository.SellerProductRepository;
import com.quinbay.ecommerce.seller_microservice.service.SellerProductService;
import com.quinbay.ecommerce.seller_microservice.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("seller")
@CrossOrigin(origins = "http://localhost:8081")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @Autowired
    SellerProductService sellerProductService;

    @Autowired
    SellerProductRepository sellerProductRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${url1}")
    private String url1;

    @Value("${url2}")
    private String url2;


    @PostMapping("/signup")
    public Seller addSeller(@RequestBody Seller seller){
       return sellerService.addSeller(seller);
    }

    @GetMapping("/authenticate")
    public Seller getSellerbyEmailAndPassword(@RequestParam String email,@RequestParam String password){
        return sellerService.getSellerByEmailAndPassword(email,password);
    }

    @PostMapping("/add-product")
    public void addProductBySeller(@RequestBody SellerProduct sellerProduct){
        sellerProductService.addProductBySeller(sellerProduct);
    }

    @GetMapping("/get-all-seller-products")
    public List<SellerProduct> getAllSellerProduct(){
        return sellerProductService.getAllSellerProduct();
    }
    @GetMapping("/get-product-byId")
    public SellerProduct getSellerProductById(@RequestParam(value = "id") Long id){
        return sellerProductService.getSellerProductById(id);
    }

    @PutMapping("/update-product")
    public void updateProductBySeller(@RequestBody SellerProduct sellerProduct){
        sellerProductService.updateProductBySeller(sellerProduct);
    }

    @DeleteMapping("/delete-product")
    public void deleteProductBySeller(@RequestParam(value = "id") Long id)
    {
        sellerProductService.deleteProductBySeller(id);
    }
    @GetMapping("/moresellers")
    public List<MoreSellers> getSellersListByPid(@RequestParam (value=" pid")Long pid){

        return sellerProductService.getSellerListsByPid(pid);

    }
    @GetMapping("/get-seller-product-lists")
    public List<ProductOfSeller> getProductsOfSeller(@RequestParam Long sellerId){
        return sellerProductService.getProductsOfSeller(sellerId);
    }

    @GetMapping("/getProductById")
    @HystrixCommand(fallbackMethod = "getFallbackProduct",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
            @HystrixProperty(name= "circuitBreaker.requestVolumeThreshold", value="3"),
            @HystrixProperty(name= "circuitBreaker.sleepWindowInMilliseconds", value="20000"),
            @HystrixProperty(name= "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public Product getProductById(@RequestParam  Long id)
    {
        Product product = restTemplate.getForObject(url1 + id, Product.class);
        return product;
    }

    public Product getFallbackProduct(@RequestParam  Long id){
        Product product = new Product(3L, 5L, "LG Tv", "40 inches LED Tv", "LG Tv image", "Electronics", 50000.00, 5L);
        return product;
    }

 @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        List<Product> product = restTemplate.getForObject(url2, List.class); // List.class is the class of response type, we should always give the class of response type of the particular api
        return product;

    }




}
