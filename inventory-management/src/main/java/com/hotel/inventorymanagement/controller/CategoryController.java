package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Category;
import com.hotel.inventorymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/test")
    public String test() {
        return "Testing category controller.";
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/getByCategoryID/{categoryID}")
    public Category getCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        return categoryService.getCategoryByCategoryID(categoryID);
    }

    @PutMapping("/updateByCategoryID/{categoryID}")
    public Category updateCategory(@RequestBody Category newCategory, @PathVariable("categoryID") String categoryID) {
        return categoryService.updateCategoryByCategoryID(categoryID, newCategory);
    }

    @DeleteMapping("/deleteByCategoryID/{categoryID}")
    public String deleteCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        categoryService.deleteCategoryByCategoryID(categoryID);
        return "Deleted successfully.";
    }
}
