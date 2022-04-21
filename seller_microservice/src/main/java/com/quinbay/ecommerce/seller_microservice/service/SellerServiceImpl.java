package com.quinbay.ecommerce.seller_microservice.service;

import com.quinbay.ecommerce.seller_microservice.dto.Seller;
import com.quinbay.ecommerce.seller_microservice.entity.SellerEntity;
import com.quinbay.ecommerce.seller_microservice.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Seller addSeller(Seller seller){
        Optional<SellerEntity> optionalSellerEntity = sellerRepository.findByEmail(seller.getEmail());
        if( optionalSellerEntity.isPresent() ){

            return null;
        }
        else{
            SellerEntity sellerEntity = new SellerEntity();
            sellerEntity.setId(seller.getId());
            sellerEntity.setName(seller.getName());
            sellerEntity.setEmail(seller.getEmail());
            sellerEntity.setPassword(seller.getPassword());
            sellerEntity.setRatings(seller.getRatings());
            SellerEntity sellerEntity1 = sellerRepository.save(sellerEntity);
            Seller seller1=new Seller(sellerEntity1.getId(),sellerEntity1.getName(),sellerEntity1.getEmail(),sellerEntity1.getPassword(),sellerEntity1.getRatings());
            return seller1;
        }


    }

    @Override
    public Seller getSellerByEmailAndPassword(String email,String password){
        Optional<SellerEntity> sellerEntity = sellerRepository.findByEmailAndPassword(email, password);

        if(sellerEntity.isPresent()){
            Seller seller = new Seller(sellerEntity.get().getId(),sellerEntity.get().getName(),sellerEntity.get().getEmail(),sellerEntity.get().getPassword(),sellerEntity.get().getRatings());
            return seller;
        }
        else{
            return null;
        }
    }
}
