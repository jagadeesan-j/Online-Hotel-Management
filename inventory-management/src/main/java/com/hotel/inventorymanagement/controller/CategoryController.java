package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Category;
import com.hotel.inventorymanagement.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventory/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/test")
    @ApiOperation(value = "Tests Category Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test() {
        logger.info("Category test endpoint called.");
        return "Testing category controller.";
    }

    @PostMapping("/add")
    public Category addCategory(@Valid @RequestBody Category category) {
        logger.info("Add category endpoint called.");
        return categoryService.addCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategory() {
        logger.info("List all category endpoint called.");
        return categoryService.getAllCategory();
    }

    @GetMapping("/getByCategoryID/{categoryID}")
    public Category getCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        logger.info("Get category by category ID endpoint called.");
        return categoryService.getCategoryByCategoryID(categoryID);
    }

    @PutMapping("/updateByCategoryID/{categoryID}")
    public Category updateCategoryByCategoryID(@Valid @RequestBody Category newCategory, @PathVariable("categoryID") String categoryID) {
        logger.info("Update category by ID endpoint called.");
        return categoryService.updateCategoryByCategoryID(categoryID, newCategory);
    }

    @DeleteMapping("/deleteByCategoryID/{categoryID}")
    public String deleteCategoryByCategoryID(@PathVariable("categoryID") String categoryID) {
        categoryService.deleteCategoryByCategoryID(categoryID);
        logger.info("Delete category by category ID endpoint called.");
        return "Deleted successfully.";
    }
}
