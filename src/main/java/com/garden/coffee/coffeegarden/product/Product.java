package com.garden.coffee.coffeegarden.product;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_table")
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
    private Long productPrice;
    @Column(name="sale_percent")
    private Long salePercent;

    @Builder
    public Product(String productId,String productName, Long productPrice, Long salePercent){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.salePercent = salePercent;
    }

}
