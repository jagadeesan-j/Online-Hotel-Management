package com.hotel.inventorymanagement;

import com.hotel.inventorymanagement.entity.Category;
import com.hotel.inventorymanagement.entity.Product;
import com.hotel.inventorymanagement.repository.CategoryRepository;
import com.hotel.inventorymanagement.repository.ProductRepository;
import com.hotel.inventorymanagement.service.CategoryService;
import com.hotel.inventorymanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class InventoryManagementApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getAllCategoryTest() {
        when(categoryRepository.findAll()).thenReturn(Stream.of(
				(new Category("CAT101", "Toiletry")),
                (new Category("CAT102", "Bedding")))
				.collect(Collectors.toList()));

        assertEquals(categoryRepository.findByCategoryID("CAT101"), categoryService.getCategoryByCategoryID("CAT101"));
    }

    @Test
    public void getCategoryByCategoryIDTest() {
        Category category = new Category("CAT101", "Toiletry");
        categoryRepository.save(category);

        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    public void updateCategoryByCategoryIDTest() {
        Category category = new Category("CAT101", "Toiletry");
        categoryRepository.findByCategoryID("CAT101");
        category.setCategoryName("Toiletries");
        categoryRepository.save(category);

        assertThat(category.getCategoryName()).isEqualTo("Toiletries");
    }

    @Test
    public void deleteCategoryByCategoryIDTest() {
        Category cat = new Category("CAT101", "Toiletry");
        categoryRepository.deleteByCategoryID("CAT101");

        assertEquals(0, categoryService.getAllCategory().size());
    }

    @Test
    public void getAllProductTest() {
        when(productRepository.findAll()).thenReturn(Stream.of(
                new Product("PROD101", "Soap", 50, 30, "Welcome Kit"),
                new Product("PROD102", "Pillow", 290, 3200, "Bedding"))
                .collect(Collectors.toList()));

        assertEquals(productRepository.findByProductID("PROD101"), productService.getProductByProductID("PROD101"));
    }

    @Test
    public void getProductByProductIDTest() {
        Product product = new Product("PROD101", "Soap", 50, 30, "Welcome Kit");
        productRepository.save(product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void updateProductByProductIDTest() {
        Product product = new Product("PROD101", "Soap", 50, 30, "Welcome Kit");
        productRepository.findByProductID("PROD101");
        product.setProductName("Soaps");
        productRepository.save(product);

        assertThat(product.getProductName()).isEqualTo("Soaps");
    }

    @Test
    public void deleteProductByProductIDTest() {
        Product pro = new Product("PROD101", "Soap", 50, 30, "Welcome Kit");
        productRepository.deleteByProductID("PROD101");

        assertEquals(0, productService.getAllProduct().size());
    }
}
