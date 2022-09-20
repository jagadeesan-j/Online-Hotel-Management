package com.hotel.inventorymanagement.service.impl;

import com.hotel.inventorymanagement.entity.Category;
import com.hotel.inventorymanagement.repository.CategoryRepository;
import com.hotel.inventorymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByCategoryID(String categoryID) {
        return categoryRepository.findByCategoryID(categoryID);
    }

    @Override
    public Category updateCategoryByCategoryID(String categoryID, Category newCategory) {
        Category oldCategory = categoryRepository.findByCategoryID(categoryID);

        if (oldCategory != null) {
            if (newCategory.getCategoryName() != null && !newCategory.getCategoryName().isEmpty())
                oldCategory.setCategoryName(newCategory.getCategoryName());

            return categoryRepository.save(oldCategory);
        } else
            return null;
    }

    @Override
    public void deleteCategoryByCategoryID(String categoryID) {
        categoryRepository.deleteByCategoryID(categoryID);
    }
}
