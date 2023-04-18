package com.garden.coffee.coffeegarden.product;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
@Getter
@NoArgsConstructor
@Data
public class Product {
    @Id
    @Column(name="product_id")
    private String productId;
    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private int productPrice;
    @Column(name="sale_percent")
    private int salePercent; //0% (not sale) ~ 100% (for free)

    @Builder
    public Product(String productId,String productName, int productPrice, int salePercent){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.salePercent = salePercent;
    }
}
