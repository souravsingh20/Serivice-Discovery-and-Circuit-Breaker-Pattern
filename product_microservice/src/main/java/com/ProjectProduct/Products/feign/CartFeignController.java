package com.ProjectProduct.Products.feign;
import com.ProjectProduct.Products.dto.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@FeignClient(value = "cart-seller",url="http://localhost:8083")
public interface CartFeignController {
    @GetMapping("cart/get-cart-for-update")
    List<Cart> updateProductByUser(@RequestParam(value = "userId") Long id);
}
