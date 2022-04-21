package com.ProjectProduct.Products.feign;

//import org.springframework.cloud.netflix.feign.FeignClient;
import com.ProjectProduct.Products.dto.SellerProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "Product", url = "http://localhost:8084/")
public interface FeignController {



    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("/seller/add-product")
    public void addProductBySeller(@RequestBody SellerProduct sellerProduct);
}
