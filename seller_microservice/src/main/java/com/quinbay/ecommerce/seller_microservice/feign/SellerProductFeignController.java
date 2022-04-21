
package com.quinbay.ecommerce.seller_microservice.feign;
import com.quinbay.ecommerce.seller_microservice.dto.Cart;
import com.quinbay.ecommerce.seller_microservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@FeignClient(value = "getProductDetails" , url = "http://localhost:8082")
public interface SellerProductFeignController {
    @GetMapping("/products/getProductById")
    Product getProductDetailsforSeller(@RequestParam(value = "id") Long id);
}



