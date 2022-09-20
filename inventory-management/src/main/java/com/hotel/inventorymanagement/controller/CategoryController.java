package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Category;
import com.hotel.inventorymanagement.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/test")
    public String test() {
        logger.debug("Category test endpoint called.");
        return "Testing category controller.";
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        logger.debug("Add category endpoint called.");
        return categoryService.addCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        logger.debug("List all category endpoint called.");
        return categoryService.getAllCategory();
    }

    @GetMapping("/getByCategoryID/{categoryID}")
    public Category getCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        logger.debug("Get category by category ID endpoint called.");
        return categoryService.getCategoryByCategoryID(categoryID);
    }

    @PutMapping("/updateByCategoryID/{categoryID}")
    public Category updateCategoryByCategoryID(@RequestBody Category newCategory, @PathVariable("categoryID") String categoryID) {
        logger.debug("Update category by ID endpoint called.");
        return categoryService.updateCategoryByCategoryID(categoryID, newCategory);
    }

    @DeleteMapping("/deleteByCategoryID/{categoryID}")
    public String deleteCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        categoryService.deleteCategoryByCategoryID(categoryID);
        logger.debug("Delete category by category ID endpoint called.");
        return "Deleted successfully.";
    }
}
