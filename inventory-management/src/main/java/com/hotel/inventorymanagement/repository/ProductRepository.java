package com.hotel.inventorymanagement.repository;

import com.hotel.inventorymanagement.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByProductID(String productID);

    Product deleteByProductID(String productID);
}
