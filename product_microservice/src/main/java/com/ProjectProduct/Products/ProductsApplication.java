package com.ProjectProduct.Products;

//import com.ProjectProduct.Products.service.ProductService;
//import com.ProjectProduct.Products.service.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class ProductsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductsApplication.class, args);
//		ProductServiceImpl productServiceImpl= context.getBean(ProductServiceImpl.class);
	}

}
