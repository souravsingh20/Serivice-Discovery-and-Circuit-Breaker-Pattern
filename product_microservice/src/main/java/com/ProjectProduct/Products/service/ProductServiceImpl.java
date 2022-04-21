package com.ProjectProduct.Products.service;
import com.ProjectProduct.Products.dto.Cart;
import com.ProjectProduct.Products.dto.SellerProduct;
import com.ProjectProduct.Products.dto.Product;
//import com.ProjectProduct.Products.dto.SellerProduct;
import com.ProjectProduct.Products.entity.ProductEntity;
import com.ProjectProduct.Products.feign.CartFeignController;
import com.ProjectProduct.Products.feign.FeignController;
import com.ProjectProduct.Products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    ProductRepository productRepository;
    @Autowired
    FeignController feignController;
    @Autowired
    CartFeignController cartFeignController;

    @Override
    public void addProducts(Product product) {
        ProductEntity productEntity = new ProductEntity ();
        Iterable<ProductEntity> productEntities = productRepository.findAll();

        int productCount = 0;
        String productName = product.getName();
        for(ProductEntity prod : productEntities){
            if(productName.equals(prod.getName())){
                productCount++;
                break;
            }

        }
        if(productCount==0){
            productEntity.setStock(product.getStock());
            productEntity.setPrice(product.getPrice());
            productEntity.setImage(product.getImage());
            productEntity.setDetails(product.getDetails());
            productEntity.setName(product.getName());
//            productEntity.setId(product.getId());
            productEntity.setCategory (product.getCategory ());
            productEntity.setSellerId (product.getSellerId ());

            productRepository.save(productEntity);

            Long testId = productEntity.getId();
            System.out.println(testId);

            SellerProduct sp = new SellerProduct(product.getSellerId(),productEntity.getId(),product.getPrice(),product.getStock());
            feignController.addProductBySeller(sp);

        }
        if(productCount>0){
            for(ProductEntity productEntity1 : productRepository.findAll()){
                if(productEntity1.getName().equals(product.getName())){
                    Long testId = productEntity1.getId();
            SellerProduct sp = new SellerProduct(product.getSellerId(),testId,product.getPrice(),product.getStock());
            feignController.addProductBySeller(sp);
            break;
        }
//           break;
            }
        }

    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<Product> list = new ArrayList<> ();
        for (ProductEntity prod : productEntities) {
            list.add(new Product(prod.getId(),
                    prod.getSellerId(),
                    prod.getName(),
                    prod.getDetails(),
                    prod.getImage(),
                    prod.getCategory (),
                    prod.getPrice(),
                    prod.getStock()));
        }
        return list;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<ProductEntity> productEntity = productRepository.findById (id);
        if (productEntity.isPresent ( )) {
            return new Product (productEntity.get( ).getId ( ), productEntity.get ( ).getSellerId ( ), productEntity.get ( ).getName ( ), productEntity.get ( ).getDetails ( ), productEntity.get ( ).getImage ( ), productEntity.get ( ).getCategory ( ), productEntity.get ( ).getPrice ( ), productEntity.get ( ).getStock ( ));
        } else {
            throw new RuntimeException ("Not Found");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        for(ProductEntity productEntity : productRepository.findAll()){
            if(productEntity.getId()==id){
                productRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Iterable<ProductEntity> productEntityIterable = productRepository.findAll();
        for(ProductEntity productEntity :productEntityIterable){
            if(productEntity.getId() == product.getId()){
                productEntity.setStock(product.getStock());
                productEntity.setPrice (product.getPrice ());
                productRepository.save(productEntity);
            }
        }
        return product;
    }

//    @Override
//    public List<ProductEntity> getProductByName(String name) {
////        return (List<ProductEntity>) productRepository.getProductByName (name);
//        return null;
//    }

    @Override
    public List<ProductEntity> getProductByCategory(String category){
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<ProductEntity> list = new ArrayList<> ();
        for(ProductEntity prod: productEntities){
            if(prod.getCategory ().equals (category)){
                list.add(prod);
            }
        }

       return list;
    }

    @Override
    public void updateDefaultStocks(Long id){
        List<Cart> cart = cartFeignController.updateProductByUser(id);
        for(Cart cart1:cart){
            Optional<ProductEntity> productEntity = productRepository.findByIdAndSellerId(cart1.getProductId(),cart1.getSellerId());
            if(productEntity.isPresent()){
                Long v1 = productEntity.get().getStock() - cart1.getQuantity();
                productEntity.get().setStock(v1);
                productRepository.save(productEntity.get());
            }

        }
    }

}
