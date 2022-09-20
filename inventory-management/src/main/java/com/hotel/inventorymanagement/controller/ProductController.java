package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Product;
import com.hotel.inventorymanagement.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/test")
    public String test() {
        logger.debug("Product test endpoint called.");
        return "Testing product controller.";
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        logger.debug("Add product endpoint called.");
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        logger.debug("List all product endpoint called.");
        return productService.getAllProduct();
    }

    @GetMapping("/getByProductID/{productID}")
    public Product getProductByProductID(@PathVariable("productID") String productID) {
        logger.debug("Get product by ID endpoint called.");
        return productService.getProductByProductID(productID);
    }

    @PutMapping("/updateByProductID/{productID}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable("productID") String productID) {
        logger.debug("Update product by ID endpoint called.");
        return productService.updateProductByProductID(productID, newProduct);
    }

    @DeleteMapping("/deleteByProductID/{productID}")
    public String deleteProductByProductID(@PathVariable("productID") String productID) {
        logger.debug("Delete product by ID endpoint called.");
        productService.deleteProductByProductID(productID);
        return "Deleted successfully.";
    }
}
