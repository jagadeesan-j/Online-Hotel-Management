package com.hotel.inventorymanagement.service.impl;

import com.hotel.inventorymanagement.entity.Product;
import com.hotel.inventorymanagement.repository.ProductRepository;
import com.hotel.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByProductID(String productID) {
        return productRepository.findByProductID(productID);
    }

    @Override
    public Product updateProductByProductID(String productID, Product newProduct) {
        Product oldProduct = productRepository.findByProductID(productID);

        if(oldProduct != null) {
            if(newProduct.getProductName()!=null && !newProduct.getProductName().isEmpty())
                oldProduct.setProductName(newProduct.getProductName());

            if(newProduct.getProductQuantity() >=0)
                oldProduct.setProductQuantity(newProduct.getProductQuantity());

            if(newProduct.getProductPrice() >= 0.0)
                oldProduct.setProductPrice(newProduct.getProductPrice());

            if(newProduct.getProductCategory()!=null && !newProduct.getProductCategory().isEmpty())
                oldProduct.setProductCategory(newProduct.getProductCategory());

            return productRepository.save(oldProduct);
        } else
            return null;
    }

    @Override
    public void deleteProductByProductID(String productID) {
        productRepository.deleteByProductID(productID);
    }
}
