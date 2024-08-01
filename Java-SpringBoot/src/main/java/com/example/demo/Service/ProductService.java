package com.example.demo.Service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProductService {
    Product findByProductName(String productName);
    void saveProduct(Product product);
    void deleteProduct(Long id);
    void deleteAll();
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    Product getProductById(Long id);
}
