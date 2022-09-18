package com.hotel.inventorymanagement.service;

import com.hotel.inventorymanagement.entity.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public List<Category> getAllCategory();

    public Category getCategoryByCategoryID(String categoryID);

    public Category updateCategoryByCategoryID(String categoryID, Category newCategory);

    public void deleteCategoryByCategoryID(String categoryID);
}
