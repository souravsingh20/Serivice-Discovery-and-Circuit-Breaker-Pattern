package com.quinbay.ecommerce.seller_microservice.service;
import com.quinbay.ecommerce.seller_microservice.dto.*;
import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import com.quinbay.ecommerce.seller_microservice.entity.SellerProductEntity;
import com.quinbay.ecommerce.seller_microservice.feign.CartFeignController;
import com.quinbay.ecommerce.seller_microservice.feign.SellerProductFeignController;
import com.quinbay.ecommerce.seller_microservice.repository.SellerProductRepository;
import com.quinbay.ecommerce.seller_microservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerProductServiceImpl implements SellerProductService{

    @Autowired
    SellerProductRepository sellerProductRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    CartFeignController cartFeignController;

    @Autowired
    SellerProductFeignController sellerProductFeignController;

    @Override
    public void addProductBySeller(SellerProduct sellerProduct){
        SellerProductEntity sellerProductEntity = new SellerProductEntity();

        Optional<SellerEntity> byId=sellerRepository.findById(sellerProduct.getSellerId());
        if(byId.isPresent()){
            sellerProductEntity.setSellerEntity(byId.get());
            sellerProductEntity.setStock(sellerProduct.getStock());
            sellerProductEntity.setPrice(sellerProduct.getPrice());
            sellerProductEntity.setId(sellerProduct.getId());
            sellerProductEntity.setSold(sellerProduct.getSold());
            sellerProductEntity.setProductId(sellerProduct.getProductId());
            sellerProductRepository.save(sellerProductEntity);
        }
    }

    @Override
    public List<SellerProduct> getAllSellerProduct() {
        Iterable<SellerProductEntity> sellerProductEntities = sellerProductRepository.findAll();
        List<SellerProduct> list = new ArrayList<>();
        for (SellerProductEntity prod : sellerProductEntities) {
            list.add(new SellerProduct(prod.getId(),
                    prod.getSellerId(),
                    prod.getProductId(),
                    prod.getPrice(),
                    prod.getStock()));
        }
        return list;
    }

    @Override
    public SellerProduct updateProductBySeller(SellerProduct sellerProduct){
        Iterable<SellerProductEntity> sellerProductEntityIterable = sellerProductRepository.findAll();
        for(SellerProductEntity sellerProductEntity :sellerProductEntityIterable){
            if(sellerProductEntity.getId() == sellerProduct.getId()){
                sellerProductEntity.setStock(sellerProduct.getStock());
                sellerProductRepository.save(sellerProductEntity);
            }
        }
        return sellerProduct;
    }

    @Override
    public void deleteProductBySeller(Long id){
        for(SellerProductEntity sellerProductEntity : sellerProductRepository.findAll()){
            if(sellerProductEntity.getId()==id){
                sellerProductRepository.deleteById(id);
                break;
            }
        }
    }

    @Override
    public Double getPrice(Long sId,Long pId){
        Optional<SellerProductEntity> sellerProductEntities = sellerProductRepository.findBySellerIdAndProductId(sId, pId);
        if(sellerProductEntities.isPresent()){
            Double price = sellerProductEntities.get().getPrice();
            return price;
        }

        return null;

    }



    @Override
    public SellerProduct getSellerProductById(Long id){
        Optional<SellerProductEntity> sellerProductEntity = sellerProductRepository.findById(id);
        if(sellerProductEntity.isPresent()) {
            return new SellerProduct(sellerProductEntity.get().getId(), sellerProductEntity.get().getSellerId(),sellerProductEntity.get().getProductId(),sellerProductEntity.get().getPrice(), sellerProductEntity.get().getStock());
        }
        else {
            throw new RuntimeException("Not Found");
        }

    }

    @Override
    public List<MoreSellers> getSellerListsByPid(Long pid){
        List<SellerProductEntity> llist = sellerProductRepository.findAllByProductId(pid);
        List<MoreSellers> moreSellersList=new ArrayList<>();
        for(SellerProductEntity sellerProductEntity : llist){
            MoreSellers moreSellers = new MoreSellers(sellerProductEntity.getSellerId(),sellerProductEntity.getPrice(),sellerProductEntity.getStock(),sellerProductEntity.getSellerEntity().getName(),sellerProductEntity.getSellerEntity().getEmail());
            moreSellersList.add(moreSellers);
        }
        return moreSellersList;
    }


    @Override
    public void updateProductStockByUser(Long id) {

        List<Cart> cart = cartFeignController.updateProductByUser(id);

        for (Cart cart1 : cart) {
            Optional<SellerProductEntity> sellerProductEntity = sellerProductRepository.findBySellerIdAndProductId(cart1.getSellerId(), cart1.getProductId());

            if (sellerProductEntity.isPresent()) {

                Long v1 = sellerProductEntity.get().getStock() - cart1.getQuantity();
                sellerProductEntity.get().setStock(v1);

                sellerProductRepository.save(sellerProductEntity.get());

            }


        }
    }

    @Override
    public List<ProductOfSeller> getProductsOfSeller(Long sellerId) {


        List<SellerProductEntity> sellerProductEntities = sellerProductRepository.findBySellerId(sellerId);
        List<ProductOfSeller> productOfSellers = new ArrayList<>();
        for (SellerProductEntity sellerProductEntity : sellerProductEntities) {
            Product product = sellerProductFeignController.getProductDetailsforSeller(sellerProductEntity.getProductId());
            ProductOfSeller productOfSeller = new ProductOfSeller(product.getId(),product.getName(), product.getDetails(), product.getImage(), product.getCategory());
            productOfSellers.add(productOfSeller);
        }


        return productOfSellers;
    }
}