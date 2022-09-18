package com.hotel.inventorymanagement.repository;

import com.hotel.inventorymanagement.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByCategoryID(String categoryID);

    Category deleteByCategoryID(String categoryID);
}
