package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DataTransferObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto implements DataTransferObject<Product> {
    public String productId;
    public String productName;
    public Long productPrice;
    public Long salePercent;

    public ProductDto(String productId,String productName, Long productPrice, Long salePercent){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.salePercent = salePercent;
    }

    public ProductDto(Product product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.salePercent = product.getSalePercent();
    }

    @Override
    public Product toEntity() {
        return Product.builder().productId(this.productId).productName(this.productName).productPrice(this.productPrice).salePercent(this.salePercent).build();
    }

    @Override
    public DataTransferObject<Product> toDto(Product entity) {
        return null;
    }
}
