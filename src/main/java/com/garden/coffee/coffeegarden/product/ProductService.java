package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public DtoList<ProductDto> getAllProduct() {
        DtoList<ProductDto> gettingProductList = new DtoList<>(productRepository.findAll());
        return gettingProductList;
    }
    public ProductDto getProduct(String productId){
        Optional<Product> optProduct = productRepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto gettingProduct = new ProductDto(optProduct.get());
        return gettingProduct;

    }
    public ProductDto getProductByProductName(String productName) {
        Optional<Product> optProduct = productRepository.findByProductName(productName);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto searchingProduct = new ProductDto(optProduct.get());
        return searchingProduct;
    }
    public ProductDto save(ProductDto productDto){
        productDto.setProductId(UUID.randomUUID().toString().replace("-",""));
        productRepository.save(productDto.toEntity());
        return productDto;
    }

    public ProductDto deleteProduct(String productId){
        Optional<Product> optProduct = productRepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto deletingProduct = new ProductDto(optProduct.get());
        productRepository.deleteById(productId);
        return deletingProduct;
    }
}
