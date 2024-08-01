package com.example.demo.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    @Column(nullable = false, unique = true)
    private String productName;

    @Column(nullable = false)
    private float productPrice;

    @Column(nullable = false,name = "number_of_product")
    private int numberOfProduct;

    @CreationTimestamp
    private String AddingDate;

    @UpdateTimestamp
    private String UpdatingDate;

    @Column(nullable = false)
    private String productType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {

        this.numberOfProduct = numberOfProduct;
    }

    public String getAddingDate() {
        return AddingDate;
    }

    public void setAddingDate(String addingDate) {
        addingDate.substring(0, 10);
        AddingDate = addingDate;
    }

    public String getUpdatingDate() {
        return UpdatingDate;
    }

    public void setUpdatingDate(String updatingDate) {
        updatingDate.substring(0, 10);
        UpdatingDate = updatingDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
