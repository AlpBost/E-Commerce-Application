package com.example.demo.UserController;

import com.example.demo.Service.JWTServiceImpl.ProductServiceImpl;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductServiceImpl ProductServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.ProductServiceImpl = productService;
    }

    @GetMapping("/productsList")
    public ResponseEntity <List<Product>> listProducts () {
        List<Product> response = ProductServiceImpl.getAllProducts();

        return ResponseEntity.ok(response);
    }


    @GetMapping("/productsListWithType")
    public ResponseEntity<List<Product>> listProductswithType(@RequestParam(name= "productType") String productType) {
        List<Product> allProducts = ProductServiceImpl.getAllProducts();
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : allProducts) {
            if(product.getProductType().equals(productType))
                filteredProducts.add(product);
        }
        return ResponseEntity.ok(filteredProducts);
    }

    @PreAuthorize("hasAuthority('SuperUser')")
    @PostMapping("/addProduct")
    public Product AddProduct(@RequestBody Product request) {
        ProductServiceImpl.saveProduct(request);
        return request;
    }

    @PreAuthorize("hasAuthority('SuperUser')")
    @PostMapping("/addNewProduct")
    public ResponseEntity<Product> AddnewProduct(@RequestBody Product request) {
        request.setAddingDate(LocalDate.now().toString());
        request.setUpdatingDate(LocalDate.now().toString());
        ProductServiceImpl.saveProduct(request);
        return ResponseEntity.ok(request);
    }

    @PreAuthorize("hasAuthority('SuperUser')")
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        Product temp = ProductServiceImpl.getProductById(product.getProductId());
        product.setAddingDate(LocalDate.now().toString());
        product.setAddingDate(temp.getAddingDate());
        product.setProductType(temp.getProductType());
        return ProductServiceImpl.updateProduct(product);
    }

    @PreAuthorize("hasAuthority('SuperUser')")
    @DeleteMapping("/{id}")
     public String DeleteProduct(@PathVariable Long id) {
         try {
             ProductServiceImpl.deleteProduct(id);
             return "success";
         } catch (RuntimeException e) {
             return e.getMessage();
         }
     }

    @PreAuthorize("hasAuthority('SuperUser')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> DeleteP(@PathVariable Long id) {
        try {
            ProductServiceImpl.deleteProduct(id);
            return ResponseEntity.ok(id);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id);
        }
    }
}
