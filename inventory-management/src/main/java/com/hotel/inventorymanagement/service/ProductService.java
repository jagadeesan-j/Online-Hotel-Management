package com.hotel.inventorymanagement.service;

import com.hotel.inventorymanagement.entity.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public List<Product> getAllProduct();

    public Product getProductByProductID(String productID);

    public Product updateProductByProductID(String productID, Product newProduct);

    public void deleteProductByProductID(String productID);
}
