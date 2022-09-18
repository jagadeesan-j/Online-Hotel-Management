package com.hotel.inventorymanagement.controller;

import com.hotel.inventorymanagement.entity.Product;
import com.hotel.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/test")
    public String test() {
        return "Testing product controller.";
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/getByProductID/{productID}")
    public Product getProductByProductID(@PathVariable("productID") String productID) {
        return productService.getProductByProductID(productID);
    }

    @PutMapping("/updateByProductID/{productID}")
    public Product updateProduct(@RequestBody Product newProduct, @PathVariable("productID") String productID) {
        return productService.updateProductByProductID(productID, newProduct);
    }

    @DeleteMapping("/deleteByProductID/{productID}")
    public String deleteProductByProductID(@PathVariable("productID") String productID) {
        productService.deleteProductByProductID(productID);
        return "Deleted successfully.";
    }
}
