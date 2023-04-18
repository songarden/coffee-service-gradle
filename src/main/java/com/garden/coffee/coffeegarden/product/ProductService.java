package com.garden.coffee.coffeegarden.product;


import com.garden.coffee.coffeegarden.DtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductJPARepository productJPARepository;

    public DtoList<ProductDto> getAllProduct() {
        DtoList<ProductDto> gettingProductList = new DtoList<>(productJPARepository.findAll());
        return gettingProductList;
    }
    public ProductDto getProduct(String productId){
        Optional<Product> optProduct = productJPARepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto gettingProduct = new ProductDto(optProduct.get());
        return gettingProduct;

    }
    public ProductDto save(ProductDto productDto){
        productDto.setProductId(UUID.randomUUID().toString().replace("-",""));
        productJPARepository.save(productDto.toEntity());
        return productDto;
    }
    public ProductDto deleteProduct(String productId){
        Optional<Product> optProduct = productJPARepository.findById(productId);
        if(optProduct.isEmpty()){
            return null;
        }
        ProductDto deletingProduct = new ProductDto(optProduct.get());
        productJPARepository.deleteById(productId);
        return deletingProduct;
    }
}
