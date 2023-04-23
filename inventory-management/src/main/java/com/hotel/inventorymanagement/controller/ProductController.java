package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Product;
import com.hotel.inventorymanagement.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/inventory/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/test")
    @ApiOperation(value = "Tests Product Controller.",
            notes = "This API returns a string if the controller is working fine.",
            response = String.class)
    public String test() {
        logger.info("Product test endpoint called.");
        return "Testing product controller.";
    }

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) {
        logger.info("Add product endpoint called.");
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        logger.info("List all product endpoint called.");
        return productService.getAllProduct();
    }

    @GetMapping("/getByProductID/{productID}")
    public Product getProductByProductID(@PathVariable("productID") String productID) {
        logger.info("Get product by ID endpoint called.");
        return productService.getProductByProductID(productID);
    }

    @PutMapping("/updateByProductID/{productID}")
    public Product updateProduct(@Valid @RequestBody Product newProduct, @PathVariable("productID") String productID) {
        logger.info("Update product by ID endpoint called.");
        return productService.updateProductByProductID(productID, newProduct);
    }

    @DeleteMapping("/deleteByProductID/{productID}")
    public String deleteProductByProductID(@PathVariable("productID") String productID) {
        logger.info("Delete product by ID endpoint called.");
        productService.deleteProductByProductID(productID);
        return "Deleted successfully.";
    }
}
